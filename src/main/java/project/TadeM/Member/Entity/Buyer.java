package project.TadeM.Member.Entity;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "buyer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyer {

	@Id
	private String buyerEmail; // 이메일

	private String buyerName; // 이름
	private String password; // 비밀번호
	private String buyerTel; // 전화번호
	private String collectionYn; // 수집동의
	private String provideYn; // 제공동의
	private String paymentMailYn; // 결제내역발송
	private LocalDateTime regDt; // 가입일
	private int myPrice; // 금액현황
	private boolean mailAuthYn; // 메인인증여부
	private String mailAuthKey; // 메일 키

}
