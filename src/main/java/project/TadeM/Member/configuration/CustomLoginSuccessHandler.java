package project.TadeM.Member.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication auth) throws IOException, ServletException {
		log.warn("Login Success");

		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(grantedAuthority -> {
			roleNames.add(grantedAuthority.getAuthority());
		});
		log.warn("ROLE NAMES : " + roleNames); // 확인용

		if(roleNames.contains("ROLE_ADMIN")) { // 관리자
			response.sendRedirect("/admin/main");
			return;
		}
		if(roleNames.contains("ROLE_BUYER")) { // 구매자
			response.sendRedirect("/member/buyer_Main");
			return;
		}
		if(roleNames.contains("ROLE_SELLER")) { // 판매자
			response.sendRedirect("/member/seller_Main");
			return;
		}

	}


}
