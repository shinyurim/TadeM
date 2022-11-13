package project.TadeM.requestBoard.service;

import java.util.List;
import project.TadeM.requestBoard.dto.BoardDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception; // 목록
	void insertBoard(BoardDto board) throws Exception; // 작성

	BoardDto selectBoardDetail(int id) throws Exception; // 목록 상세


}
