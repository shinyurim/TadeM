package project.TadeM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String mainPage(){ // 메인 페이지 Controller
		return "mainPage";
	}
}
