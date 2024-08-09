package ph.tech.ecomm.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ph.tech.ecomm.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
