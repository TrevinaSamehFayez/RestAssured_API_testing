package API_Testing.Tests;

import API_Testing.Base.BaseTest;
import API_Testing.Clients.UpdateBooking;
import API_Testing.Request.CreateAndUpdateBookingRequestBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateBookingTest extends BaseTest {

    @Test
    public void testUpdateBooking(){
        UpdateBooking Update = new UpdateBooking();

        Response response = Update.update(
                CreateAndUpdateBookingRequestBody.createBooking("Jean", "Smith"),
                bookingId,
                token
        );

        assertions(response, false);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Jean", "First name was not updated correctly");
        Assert.assertEquals(response.jsonPath().getString("lastname"), "Smith", "Last name was not updated correctly");
    }
}
