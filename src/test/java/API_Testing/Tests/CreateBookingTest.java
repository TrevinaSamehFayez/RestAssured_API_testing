package API_Testing.Tests;

import API_Testing.Base.BaseTest;
import API_Testing.Clients.CreateBooking;
import API_Testing.Request.CreateAndUpdateBookingRequestBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingTest extends BaseTest {

    @Test
    public void createBooking(){

        CreateBooking bookingClient = new CreateBooking();
        Response response = bookingClient.createBooking(CreateAndUpdateBookingRequestBody.createBooking("Jim", "Brown"));
        response.prettyPrint();

        bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Created bookingId = " + bookingId);

        assertions(response, false);
        Assert.assertTrue(response.getBody().asString().contains("bookingid"));
        Assert.assertFalse(response.jsonPath().getJsonObject("booking").toString().isEmpty());
        Assert.assertEquals(response.jsonPath().getString("booking.firstname"), "Jim");
        Assert.assertEquals(response.jsonPath().getString("booking.lastname"), "Brown");


    }
}
