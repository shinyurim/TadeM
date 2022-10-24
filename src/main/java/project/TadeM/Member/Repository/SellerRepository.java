package project.TadeM.Member.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.TadeM.Member.Entity.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, String> {

	Optional<Seller> findByMailAuthKey(String mailAuthKey);
}
