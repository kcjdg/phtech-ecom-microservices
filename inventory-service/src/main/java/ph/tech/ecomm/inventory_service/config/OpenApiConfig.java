package ph.tech.ecomm.inventory_service.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryServiceAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Inventory Service API")
                        .description("REST API Documentation for Inventory Service")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new io.swagger.v3.oas.models.ExternalDocumentation()
                        .description("Inventory Service Wiki Documentation")
                        .url("https://inventory-service-dummy-url.com/docs"));
    }
}
