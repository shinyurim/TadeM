package project.TadeM.product.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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

@RequiredArgsConstructor
@Service
public class productServiceImpl implements productService {

	private final productRepository productRepository;
	private final productMapper productMapper;
	private final TakeProductRepository takeProductRepository;


	@Override
	public boolean write(productInput parameter) {

		product pr = product.builder()
			.categoryId(parameter.getCategoryId())
			.name(parameter.getName())
			.contents(parameter.getContents())
			.price(parameter.getPrice())
			.period(parameter.getPeriod())
			.regDt(LocalDateTime.now())
			.build();

		productRepository.save(pr);

		return true;
	}

	@Override
	public List<productDto> list(productParam parameter) {
		long totalCount = productMapper.selectListCount(parameter);

		List<productDto> list = productMapper.selectList(parameter);
		if (!CollectionUtils.isEmpty(list)) {
			int i = 0;
			for (productDto x : list) {
				x.setTotalCount(totalCount);
				x.setSeq(totalCount - parameter.getPageStart() - i);
				i++;
			}
		}
		return list;
	}

	@Override
	public productDto getById(long id) {
		return productRepository.findById(id).map(productDto::of).orElse(null);
	}

	@Override
	public boolean set(productInput parameter) {

		Optional<product> optionalProduct = productRepository.findById(parameter.getId());
		if (!optionalProduct.isPresent()) {
			return false;
		}
		product pr = optionalProduct.get();
		pr.setName(parameter.getName());
		pr.setCategoryId((int) parameter.getCategoryId());
		pr.setContents(parameter.getContents());
		pr.setPrice(parameter.getPrice());
		pr.setPeriod(parameter.getPeriod());
		productRepository.save(pr);

		return true;
	}

	@Override
	public boolean del(String idList) { // 삭제

		if (idList != null && idList.length() > 0){
			String[] ids = idList.split(",");
			for (String x : ids){
				long id = 0L;
				try{
					id = Long.parseLong(x);
				}catch (Exception e){
				}
				if (id > 0){
					productRepository.deleteById(id);
				}
			}
		}
		return true;
	}

	@Override
	public List<productDto> frontList(productParam parameter) {

		if (parameter.getCategoryId() < 1) {
			List<product> productList = productRepository.findAll();
			return productDto.of(productList);
		}

		Optional<List<product>> optionalProducts = productRepository.findByCategoryId(parameter.getCategoryId());

		if (optionalProducts.isPresent()){
			return productDto.of(optionalProducts.get());
		}
		return null;
	}

	@Override
	public productDto frontDetail(long id) {
		productMapper.updateHitCount((int) id);
		Optional<product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()){
			return productDto.of(optionalProduct.get());
		}
		return null;
	}

	@Override
	public ServiceResult req(takeProductInput parameter) {

		ServiceResult result = new ServiceResult();

		Optional<product> optionalProduct = productRepository.findById(parameter.getCourseId());
		if (!optionalProduct.isPresent()) {
			result.setResult(false);
			result.setMessage("정보가 존재하지 않습니다.");
			return result;
		}
		product pr = optionalProduct.get();

		String[] statusList = {TakeProduct.STATUS_ING, TakeProduct.STATUS_COMPLETE};
		long count = takeProductRepository.countByProductIdAndUserIdAndStatusIn(
			pr.getId(), parameter.getUserId(), Arrays.asList(statusList));

		if (count > 0){
			result.setResult(false);
			result.setMessage("이미 신청하신 의뢰입니다.");
			return result;
		}

		TakeProduct takeProduct = TakeProduct.builder()
			.productId(pr.getId())
			.userId(parameter.getUserId())
			.payPrice(pr.getPrice())
			.regDt(LocalDateTime.now())
			.status(TakeProduct.STATUS_ING)
			.build();

		takeProductRepository.save(takeProduct);

		result.setResult(true);
		result.setMessage("");
		return result;
	}
}
