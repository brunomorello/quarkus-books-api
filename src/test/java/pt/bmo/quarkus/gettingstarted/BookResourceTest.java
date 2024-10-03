package pt.bmo.quarkus.gettingstarted;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    void shouldGetAllBooks() {
        given()
            .header(ACCEPT, MediaType.APPLICATION_JSON)
          .when()
                .get("/api/books")
          .then()
             .statusCode(OK.getStatusCode())
            .body("size()", is(4));
    }

    @Test
    void shouldCountAllBooks() {
        given()
            .header(ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(OK.getStatusCode())
            .body(is("4"));
    }

    @Test
    void shouldGetABookById() {
        given()
            .header(ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 4)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(OK.getStatusCode())
                .body("title", is("true at first light"))
                .body("author", is("hemingway"))
                .body("yearOfPublication", is(1999))
                .body("genre", is("novel"));
    }

}