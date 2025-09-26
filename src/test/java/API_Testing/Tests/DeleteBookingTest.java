package API_Testing.Tests;

import API_Testing.Base.BaseTest;
import API_Testing.Clients.DeleteBooking;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookingTest extends BaseTest {

    @Test
    public void testDeleteBooking(){

        DeleteBooking deleteBooking = new DeleteBooking();

        Response response = deleteBooking.delete(bookingId, token);

        assertions(response, true);
        Assert.assertFalse(response.toString().isEmpty());

    }
}
