package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoAPITest {

    public static String postPayload="[\n" +
            "  {\n" +
            "    \"id\": 1180987668762,\n" +
            "    \"username\": \"VenkateshAPIs\",\n" +
            "    \"firstName\": \"ch\",\n" +
            "    \"lastName\": \"ch\",\n" +
            "    \"email\": \"sankar@gmail.com\",\n" +
            "    \"password\": \"123\",\n" +
            "    \"phone\": \"898989898989\",\n" +
            "    \"userStatus\": 1\n" +
            "  }\n" +
            "]";


    @Test
    public void apiTestGetDemo(){

        RestAssured.baseURI="https://petstore.swagger.io";

        //post api

        given().header("Content-type", "application/json")
                .body(postPayload).log().all()
                .when()
                .post("/v2/user/createWithArray")
                .then().log().all().assertThat().statusCode(200);

        //get API

        given().when()
                .get("/v2/user/VenkateshAPIs")
                .then().log()
                .all().assertThat().statusCode(200);


    }
}