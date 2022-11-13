package project.TadeM.Admin.Service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.TadeM.Admin.Dto.NoticeDto;
import project.TadeM.Admin.Dto.QnaDto;
import project.TadeM.Admin.Mapper.NoticeMapper;
import project.TadeM.Admin.Mapper.QnaMapper;
import project.TadeM.Admin.repository.NoticeRepository;
import project.TadeM.Admin.repository.QnaRepository;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService{

	private QnaRepository qnaRepository;

	@Autowired
	private QnaMapper qnaMapper;

	@Override
	public List<QnaDto> selectQnaList() throws Exception{
		return qnaMapper.selectQnaList();
	}

	@Override
	public void insertQna(QnaDto qna) throws Exception {
		qnaMapper.insertQna(qna);
	}

	@Override
	public QnaDto selectQnaDetail(int id) throws Exception {

		QnaDto qna = qnaMapper.selectQnaDetail(id);

		return qna;
	}

}

