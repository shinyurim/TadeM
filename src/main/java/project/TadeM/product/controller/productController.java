package project.TadeM.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
public class productController {


	@GetMapping("product_List") // 목록
	public String categoryList(Model model){

		return "/product/product_List";
	}
}
