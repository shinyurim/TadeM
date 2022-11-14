package project.TadeM.product.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.TadeM.product.entity.product;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class productDto {
	long totalCount;
	long seq;

	long categoryId;

	Long id;
	String name; // 제품 이름
	String contents; // 제품 내용
	int price; // 제품 가격
	LocalDateTime regDt; // 제품 등록일
	String period; // 작업기간

	public static productDto of(product product) {

		return productDto.builder()
			.id(product.getId())
			.categoryId(product.getCategoryId())
			.name(product.getName())
			.contents(product.getContents())
			.price(product.getPrice())
			.period(product.getPeriod())
			.regDt(product.getRegDt())
			.build();
	}

	public static List<productDto> of(List<product> products){

		if (products == null){
			return null;
		}
		List<productDto> productList = new ArrayList<>();
		for (product x : products){
			productList.add(productDto.of(x));
		}
		return productList;
	}
}
