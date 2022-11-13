package project.TadeM.Admin.Service;

import java.util.List;
import project.TadeM.Admin.Dto.CategoryDto;
import project.TadeM.Admin.model.CategoryInput;

public interface CategoryService {

	List<CategoryDto> list();

	boolean add(String categoryName);
	boolean update(CategoryInput parameter);
	boolean del(long id);


}
