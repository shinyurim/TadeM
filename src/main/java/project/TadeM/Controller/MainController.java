package project.TadeM.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import project.TadeM.components.MailComponents;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final MailComponents mailComponents;

	@RequestMapping("/")
	public String mainPage(){ // 메인 페이지 Controller

		/*
		String email = "yurim12@naver.com";
		String subject = "테스트";
		String text = "보이나요?";
		mailComponents.sendMail(email,subject,text);*/

		return "mainPage";
	}
}
