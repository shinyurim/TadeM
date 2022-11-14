package project.TadeM.Order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.TadeM.Order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
