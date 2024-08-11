package ph.tech.ecomm.inventory_service;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }


    @Test
    void isInStock() {
        var hasStock = RestAssured.given()
                .queryParam("skuCode", "iphone_15")
                .queryParam("quantity", 100)
                .when()
                .get("/api/inventory")
                .then()
                .statusCode(200)
                .extract().as(Boolean.class);

        Assert.assertEquals(true, hasStock);

        hasStock = RestAssured.given()
                .queryParam("skuCode", "iphone_15")
                .queryParam("quantity", 101)
                .when()
                .get("/api/inventory")
                .then()
                .statusCode(200)
                .extract().as(Boolean.class);

        Assert.assertEquals(false, hasStock);

    }

}
