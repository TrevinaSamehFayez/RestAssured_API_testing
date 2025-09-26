package API_Testing.Tests;

import API_Testing.Base.BaseTest;
import API_Testing.Clients.PartialUpdateBooking;
import API_Testing.Request.PartialUpdateBookingBody;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PartialUpdateBookingTest extends BaseTest {

    @Test
    public void testPartialUpdate(){
        PartialUpdateBooking partialUpdate = new PartialUpdateBooking();

        Response response = partialUpdate.partialupdate(
                PartialUpdateBookingBody.partialUpdateBooking("Mike"),
                bookingId,
                token
        );

        assertions(response, false);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Mike", "Firstname was not updated correctly");
    }






}
