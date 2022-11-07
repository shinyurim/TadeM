package project.TadeM.requestBoard.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import project.TadeM.requestBoard.dto.BoardDto;
import project.TadeM.requestBoard.repository.boardRepository;
import project.TadeM.requestBoard.service.BoardService;

@Controller
@RequestMapping("/requestBoard")
@RequiredArgsConstructor
public class requestController {

	@Autowired
	private BoardService boardService;

	private boardRepository br;


	@RequestMapping("/board_List") // 메인
	public ModelAndView boardMain() throws Exception {
	ModelAndView mv = new ModelAndView("/requestBoard/board_List");
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping("/board_Write") // 작성page
	public String boardWrite() throws Exception{

		return "/requestBoard/board_Write";
	}

	@RequestMapping("/insertBoard") // 실제 작성db
	public String insertBoard(@ModelAttribute BoardDto board) throws Exception{
		boardService.insertBoard(board);
		return "redirect:/requestBoard/board_List";
	}

}
