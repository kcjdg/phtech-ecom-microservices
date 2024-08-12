package ph.tech.ecomm.order_service.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI orderServiceAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Order Service API")
                        .description("REST API Documentation for Order Service")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new io.swagger.v3.oas.models.ExternalDocumentation()
                        .description("Order Service Wiki Documentation")
                        .url("https://order-service-dummy-url.com/docs"));
    }
}
