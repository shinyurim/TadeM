package project.TadeM.requestBoard.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.requestBoard.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
	void insertBoard(BoardDto board) throws Exception;
	void updateHitCount(int id) throws Exception;
	BoardDto selectBoardDetail(int id) throws Exception;


}
