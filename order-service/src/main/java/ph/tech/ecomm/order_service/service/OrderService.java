package ph.tech.ecomm.order_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.tech.ecomm.order_service.dto.OrderRequest;
import ph.tech.ecomm.order_service.model.Order;
import ph.tech.ecomm.order_service.repository.OrderRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }
}
