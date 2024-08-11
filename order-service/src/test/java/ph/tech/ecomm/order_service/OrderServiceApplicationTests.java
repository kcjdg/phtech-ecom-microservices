package ph.tech.ecomm.order_service;

import io.restassured.RestAssured;
import jakarta.websocket.server.ServerEndpoint;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {


    @ServiceConnection
    static MySQLContainer mysqlContainer = new MySQLContainer<>("mysql:8.3.0");
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mysqlContainer.start();

    }

    @Test
    void shouldSubmitOrder() {
    	var json = """
				{
				    "skuCode": "iphone_15",
				    "price": 1000,
				    "quantity": 101
				}
				""";
		final var response = RestAssured.given()
				.contentType("application/json")
				.body(json)
				.when()
				.post("/api/order")
				.then()
				.statusCode(201)
				.extract()
				.body().asString();
		Assert.assertEquals("Order placed successfully", response);
	}

}
