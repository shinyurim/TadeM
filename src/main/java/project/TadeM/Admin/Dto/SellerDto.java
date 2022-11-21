package project.TadeM.Admin.Dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.TadeM.Member.Entity.Seller;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SellerDto{

	String sellerEmail;
	String sellerName;
	String password;
	String sellerTel;
	String collectionYn;
	String provideYn;
	LocalDateTime regDt;
	int myPrice;
	boolean mailAuthYn;
	String mailAuthKey;

	long totalCount;
	long seq;

}
