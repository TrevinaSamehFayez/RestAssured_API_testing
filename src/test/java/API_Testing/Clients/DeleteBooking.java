package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class DeleteBooking {

    public Response delete(int id, String token) {

        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .pathParam("booking_id", id)
                .when()
                .delete("/booking/{booking_id}")
                .then()
                .extract()
                .response();
    }
}
