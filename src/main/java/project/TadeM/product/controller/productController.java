package project.TadeM.product.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.TadeM.Admin.Service.CategoryService;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.model.productInput;
import project.TadeM.product.model.productParam;
import project.TadeM.product.service.productService;
import project.TadeM.util.PageUtil;


@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
public class productController {

	private final productService productService;
	private final CategoryService categoryService;

	@GetMapping("/product_List") // 목록
	public String categoryList(Model model, productParam parameter) {

		parameter.init();
		List<productDto> productList = productService.list(parameter);

		long totalCount = 0;

		if (!CollectionUtils.isEmpty(productList)) {
			totalCount = productList.get(0).getTotalCount();
		}
		String queryString = parameter.getQueryString();

		PageUtil pageUtil = new PageUtil(totalCount, parameter.getPageSize(),
			parameter.getPageIndex(), queryString);

		model.addAttribute("list", productList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pager", pageUtil.pager());

		return "/product/product_List";
	}

	@GetMapping(value = {"/write", "/edit"}) // 추가, 수정
	public String write(Model model, HttpServletRequest request, productInput parameter) {

		model.addAttribute("category", categoryService.list());

		boolean editMode = request.getRequestURI().contains("/edit");
		productDto detail = new productDto();

		if (editMode) {
			long id = parameter.getId();

			productDto existProduct = productService.getById(id);

			if (existProduct == null) {
				model.addAttribute("message", "정보가 존재하지 않습니다.");
				return "product/error";

			}
			detail = existProduct;

		}

		model.addAttribute("editMode", editMode);
		model.addAttribute("detail", detail);
		return "/product/write";
	}

	@PostMapping(value = {"/write", "/edit"})
	public String writeSubmit(Model model, HttpServletRequest request, productInput parameter) {

		boolean editMode = request.getRequestURI().contains("/edit");

		if (editMode){
			long id = parameter.getId();
			productDto existProduct = productService.getById(id);
			if (existProduct == null){
				model.addAttribute("message", "정보가 존재하지 않습니다.");
				return "product/error";
			}
			boolean result = productService.set(parameter);
		}else {
			boolean result = productService.write(parameter);
		}


		return "redirect:/product/product_List";
	}

	@PostMapping("/delete")
	public String del(Model model, HttpServletRequest request, productInput parameter) {

		boolean result = productService.del(parameter.getIdList());

		return "redirect:/product/product_List";
	}
}