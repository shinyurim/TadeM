package project.TadeM.requestBoard.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.TadeM.requestBoard.mapper.BoardMapper;
import project.TadeM.requestBoard.dto.BoardDto;
import project.TadeM.requestBoard.repository.boardRepository;

@Service
@RequiredArgsConstructor
public class boardServiceImpl implements BoardService {

	private boardRepository boardRepository;

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDto> selectBoardList() throws Exception{ // 목록
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board) throws Exception { // c
		boardMapper.insertBoard(board);
	}
}
