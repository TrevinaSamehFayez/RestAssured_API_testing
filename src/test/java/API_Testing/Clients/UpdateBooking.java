package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UpdateBooking {

    public Response update(JSONObject updateBookingBody, int id, String token) {

        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(updateBookingBody.toString())
                .pathParam("booking_id", id)
                .when()
                .put("/booking/{booking_id}")
                .then()
                .extract()
                .response();
    }
}
