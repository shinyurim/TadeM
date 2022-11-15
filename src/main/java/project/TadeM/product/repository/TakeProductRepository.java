package project.TadeM.product.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import project.TadeM.product.entity.TakeProduct;

public interface TakeProductRepository extends JpaRepository<TakeProduct, Long> {

	long countByProductIdAndUserIdAndStatusIn(long productId, String userId,
		Collection<String> statusList);

}
