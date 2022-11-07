package project.TadeM.product.entity;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	Long id;

	String name; // 제품 이름
	String contents; // 제품 내용
	int price; // 제품 가격
	LocalDateTime regDt; // 제품 등록일
	Date period; // 작업기간
}
