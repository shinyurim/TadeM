package project.TadeM.product.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name; // 제품 이름
	String contents; // 제품 내용
	int price; // 제품 가격
	LocalDateTime regDt; // 제품 등록일
	Date period; // 작업기간
}
