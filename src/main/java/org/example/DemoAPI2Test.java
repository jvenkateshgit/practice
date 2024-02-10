package org.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoAPI2Test {


    public static String requestbody="[\n" +
            "  {\n" +
            "    \"id\": 344445,\n" +
            "    \"username\": \"Venkateshjanapati\",\n" +
            "    \"firstName\": \"Janapati\",\n" +
            "    \"lastName\": \"Janapati\",\n" +
            "    \"email\": \"J@gmail.com\",\n" +
            "    \"password\": \"Power117!@#\",\n" +
            "    \"phone\": \"1287789\",\n" +
            "    \"userStatus\": 199\n" +
            "  }\n" +
            "]";

    @Test

    public void Listuser(){
        RestAssured.baseURI="https://petstore.swagger.io";
        //Post call
        given().header("Content-type", "application/json")
                .body(requestbody).log().all()
                .when()
                .post("v2/user/createWithList")
                .then().log().all().assertThat().statusCode(200);

        //get call
        given().when()
                .get("v2/user/login?username=VenkateshJanapati&password=Power117!%40%23")
                .then().log()
                .all().assertThat().statusCode(200);

    }
}