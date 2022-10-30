package project.TadeM.Admin.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Admin.Dto.SellerDto;
import project.TadeM.Admin.model.SellerParam;

@Mapper
public interface SellerMapper {

	List<SellerDto> selectList(SellerParam parameter);

	long selectListCount(SellerParam parameter);

}
