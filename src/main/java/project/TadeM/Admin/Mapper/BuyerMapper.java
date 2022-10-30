package project.TadeM.Admin.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Admin.Dto.BuyerDto;
import project.TadeM.Admin.model.BuyerParam;

@Mapper
public interface BuyerMapper {

	List<BuyerDto> selectList(BuyerParam parameter);

	long selectListCount(BuyerParam parameter);
}
