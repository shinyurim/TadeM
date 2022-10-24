package project.TadeM.Member.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.TadeM.Member.Input.BuyerInput;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.Member.Service.BuyerService;
import project.TadeM.Member.Service.SellerService;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final BuyerService buyerService;
	private final SellerService sellerService;

	@GetMapping("/member/register_select") // 회원가입 페이지(구매자 / 판매자 선택창)
	public String register_Select() {

		return "member/register_select";
	}

	@GetMapping("/member/register_Buyer") // 회원가입 페이지(구매자) get
	public String register_Buyer() {

		return "member/register_Buyer";
	}

	@PostMapping("/member/register_Buyer") // 회원가입 페이지(구매자) post
	public String register_Buyer_submit(Model model, HttpServletRequest request, HttpServletResponse response, BuyerInput parameter) {

		boolean result = buyerService.register(parameter);
		model.addAttribute("result", result);

		return "member/register_complete";
	}

	@GetMapping("/member/register_Seller") // 회원가입 페이지(판매자) get
	public String register_Seller() {

		return "member/register_Seller";
	}

	@PostMapping("/member/register_Seller") // 회원가입 페이지(판매자) post
	public String register_Seller_Submit(Model model, HttpServletRequest request, HttpServletResponse response, SellerInput parameter) {

		boolean result = sellerService.register(parameter);
		model.addAttribute("result", result);
		System.out.println(result);
		return "member/register_complete";
	}

	@GetMapping("/member/buyer-email-auth") // 이메일 활성화 페이지(구매자전송용)
	public String emailAuth(Model model, HttpServletRequest request){

		String uuid = request.getParameter("id");
		System.out.println(uuid);

		boolean result = buyerService.emailAuth(uuid);
		model.addAttribute("result", result);

		return "member/buyer_email_auth";
	}

	@GetMapping("/member/seller-email-auth") // 이메일 활성화 페이지(판매자전송용)
	public String emailAuth2(Model model, HttpServletRequest request){

		String uuid = request.getParameter("id");
		System.out.println(uuid);

		boolean result = sellerService.emailAuth2(uuid);
		model.addAttribute("result", result);

		return "member/seller_email_auth";
	}
}
