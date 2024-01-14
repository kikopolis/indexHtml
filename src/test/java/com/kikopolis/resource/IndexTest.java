package com.kikopolis.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class IndexTest {
    @Test
    void test_index() {
        given().when().get("/")
                .then()
                .statusCode(200)
                .body(containsString("Please enter your name and pick the Sectors you are currently involved in."));
    }
}
