package project.TadeM.product.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import project.TadeM.product.Dto.productDto;
import project.TadeM.product.Mapper.productMapper;
import project.TadeM.product.entity.product;
import project.TadeM.product.model.productInput;
import project.TadeM.product.model.productParam;
import project.TadeM.product.repository.productRepository;

@RequiredArgsConstructor
@Service
public class productServiceImpl implements productService {

	private final productRepository productRepository;
	private final productMapper productMapper;

	@Override
	public boolean write(productInput parameter) {

		product pr = product.builder()
			.categoryId((int) parameter.getCategoryId())
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
	public boolean del(String idList) {

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
}
