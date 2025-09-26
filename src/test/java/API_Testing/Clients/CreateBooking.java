package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreateBooking {

    public Response createBooking(JSONObject createBookingBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(createBookingBody.toString())
                .when()
                .post("/booking")
                .then()
                .extract()
                .response();

    }
}
