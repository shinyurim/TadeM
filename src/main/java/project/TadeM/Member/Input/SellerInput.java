package project.TadeM.Member.Input;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SellerInput { // ํ๋งค์

	private String sellerEmail;
	private String sellerName;
	private String password;
	private String sellerTel;
	private String collectionYn;
	private String provideYn;

}
