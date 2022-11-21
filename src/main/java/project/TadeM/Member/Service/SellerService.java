package project.TadeM.Member.Service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import project.TadeM.Admin.Dto.SellerDto;
import project.TadeM.Admin.model.SellerParam;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.product.Dto.productDto;

public interface SellerService extends UserDetailsService{

	boolean register(SellerInput parameter);

	boolean SellerEmailAuth(String uuid);

	List<SellerDto> list(SellerParam parameter); // 판매자 목록 리턴(관리자 이용)

}
