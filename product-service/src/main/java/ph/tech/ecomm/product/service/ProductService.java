package ph.tech.ecomm.product.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ph.tech.ecomm.product.dto.ProductRequest;
import ph.tech.ecomm.product.dto.ProductResponse;
import ph.tech.ecomm.product.model.Product;
import ph.tech.ecomm.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        var product = Product.builder()
                .name(productRequest.name())
                .skuCode(productRequest.skuCode())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created succesfully");
        return  new ProductResponse(product.getId(), product.getName(), product.getSkuCode(), product.getPrice(), product.getDescription());
    }


    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(),product.getSkuCode(), product.getPrice(), product.getDescription()))
                .toList();
    }
}
