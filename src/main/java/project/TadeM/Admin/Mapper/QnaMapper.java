package project.TadeM.Admin.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Admin.Dto.NoticeDto;
import project.TadeM.Admin.Dto.QnaDto;

@Mapper
public interface QnaMapper {
	List<QnaDto> selectQnaList() throws Exception;
	void insertQna(QnaDto qna) throws Exception;
	QnaDto selectQnaDetail(int id) throws Exception;

}


