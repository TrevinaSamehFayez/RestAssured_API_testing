package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetBookingDetails {

    public Response getBookingDetails(int id){

        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("booking_id", id)
                .when()
                .get("/booking/{booking_id}")
                .then()
                .extract()
                .response();
    }
}
