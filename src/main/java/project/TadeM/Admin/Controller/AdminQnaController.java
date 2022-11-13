package project.TadeM.Admin.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.TadeM.Admin.Dto.QnaDto;
import project.TadeM.Admin.Service.QnaService;
import project.TadeM.Admin.repository.QnaRepository;

@RequestMapping("/admin/qna")
@Controller
@RequiredArgsConstructor
public class AdminQnaController {

	@Autowired
	private QnaService qnaService;
	private QnaRepository qr;

	@GetMapping("/main")//(일반)
	public ModelAndView main() throws Exception{
		ModelAndView mv = new ModelAndView("/admin/qna/main");
		List<QnaDto> list = qnaService.selectQnaList();
		mv.addObject("list", list);

		return mv;
	}
	@GetMapping("/general_Main")
	public ModelAndView generalMain() throws Exception{
		ModelAndView mv = new ModelAndView("/admin/qna/general_Main");
		List<QnaDto> list = qnaService.selectQnaList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/qna_Write")
	public String qnaWrite() throws Exception{

		return "/admin/qna/qna_Write";
	}

	@RequestMapping("/insertQna")
	public String insertQna(@ModelAttribute QnaDto qna) throws Exception{
		qnaService.insertQna(qna);
		return "redirect:/admin/qna/main";
	}

	@RequestMapping("/qna_Detail")
	public ModelAndView qnaDetail(@RequestParam int id) throws Exception{
		ModelAndView mv = new ModelAndView("/admin/qna/qna_Detail");

		QnaDto qna = qnaService.selectQnaDetail(id);
		mv.addObject("qna", qna);

		return mv;
	}


}

