package project.TadeM.product.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.model.productParam;

@Mapper
public interface productMapper {

	long selectListCount(productParam parameter);

	List<productDto> selectList(productParam parameter);

}
