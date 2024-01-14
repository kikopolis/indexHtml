package com.kikopolis.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.kikopolis.service.TokenService.TOKEN_HEADER_PARAM;
import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PersonResourceTest {
    private static String requestBodyOne = "{\"name\":\"kiko\", \"sectors\":[{\"id\": 2},{\"id\": 3},{\"id\": 5}], \"agreedToTerms\":true }";
    private static String requestBodyTwo = "{\"name\":\"kiko2\", \"sectors\":[{\"id\": 337},{\"id\": 51},{\"id\": 47}], \"agreedToTerms\":true }";

    @Test
    void test_post_endpoint_saves_person() {
        var response = given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .body(requestBodyOne)
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        assertEquals("kiko", response.jsonPath().getString("name"));
    }

    @Test
    void test_post_endpoint_saves_person_with_token_and_index_retrieves_by_token() {
        var token = "1234";
        var response = given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .header(TOKEN_HEADER_PARAM, token)
                .and()
                .body(requestBodyOne)
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        assertEquals("kiko", response.jsonPath().getString("name"));
        var response2 = given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .header(TOKEN_HEADER_PARAM, token)
                .when()
                .get(PersonResource.PERSON_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response2.statusCode());
        assertTrue(response2.contentType().contains(ContentType.JSON.toString()));
        assertEquals("kiko", response2.jsonPath().getString("name"));
    }

    @Test
    void test_person_can_change_values() {
        var token = "4321a";
        var response = given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .header(TOKEN_HEADER_PARAM, token)
                .and()
                .body(requestBodyOne)
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response.statusCode());
        assertTrue(response.contentType().contains(ContentType.JSON.toString()));
        assertEquals("kiko", response.jsonPath().getString("name"));
        var initialId = response.jsonPath().getString("id");
        var response2 = given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .header(TOKEN_HEADER_PARAM, token)
                .and()
                .body(requestBodyTwo)
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .extract()
                .response();
        assertEquals(200, response2.statusCode());
        assertTrue(response2.contentType().contains(ContentType.JSON.toString()));
        assertEquals("kiko2", response2.jsonPath().getString("name"));
        assertTrue(response2.jsonPath().getString("sectors").contains("337"));
        assertTrue(response2.jsonPath().getString("sectors").contains("51"));
        assertTrue(response2.jsonPath().getString("sectors").contains("47"));
        assertEquals(initialId, response2.jsonPath().getString("id"));
    }

    @Test
    void test_cannot_save_with_empty_name() {
        given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .body("{\"name\":\"\", \"sectors\":[{\"id\": 2},{\"id\": 3},{\"id\": 5}], \"agreedToTerms\":true }")
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .statusCode(400);
    }

    @Test
    void test_cannot_save_with_un_agreed_terms() {
        given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .body("{\"name\":\"kiko\", \"sectors\":[{\"id\": 2},{\"id\": 3},{\"id\": 5}], \"agreedToTerms\":false }")
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .statusCode(400);
    }

    @Test
    void test_cannot_save_with_empty_sectors() {
        given()
                .header(CONTENT_TYPE, ContentType.JSON)
                .and()
                .body("{\"name\":\"kiko\", \"sectors\":[], \"agreedToTerms\":true }")
                .when()
                .post(PersonResource.PERSON_API_PATH)
                .then()
                .statusCode(400);
    }
}
