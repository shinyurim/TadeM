package project.TadeM.Admin.Controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.TadeM.Admin.Dto.NoticeDto;
import project.TadeM.Admin.Service.NoticeService;
import project.TadeM.Admin.repository.NoticeRepository;

@RequestMapping("/admin/notice")
@Controller
@RequiredArgsConstructor
public class AdminNoticeController {

	@Autowired
	private NoticeService noticeService;
	private NoticeRepository nr;


	@GetMapping("/main")//(일반)
	public ModelAndView main() throws Exception{
		ModelAndView mv = new ModelAndView("/admin/notice/main");
		List<NoticeDto> list = noticeService.selectNoticeList();
		mv.addObject("list", list);

		return mv;
	}

	@GetMapping("/general_Main")//(일반)
	public ModelAndView generalMain() throws Exception{
		ModelAndView mv = new ModelAndView("/admin/notice/general_Main");
		List<NoticeDto> list = noticeService.selectNoticeList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/notice_Write") // 작성 페이지(관리자)
	public String noticeWrite() throws Exception{

		return "/admin/notice/notice_Write";
	}

	@RequestMapping("/insertNotice") // 실제 작성 db(관리자)
	public String insertNotice(@ModelAttribute NoticeDto notice) throws Exception{
		noticeService.insertNotice(notice);
		return "redirect:/admin/notice/main";
	}

	@RequestMapping("/notice_Detail") // 상세정보(일반, 관리자)
	public ModelAndView noticeDetail(@RequestParam int id) throws Exception{
		ModelAndView mv = new ModelAndView("/admin/notice/notice_Detail");

		NoticeDto notice = noticeService.selectNoticeDetail(id);
		mv.addObject("notice", notice);

		return mv;
	}
}
