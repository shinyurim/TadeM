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
		Optional<Buyer> optionalBuyer = buyerRepository.findById(parameter.getBuyer_Email());

		if (optionalBuyer.isPresent()){ // 가입된 이메일이 존재하면
			return false;
		}

		String uuid = UUID.randomUUID().toString();

		Buyer buyer = new Buyer();
		buyer.setBuyer_Email(parameter.getBuyer_Email());
		buyer.setUser_Name(parameter.getUser_Name());
		buyer.setPassword(parameter.getPassword());
		buyer.setBuyer_Tel(parameter.getBuyer_Tel());
		buyer.setCollection_Yn(parameter.getCollection_Yn());
		buyer.setProvide_Yn(parameter.getProvide_Yn());
		buyer.setPayment_Mail_Yn(parameter.getPayment_Mail_Yn());
		buyer.setReg_Dt(LocalDateTime.now());

		buyer.setMail_Auth_Yn(false);
		buyer.setMail_Auth_Key(UUID.randomUUID().toString());

		buyerRepository.save(buyer);

		String email = parameter.getBuyer_Email();
		String subject = "TestM 인증 이메일입니다.";
		String text = "<p>TestM에 오신것을 환영합니다.<p><p>아래 링크를 클릭하셔서 가입을 완료해주세요!"
			+ "</p><div><a href='http://localhost:8080/member/buyer-email-auth?id=97eec864-4f91-486c-a71d-d9d9b29e7d81</a></div>";

		mailComponents.sendMail(email,subject,text);

		return true;
	}
}
