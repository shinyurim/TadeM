package project.TadeM.Member;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class BuyerInput { // 구매자

	private String buyer_Email;
	private String user_Name;
	private String password;
	private String buyer_Tel;
	private String collection_Yn;
	private String provide_Yn;
	private String payment_Mail_Yn;

}
