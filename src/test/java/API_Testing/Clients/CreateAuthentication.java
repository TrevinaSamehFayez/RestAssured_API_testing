package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreateAuthentication {

    public String createToken() {
        JSONObject credentials = new JSONObject();
        credentials.put("username", "admin");
        credentials.put("password", "password123");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(credentials.toString())
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .response();

        return response.jsonPath().getString("token");
    }
}
