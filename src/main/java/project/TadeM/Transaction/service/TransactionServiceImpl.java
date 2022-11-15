package project.TadeM.Transaction.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.TadeM.Transaction.Dto.TransactionDto;
import project.TadeM.Transaction.Mapper.TransactionMapper;
import project.TadeM.Transaction.model.TransactionParam;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.Mapper.productMapper;
import project.TadeM.product.entity.TakeProduct;
import project.TadeM.product.entity.product;
import project.TadeM.product.model.ServiceResult;
import project.TadeM.product.model.productInput;
import project.TadeM.product.model.productParam;
import project.TadeM.product.model.takeProductInput;
import project.TadeM.product.repository.TakeProductRepository;
import project.TadeM.product.repository.productRepository;
import project.TadeM.product.service.productService;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

private final TransactionMapper transactionMapper;
private final TakeProductRepository takeProductRepository;

	@Override
	public List<TransactionDto> list(TransactionParam parameter) {

		long totalCount = transactionMapper.selectListCount(parameter);
		List<TransactionDto> list = transactionMapper.selectList(parameter);
		if (!CollectionUtils.isEmpty(list)){
			int i = 0;
			for (TransactionDto x : list){
				x.setTotalCount(totalCount);
				x.setSeq(totalCount - parameter.getPageStart() - i);
				i++;
		}
		}
		return list;
	}

	@Override
	public ServiceResult updateStatus(long id, String status) {

		Optional<TakeProduct> optionalTakeProduct = takeProductRepository.findById(id);

		if (!optionalTakeProduct.isPresent()){
			return new ServiceResult(false, "정보가 존재하지 않습니다.");
		}

		TakeProduct takeProduct = optionalTakeProduct.get();

		takeProduct.setStatus(status);
		takeProductRepository.save(takeProduct);

		return new ServiceResult(true);
	}
}
