package project.TadeM.Member.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.TadeM.Admin.Dto.SellerDto;
import project.TadeM.Admin.Mapper.SellerMapper;
import project.TadeM.Admin.model.SellerParam;
import project.TadeM.Member.Entity.Seller;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.Member.Repository.SellerRepository;
import project.TadeM.Member.exception.BuyerNotEmailAuthException;
import project.TadeM.components.MailComponents;
import project.TadeM.product.Dto.productDto;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService {

	private final SellerRepository sellerRepository;
	private final MailComponents mailComponents;
	private final SellerMapper sellerMapper;

	@Override
	public boolean register(SellerInput parameter) { // 회원가입
		Optional<Seller> optionalSeller = sellerRepository.findById(parameter.getSellerEmail());

		if (optionalSeller.isPresent()) { // 가입된 이메일이 존재하면
			return false;
		}

		String uuid = UUID.randomUUID().toString();
		String encPassword = BCrypt.hashpw(parameter.getPassword(), BCrypt.gensalt());
		Seller seller = Seller.builder()
			.sellerEmail(parameter.getSellerEmail())
			.sellerName(parameter.getSellerName())
			.sellerTel(parameter.getSellerTel())
			.password(encPassword)
			.regDt(LocalDateTime.now())
			.collectionYn(parameter.getCollectionYn())
			.provideYn(parameter.getProvideYn())
			.mailAuthYn(false)
			.mailAuthKey(uuid)
			.build();

		sellerRepository.save(seller);

		String email = parameter.getSellerEmail();
		String subject = "TestM 인증 이메일입니다.";  // 다시 확인할부분 *** 왜 링크가 안걸리지2222??
		String text = "TestM에 오신것을 환영합니다. 아래 링크를 클릭하셔서 가입을 완료해주세요!"
			+ "<div><a target='_blank' href='http://localhost:8080/member/seller-email-auth?id="
			+ uuid + "'> 가입 완료 </a></div>";

		mailComponents.sendMail(email, subject, text);

		return true;
	}
	@Override
	public boolean SellerEmailAuth(String uuid) { // 이메일 인증
		Optional<Seller> optionalSeller = sellerRepository.findByMailAuthKey(uuid);
		if (!optionalSeller.isPresent()) {
			return false;
		}
		Seller seller = optionalSeller.get();
		seller.setMailAuthYn(true);
		/*Seller.builder().mailAuthYn(true).build(); // get -> builder*/
		sellerRepository.save(seller);
		return true;
	}

	@Override
	public List<SellerDto> list(SellerParam parameter) { //목록 수

		long totalCount = sellerMapper.selectListCount(parameter);

		List<SellerDto> list = sellerMapper.selectList(parameter);
		if (!CollectionUtils.isEmpty(list)) {
			int i = 0;
			for (SellerDto x : list) {
				x.setTotalCount(totalCount);
				x.setSeq(totalCount - parameter.getPageStart() - i);
				i++;
			}
		}

		return list;
	}




	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Seller> optionalSeller = sellerRepository.findById(username);
		if (!optionalSeller.isPresent()) {
			throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
		}

		Seller seller = optionalSeller.get();

		if (!seller.isMailAuthYn()) {
			throw new BuyerNotEmailAuthException("이메일을 활성화 하신 후 이용해주세요.");
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));

		return new User(seller.getSellerEmail(), seller.getPassword(), grantedAuthorities);
	}
}
