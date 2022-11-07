package project.TadeM.requestBoard.service;

import java.util.List;
import project.TadeM.requestBoard.dto.BoardDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto board) throws Exception;

}
