package API_Testing.Tests;


import API_Testing.Base.BaseTest;
import API_Testing.Clients.GetBooking;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingTest extends BaseTest {

    @Test
    public void getBooksIDs(){

        GetBooking getBooking = new GetBooking();
        Response response = getBooking.getBooksIds();

        response.prettyPrint();
        assertions(response, false);
        Assert.assertFalse(response.getBody().toString().isEmpty());
        Assert.assertTrue(response.getBody().asString().contains("bookingid"));
    }

}


