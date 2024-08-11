package ph.tech.ecomm.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ph.tech.ecomm.inventory_service.model.Inventory;

import java.beans.JavaBean;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, Integer quantity);
}
