package project.TadeM.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.product.entity.product;

@Repository
public interface productRepository extends JpaRepository<product, Long> {

}
