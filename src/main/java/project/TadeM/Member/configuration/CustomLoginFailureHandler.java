package project.TadeM.Member.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Log4j2
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler { // 에러


	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException exception) throws IOException, ServletException {
		log.warn("Login Fail");

		setUseForward(true);
		setDefaultFailureUrl("/member/login?error=true");
		request.setAttribute("errorMessage", "로그인에 실패하였습니다.");

		super.onAuthenticationFailure(request, response, exception);
	}
}
