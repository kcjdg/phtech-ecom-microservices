package ph.tech.ecomm.product.dto;

import java.math.BigDecimal;

public record ProductResponse(String id
        , String name
        , BigDecimal price
        , String description) {
}
