package project.TadeM.product.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.product.entity.product;

@Repository
public interface productRepository extends JpaRepository<product, Long> {

	Optional<List<product>> findByCategoryId(long categoryId);
}
