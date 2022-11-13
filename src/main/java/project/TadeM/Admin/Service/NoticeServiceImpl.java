package project.TadeM.Admin.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.TadeM.Admin.Dto.NoticeDto;
import project.TadeM.Admin.Mapper.NoticeMapper;
import project.TadeM.Admin.repository.NoticeRepository;
import project.TadeM.requestBoard.dto.BoardDto;
import project.TadeM.requestBoard.mapper.BoardMapper;
import project.TadeM.requestBoard.repository.boardRepository;
import project.TadeM.requestBoard.service.BoardService;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private NoticeRepository noticeRepository;

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeDto> selectNoticeList() throws Exception { // 목록
		return noticeMapper.selectNoticeList();
	}

	@Override
	public void insertNotice(NoticeDto notice) throws Exception {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public NoticeDto selectNoticeDetail(int id) throws Exception {
		noticeMapper.updateHitCount(id);

		NoticeDto notice = noticeMapper.selectNoticeDetail(id);

		return notice;
	}
}

