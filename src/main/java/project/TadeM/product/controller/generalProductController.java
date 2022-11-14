package project.TadeM.product.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.TadeM.Admin.Dto.CategoryDto;
import project.TadeM.Admin.Service.CategoryService;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.model.productParam;
import project.TadeM.product.service.productService;


@Controller
@RequiredArgsConstructor
public class generalProductController {

	private final productService productService;
	private final CategoryService categoryService;

	@GetMapping("/product") // 목록
	public String product(Model model, productParam parameter) {

		List<productDto> list = productService.frontList(parameter);
		model.addAttribute("list", list);

		List<CategoryDto> categoryList = categoryService.frontList(CategoryDto.builder().build());
		model.addAttribute("categoryList", categoryList);
		return "product/general_Product_List";
	}

	@GetMapping("/product/{id}") // 목록
	public String productDetail(Model model, productParam parameter) {

		productDto detail = productService.frontDetail(parameter.getId());
		model.addAttribute("detail", detail);

		return "product/general_Product_Detail";
	}
}
