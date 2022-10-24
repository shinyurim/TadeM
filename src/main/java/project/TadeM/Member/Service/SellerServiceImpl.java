package project.TadeM.Member.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.TadeM.Member.Entity.Seller;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.Member.Repository.SellerRepository;
import project.TadeM.components.MailComponents;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService{

	private final SellerRepository sellerRepository;
	private final MailComponents mailComponents;

	@Override
	public boolean register(SellerInput parameter) {
		Optional<Seller> optionalSeller = sellerRepository.findById(parameter.getSellerEmail());

		if (optionalSeller.isPresent()){ // 가입된 이메일이 존재하면
			return false;
		}

		String uuid = UUID.randomUUID().toString();

		Seller seller = Seller.builder()
			.sellerEmail(parameter.getSellerEmail())
			.sellerName(parameter.getSellerName())
			.sellerTel(parameter.getSellerTel())
			.password(parameter.getPassword())
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
			+ "<div><a target='_blank' href='http://localhost:8080/member/seller-email-auth?id=" + uuid + "'> 가입 완료 </a></div>";

		mailComponents.sendMail(email,subject,text);
		return true;
	}

	@Override
	public boolean emailAuth2(String uuid) {
		Optional<Seller> optionalSeller = sellerRepository.findByMailAuthKey(uuid);
		if (!optionalSeller.isPresent()){
			return false;
		}
		Seller seller = optionalSeller.get();
		seller.setMailAuthYn(true);
		sellerRepository.save(seller);
		return true;
	}
}