package project.TadeM.Member.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.TadeM.Admin.Dto.BuyerDto;
import project.TadeM.Admin.Mapper.BuyerMapper;
import project.TadeM.Admin.model.BuyerParam;
import project.TadeM.Member.Entity.Buyer;
import project.TadeM.Member.Input.BuyerInput;
import project.TadeM.Member.Repository.BuyerRepository;
import project.TadeM.components.MailComponents;

@RequiredArgsConstructor
@Service
public class BuyerServiceImpl implements BuyerService{

	private final BuyerRepository buyerRepository;
	private final MailComponents mailComponents;
	private final BuyerMapper buyerMapper;

	@Override
	public boolean register(BuyerInput parameter) {
		Optional<Buyer> optionalBuyer = buyerRepository.findById(parameter.getBuyerEmail());

		if (optionalBuyer.isPresent()) { // 가입된 이메일이 존재하면
			return false;
		}

		String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());
		String uuid = UUID.randomUUID().toString();

		Buyer buyer = Buyer.builder()
			.buyerEmail(parameter.getBuyerEmail())
			.buyerName(parameter.getBuyerName())
			.buyerTel(parameter.getBuyerTel())
			.password(encPassword)
			.regDt(LocalDateTime.now())
			.collectionYn(parameter.getCollectionYn())
			.provideYn(parameter.getProvideYn())
			.paymentMailYn(parameter.getPaymentMailYn())
			.mailAuthYn(false)
			.mailAuthKey(uuid)
			.build();

		buyerRepository.save(buyer);

		String email = parameter.getBuyerEmail(); // 다시 확인할부분 *** 왜 링크가 안걸리지??
		String subject = "TestM 인증 이메일입니다.";
		String text = "TestM에 오신것을 환영합니다.아래 링크를 클릭하셔서 가입을 완료해주세요!"
			+ "<div><a target='_blank' href='http://localhost:8080/member/buyer-email-auth?id="
			+ uuid + "'> 가입 완료 </a></div>";

		mailComponents.sendMail(email, subject, text);

		return true;
	}

	@Override
	public boolean BuyerEmailAuth(String uuid) { // 이메일 확인 받았을 때
		Optional<Buyer> optionalBuyer = buyerRepository.findByMailAuthKey(uuid);
		if (!optionalBuyer.isPresent()) {
			return false;
		}
		Buyer buyer = optionalBuyer.get();
		buyer.setMailAuthYn(true);
		/*Buyer.builder().mailAuthYn(true).build(); // builder로 적용이 안돼
		 */
		buyerRepository.save(buyer);
		return true;
	}

	@Override
	public List<BuyerDto> list(BuyerParam parameter) {

		long totalCount = buyerMapper.selectListCount(parameter);
		List<BuyerDto> list = buyerMapper.selectList(parameter);
		if (!CollectionUtils.isEmpty(list)) {
			int i = 0;
			for (BuyerDto x : list) {
				x.setTotalCount(totalCount);
				x.setSeq(totalCount - parameter.getPageStart() - i);
				i++;
			}
		}
		return list;

	}
}

/*	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Buyer> optionalBuyer = buyerRepository.findById(username);
		if (!optionalBuyer.isPresent()){
			throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
		}

		Buyer buyer = optionalBuyer.get();

		if (!buyer.isMailAuthYn()){
			throw new BuyerNotEmailAuthException("이메일을 활성화 하신 후 이용해주세요.");
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_BUYER"));


		return new User(buyer.getBuyerEmail(), buyer.getPassword(), grantedAuthorities );
	}*/
