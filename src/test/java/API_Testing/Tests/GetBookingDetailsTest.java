package API_Testing.Tests;

import API_Testing.Base.BaseTest;
import API_Testing.Clients.GetBookingDetails;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookingDetailsTest extends BaseTest {

    @Test
    public void testGetBookingDetails(){

        GetBookingDetails bookingDetails = new GetBookingDetails();
        Response response = bookingDetails.getBookingDetails(bookingId);

        response.prettyPrint();
        assertions(response, false);
        Assert.assertFalse(response.getBody().toString().isEmpty());
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Jim");
        Assert.assertEquals(response.jsonPath().getString("lastname"), "Brown");
    }
}
