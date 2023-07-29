package dev.nicholasrv;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TasksPageTest {

    @Test
    public void testTasksEndpoint() {
        given()
          .when().get("/tasks")
          .then()
             .statusCode(200);
    }

}