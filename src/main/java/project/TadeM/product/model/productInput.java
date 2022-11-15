package project.TadeM.product.model;

import lombok.Data;

@Data
public class productInput {

	long id;
	String name;
	Integer categoryId;

	String contents;
	long price;
	String period;

	String idList; // 삭제위한

}
