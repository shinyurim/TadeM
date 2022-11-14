package project.TadeM.Admin.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Admin.Dto.NoticeDto;

@Mapper
public interface NoticeMapper {
	List<NoticeDto> selectNoticeList() throws Exception;
	void insertNotice(NoticeDto notice) throws Exception;
	NoticeDto selectNoticeDetail(int id) throws Exception;

}


