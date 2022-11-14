package project.TadeM.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.TadeM.product.model.productInput;
import project.TadeM.product.service.productService;


@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
public class productController {

	private final productService productService;

	@GetMapping("/product_List") // 목록
	public String categoryList(Model model){

		return "/product/product_List";
	}

	@GetMapping("/write") // 추가
	public String write(Model model){

		return "/product/write";
	}

	@PostMapping("/write")
	public String write(Model model, productInput parameter){

		boolean result = productService.write(parameter);

		return "redirect:/product/product_List";
	}
}
