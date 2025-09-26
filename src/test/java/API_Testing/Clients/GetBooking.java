package API_Testing.Clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetBooking {

    public Response getBooksIds(){

        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();
    }
}
