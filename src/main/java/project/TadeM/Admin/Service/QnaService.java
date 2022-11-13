package project.TadeM.Admin.Service;

import java.util.List;
import project.TadeM.Admin.Dto.QnaDto;

public interface QnaService {

	List<QnaDto> selectQnaList() throws Exception; // 목록
	void insertQna(QnaDto qna) throws Exception; // 작성
	QnaDto selectQnaDetail(int id) throws Exception; // 목록 상세

}