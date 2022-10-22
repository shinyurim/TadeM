package project.TadeM.Member.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.Member.Entity.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {

}
