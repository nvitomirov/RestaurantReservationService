package com.nebovito.reservationservce.integrationTests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestaurantControllerTest extends BaseIntegrationTest {

    @Test
    void createRestaurant() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(

                        """
                                {
                                  "name":"Restaurantino"
                                }
                                """
                )
                .post(getBaseUrl() + "/restaurants");
        String responseId = response.then().extract().path("id");
        response
                .then()
                .assertThat()
                .statusCode(201)
                .body(containsString(String.format(
                        """
                                {
                                  "id":"%s",
                                  "name":"Restaurantino"
                                }
                                """, responseId).replace("\n", "").replace(" ", "")));
    }

    @Test
    void readRestaurants() {
        int initialSize = get(getBaseUrl() + "/restaurants")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body().path("totalSize");

        createRestaurant("Bella Italia");
        createRestaurant("Strada");

        get(getBaseUrl() + "/restaurants")
                .then()
                .assertThat()
                .statusCode(200)
                .body("totalSize", equalTo(initialSize + 2));

    }

    private String createRestaurant(String restaurantName) {
        return given()
                .contentType(ContentType.JSON)
                .body(String.format("{\"name\":\"%s\"}", restaurantName))
                .post(getBaseUrl() + "/restaurants")
                .then()
                .assertThat()
                .statusCode(201)
                .extract()
                .path("id");
    }
}
