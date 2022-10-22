package project.TadeM.Member.Entity;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "buyer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

	@Id
	private String buyer_Email; // 이메일

	private String user_Name; // 이름
	private String password; // 비밀번호
	private String buyer_Tel; // 전화번호
	private String collection_Yn; // 수집동의
	private String provide_Yn; // 제공동의
	private String payment_Mail_Yn; // 결제내역발송
	private LocalDateTime reg_Dt; // 가입일
	private int my_Price; // 금액현황

	private boolean mail_Auth_Yn; // 메인인증여부
	private String mail_Auth_Key; // 메일 키

}
