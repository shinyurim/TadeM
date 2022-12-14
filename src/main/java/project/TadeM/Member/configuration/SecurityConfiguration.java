package project.TadeM.Member.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import project.TadeM.Member.Service.SellerService;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/*private final BuyerService buyerService;*/
	private final SellerService sellerService;


	/*@Bean
	PasswordEncoder getBuyerPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	@Bean
	PasswordEncoder getSellerPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CustomLoginSuccessHandler customLoginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	CustomLoginFailureHandler customLoginFailureHandler() {
		return new CustomLoginFailureHandler();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests() //로그인안해도 들어가지는 page
			.antMatchers("/",
				"/member/register_select"
				, "/member/register_Buyer"
				, "/member/register_Seller"
				, "/member/buyer_email_auth"
				, "/member/seller_email_auth"
				, "/member/login_select"
				, "/requestBoard/board_List"
				, "/requestBoard/board_Detail"
				, "/admin/notice/general_Main"
				, "/admin/qna/general_Main"
				, "/admin/notice/notice_Detail"
				, "/admin/qna/qna_Detail"
				, "/product/general/product_List"
			)
			.permitAll();

		http.formLogin()
			.loginPage("/member/login")
			.successHandler(customLoginSuccessHandler())
			.failureHandler(customLoginFailureHandler())
			.permitAll()
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
			.logoutSuccessUrl("/") // 로그아웃시 초기화면
			.invalidateHttpSession(true); // 세션 초기화

		super.configure(http);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			/*auth.userDetailsService(buyerService)
				.passwordEncoder(getBuyerPasswordEncoder());*/

		auth.userDetailsService(sellerService)
			.passwordEncoder(getSellerPasswordEncoder());

		super.configure(auth);
	}

}
