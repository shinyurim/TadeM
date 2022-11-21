package project.TadeM.Member.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.TadeM.Member.Input.BuyerInput;
import project.TadeM.Member.Input.SellerInput;
import project.TadeM.Member.Repository.SellerRepository;
import project.TadeM.Member.Service.BuyerService;
import project.TadeM.Member.Service.SellerService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

	private final BuyerService buyerService;
	private final SellerService sellerService;
	private final SellerRepository sellerRepository;

	@GetMapping("/register_select") // 회원가입 페이지(구매자 / 판매자 선택창)
	public String register_Select() {

		return "member/register_select";
	}

	@GetMapping("/register_Buyer") // 회원가입 페이지(구매자) get
	public String register_Buyer() {

		return "member/register_Buyer";
	}

	@PostMapping("/register_Buyer") // 회원가입 페이지(구매자) post
	public String register_Buyer_submit(Model model, HttpServletRequest request,
		HttpServletResponse response, BuyerInput parameter) {

		boolean result = buyerService.register(parameter);
		model.addAttribute("result", result);

		return "member/register_complete";
	}

	@GetMapping("/register_Seller") // 회원가입 페이지(판매자) get
	public String register_Seller() {

		return "member/register_Seller";
	}

	@PostMapping("/register_Seller") // 회원가입 페이지(판매자) post
	public String register_Seller_Submit(Model model, HttpServletRequest request,
		HttpServletResponse response, SellerInput parameter) {

		boolean result = sellerService.register(parameter);
		model.addAttribute("result", result);
		return "member/register_complete";
	}

	@GetMapping("/buyer-email-auth") // 이메일 활성화 페이지(구매자전송용)
	public String BuyerEmailAuth(Model model, HttpServletRequest request) {

		String uuid = request.getParameter("id");
		log.info(uuid);
		boolean result = buyerService.BuyerEmailAuth(uuid);
		model.addAttribute("result", result);

		return "member/buyer_email_auth";
	}

	@GetMapping("/seller-email-auth") // 이메일 활성화 페이지(판매자전송용)
	public String SellerEmailAuth(Model model, HttpServletRequest request) {

		String uuid = request.getParameter("id");
		log.info(uuid);
		boolean result = sellerService.SellerEmailAuth(uuid);
		model.addAttribute("result", result);

		return "member/seller_email_auth";
	}

	@GetMapping("/login_select") // 로그인 선택창(구매자 / 판매자)
	public String loginSelect() {
		return "member/login_select";
	}

	@RequestMapping("/login") // 로그인
	public String login() {
		return "member/login";
	}

	@GetMapping("/buyer_Mypage") // 메인페이지 - 마이페이지[구매자]
	public String buyer_Mypage() {
		return "member/buyer_Mypage";
	}

	@GetMapping("/seller_Mypage") // 메인페이지 - 마이페이지[판매자]
	public String seller_Mypage() {
		return "member/seller_Mypage";
	}

	@GetMapping("/buyer_Main") //로그인성공시 구매자 메인페이지[구매자]
	public String buyer_Main() {
		return "member/buyer_Main";
	}

	@GetMapping("/seller_Main") //로그인성공시 판매자 메인페이지[판매자]
	public String seller_Main() {
		return "member/seller_Main";
	}



}



