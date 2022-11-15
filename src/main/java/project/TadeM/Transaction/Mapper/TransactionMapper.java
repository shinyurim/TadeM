package project.TadeM.Transaction.Mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import project.TadeM.Transaction.Dto.TransactionDto;
import project.TadeM.Transaction.model.TransactionParam;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.model.productParam;

@Mapper
public interface TransactionMapper {

	long selectListCount(TransactionParam parameter);

	List<TransactionDto> selectList(TransactionParam parameter);

}
