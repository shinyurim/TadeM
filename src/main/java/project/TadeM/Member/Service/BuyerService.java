package project.TadeM.Member.Service;

import java.util.List;
import project.TadeM.Admin.Dto.BuyerDto;
import project.TadeM.Admin.model.BuyerParam;
import project.TadeM.Member.Input.BuyerInput;

public interface BuyerService /*extends UserDetailsService*/ {

	boolean register(BuyerInput parameter);

	boolean BuyerEmailAuth(String uuid);

	List<BuyerDto> list(BuyerParam parameter); // 판매자 목록 리턴(관리자 이용)

}


