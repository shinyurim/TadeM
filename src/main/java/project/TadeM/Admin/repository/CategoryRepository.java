package project.TadeM.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.Admin.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
