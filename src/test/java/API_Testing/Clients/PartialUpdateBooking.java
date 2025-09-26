package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class PartialUpdateBooking {

    public Response partialupdate(JSONObject updateBookingBody, int id, String token) {

        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)                 // <-- cookie auth header
                .body(updateBookingBody.toString())
                .pathParam("booking_id", id)
                .when()
                .patch("/booking/{booking_id}")
                .then()
                .extract()
                .response();
    }
}
