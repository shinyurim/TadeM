package project.TadeM.Admin.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Admin.Dto.CategoryDto;

@Mapper
public interface CategoryMapper {

	List<CategoryDto> select(CategoryDto parameter);

}
