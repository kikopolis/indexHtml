package com.kikopolis.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class SectorResourceTest {
    @Test
    void test_get_endpoint() {
        var response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(SectorResource.SECTOR_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        assertEquals("Manufacturing", response.jsonPath().getString("name[0]"));
    }
}