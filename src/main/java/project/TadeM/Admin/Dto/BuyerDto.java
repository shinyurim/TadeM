package project.TadeM.Admin.Dto;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class BuyerDto{

	String buyerEmail;
	String buyerName;
	String password;
	String buyerTel;
	String collectionYn;
	String provideYn;
	String paymentMailYn;
	LocalDateTime regDt;
	int myPrice;
	boolean mailAuthYn;
	String mailAuthKey;

	long totalCount;
	long seq;

}
