package project.TadeM.product.controller;

import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.TadeM.Admin.Service.CategoryService;
import project.TadeM.product.model.ServiceResult;
import project.TadeM.product.model.takeProductInput;
import project.TadeM.product.service.productService;

@RestController
@RequiredArgsConstructor
public class apiProductController {
	private final productService productService;
	private final CategoryService categoryService;

	@PostMapping("/api/product/req")
	public ResponseEntity<?> productReq(Model model, @RequestBody takeProductInput parameter
	, Principal principal) {

		parameter.setUserId(principal.getName());

		ServiceResult result = productService.req(parameter);

		if (!result.isResult()){
			return ResponseEntity.ok().body(result.getMessage());
		}

		return ResponseEntity.ok().body(parameter);
	}
	}

