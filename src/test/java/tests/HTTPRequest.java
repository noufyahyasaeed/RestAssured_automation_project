package tests;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HTTPRequest {
    int id;
    String apiKey = System.getenv("X_API_KEY");

    //    if (apiKey == null) {
//        System.out.println("❌ WARNING: X_API_KEY environment variable is missing!");
//    }
    @Test(priority = 1)
    public void GetUser() {
        baseURI = "https://reqres.in/api/collections";
        //reqres.in/api/users
        given()
                .header("x-api-key", apiKey)
                .when()
                .get("https://reqres.in/api/collections/products/records?project_id=24420")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 2)
    public void createUser() {
        HashMap data = new HashMap();
        data.put("name", "nouf");
        data.put("job", "QA engineer");

        id = given()
                .contentType("application/json")
                .body(data)
                .header("x-api-key", apiKey)
                .when()
                .post("https://reqres.in/api/users")
                .jsonPath().getInt("id");
//                .then()
//                .statusCode(201)
//                .log().all();

    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        HashMap data = new HashMap();
        data.put("name", "nouf");
        data.put("job", "backend engineer");

        given()
                .contentType("application/json")
                .body(data)
                .header("x-api-key", apiKey)
                // In a real production environment, you would extract the ID from the POST response
                // and pass it dynamically like: .put("https://reqres.in/api/users/" + id);
                // Hardcoding '2' here because ReqRes is a mock API and doesn't persist new data.
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4)
    public void deleteUser() {
        given()
                .contentType("application/json")
                .header("x-api-key", apiKey)
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

}
