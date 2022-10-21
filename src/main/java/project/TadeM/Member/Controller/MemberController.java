package project.TadeM.Member.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import project.TadeM.Member.Input.BuyerInput;
import project.TadeM.Member.Input.SellerInput;

@Controller
public class MemberController {

	@GetMapping("/member/register_select") // 회원가입 페이지(구매자 / 판매자 선택창)
	public String register_Select() {

		return "member/register_select";
	}

	@GetMapping("/member/register_Buyer") // 회원가입 페이지(구매자) get
	public String register_Buyer() {

		return "member/register_Buyer";
	}

	@PostMapping("/member/register_Buyer") // 회원가입 페이지(구매자) post
	public String register_Buyer_submit(HttpServletRequest request, HttpServletResponse response, BuyerInput parameter) {

		System.out.println(parameter.toString()); // 결과 정상출력

		return "member/register_Buyer";
	}

	@GetMapping("/member/register_Seller") // 회원가입 페이지(판매자) get
	public String register_Seller() {

		return "member/register_Seller";
	}

	@PostMapping("/member/register_Seller") // 회원가입 페이지(판매자) post
	public String register_Seller_Submit(HttpServletRequest request, HttpServletResponse response, SellerInput parameter) {

		System.out.println(parameter.toString()); // 결과 정상출력

		return "member/register_Seller";
	}
}
