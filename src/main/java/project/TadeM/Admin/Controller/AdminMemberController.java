package project.TadeM.Admin.Controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.TadeM.Admin.Dto.BuyerDto;
import project.TadeM.Admin.Dto.SellerDto;
import project.TadeM.Admin.model.BuyerParam;
import project.TadeM.Admin.model.SellerParam;
import project.TadeM.Member.Service.BuyerService;
import project.TadeM.Member.Service.SellerService;
import project.TadeM.util.PageUtil;


@RequiredArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminMemberController {

	private final SellerService sellerService;
	private final BuyerService buyerService;

	@GetMapping("/member_List_Select") // 관리자 - 회원관리 선택창
	public String member_Select() {
		return "admin/member_List_Select";
	}


	@GetMapping("/member_List_Seller") // 관리자 - 회원관리(판매자)
	public String member_Seller(Model model, SellerParam parameter) {

		parameter.init();

		List<SellerDto> sellers = sellerService.list(parameter);

		long totalCount = 0;
		if (sellers != null && sellers.size() > 0) {
			totalCount = sellers.get(0).getTotalCount();
		}

		String queryString = parameter.getQueryString();
		PageUtil pageUtil = new PageUtil(totalCount, parameter.getPageSize(),
			parameter.getPageIndex(), queryString);
		model.addAttribute("pager", pageUtil.pager());
		model.addAttribute("list", sellers);
		model.addAttribute("totalCount", totalCount);
		return "/admin/member_List_Seller";
	}


	@GetMapping("/member_List_Buyer") // 관리자 - 회원관리(구매자)
	public String member_Buyer(Model model, BuyerParam parameter) {

		parameter.init();

		List<BuyerDto> buyers = buyerService.list(parameter);
		long totalCount = 0;
		if (buyers != null && buyers.size() > 0) {
			totalCount = buyers.get(0).getTotalCount();
		}
		String queryString = parameter.getQueryString();
		PageUtil pageUtil = new PageUtil(totalCount, parameter.getPageSize(),
			parameter.getPageIndex(), queryString);
		model.addAttribute("pager", pageUtil.pager());
		model.addAttribute("list", buyers);
		model.addAttribute("totalCount", totalCount);

		return "/admin/member_List_Buyer";
	}

}
