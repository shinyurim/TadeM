package project.TadeM.Member.Input;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BuyerInput { // 구매자

	private String buyerEmail;
	private String buyerName;
	private String password;
	private String buyerTel;
	private String collectionYn;
	private String provideYn;
	private String paymentMailYn;

}
