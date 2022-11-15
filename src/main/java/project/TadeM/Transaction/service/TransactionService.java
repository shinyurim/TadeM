package project.TadeM.Transaction.service;

import java.util.List;
import project.TadeM.Transaction.Dto.TransactionDto;
import project.TadeM.Transaction.model.TransactionParam;
import project.TadeM.product.model.ServiceResult;

public interface TransactionService {

	List<TransactionDto> list(TransactionParam parameter); // 의뢰 목록

	ServiceResult updateStatus(long id, String status); // 주문상태 변경

}
