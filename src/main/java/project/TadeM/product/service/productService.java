package project.TadeM.product.service;

import java.util.List;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.model.productInput;
import project.TadeM.product.model.productParam;

public interface productService {

	boolean write(productInput parameter); // 글 작성

	List<productDto> list(productParam parameter); // 내제품 목록

	productDto getById(long id); // 제품 상세정보

	boolean set(productInput parameter); // 제품정보 수정

	boolean del(String idList); // 제품정보 삭제
}
