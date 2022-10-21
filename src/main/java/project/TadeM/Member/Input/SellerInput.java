package project.TadeM.Member.Input;


import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class SellerInput { // 판매자

	private String seller_Email;
	private String user_Name;
	private String password;
	private String seller_Tel;
	private String collection_Yn;
	private String provide_Yn;

}
