package ph.tech.ecomm.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.tech.ecomm.order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
