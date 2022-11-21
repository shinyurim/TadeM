package project.TadeM.Member.Entity;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.TadeM.Admin.Dto.SellerDto;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.entity.product;

@Entity(name = "seller")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Seller{

	@Id
	private String sellerEmail; // 이메일

	private String sellerName; // 이름
	private String password; // 비밀번호
	private String sellerTel; // 전화번호
	private String collectionYn; // 수집동의
	private String provideYn; // 제공동의
	private LocalDateTime regDt; // 가입일
	private int myPrice; // 금액현황
	private boolean mailAuthYn; // 메인인증여부
	private String mailAuthKey; // 메일 키

}
