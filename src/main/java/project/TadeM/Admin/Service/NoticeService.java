package project.TadeM.Admin.Service;

import java.util.List;
import project.TadeM.Admin.Dto.NoticeDto;
import project.TadeM.requestBoard.dto.BoardDto;

public interface NoticeService {

	List<NoticeDto> selectNoticeList() throws Exception; // 목록
	void insertNotice(NoticeDto notice) throws Exception; // 작성

	NoticeDto selectNoticeDetail(int id) throws Exception; // 목록 상세


}

