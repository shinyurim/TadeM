package project.TadeM.Member.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.TadeM.Member.Entity.Buyer;
import project.TadeM.Member.Input.BuyerInput;
import project.TadeM.Member.Repository.BuyerRepository;
import project.TadeM.components.MailComponents;

@RequiredArgsConstructor
@Service
public class BuyerServiceImpl implements BuyerService{

	private final BuyerRepository buyerRepository;
	private final MailComponents mailComponents;

	@Override
	public boolean register(BuyerInput parameter) {
		Optional<Buyer> optionalBuyer = buyerRepository.findById(parameter.getBuyerEmail());

		if (optionalBuyer.isPresent()){ // 가입된 이메일이 존재하면
			return false;
		}

		String uuid = UUID.randomUUID().toString();

		Buyer buyer = Buyer.builder()
			.buyerEmail(parameter.getBuyerEmail())
			.buyerName(parameter.getBuyerName())
			.buyerTel(parameter.getBuyerTel())
			.password(parameter.getPassword())
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
			+ "<div><a target='_blank' href='http://localhost:8080/member/buyer-email-auth?id=" + uuid + "'> 가입 완료 </a></div>";

		mailComponents.sendMail(email,subject,text);

		return true;
	}

	@Override
	public boolean emailAuth(String uuid) { // 이메일 확인 받았을 때
		Optional<Buyer> optionalBuyer = buyerRepository.findByMailAuthKey(uuid);
		if (!optionalBuyer.isPresent()){
			return false;
		}
		Buyer buyer = optionalBuyer.get();
		buyer.setMailAuthYn(true);
		buyerRepository.save(buyer);
		return true;
	}

}
