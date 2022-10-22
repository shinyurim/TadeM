package project.TadeM.Member.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.TadeM.Member.Entity.Seller;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.Member.Repository.SellerRepository;

@RequiredArgsConstructor
@Service
public class SellerServiceImpl implements SellerService{

	private final SellerRepository sellerRepository;

	@Override
	public boolean register(SellerInput parameter) {
		Optional<Seller> optionalSeller = sellerRepository.findById(parameter.getSeller_Email());

		if (optionalSeller.isPresent()){ // 가입된 이메일이 존재하면
			return false;
		}

		Seller seller = new Seller();
		seller.setSeller_Email(parameter.getSeller_Email());
		seller.setUser_Name(parameter.getUser_Name());
		seller.setPassword(parameter.getPassword());
		seller.setSeller_Tel(parameter.getSeller_Tel());
		seller.setCollection_Yn(parameter.getCollection_Yn());
		seller.setProvide_Yn(parameter.getProvide_Yn());
		seller.setReg_Dt(LocalDateTime.now());
		seller.setMail_Auth_Yn(false);
		seller.setMail_Auth_Key(UUID.randomUUID().toString());

		sellerRepository.save(seller);
		return true;
	}
}
