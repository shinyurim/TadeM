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

		return "mainPage";
	}
}
