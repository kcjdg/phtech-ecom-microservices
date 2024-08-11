package ph.tech.ecomm.order_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ph.tech.ecomm.order_service.client.InventoryClient;
import ph.tech.ecomm.order_service.dto.OrderRequest;
import ph.tech.ecomm.order_service.model.Order;
import ph.tech.ecomm.order_service.repository.OrderRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        }else{
            throw new RuntimeException("Product wih skuCode: "+orderRequest.skuCode()+" is out of stock");
        }
    }
}
