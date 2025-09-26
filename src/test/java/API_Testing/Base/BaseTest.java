package API_Testing.Base;

import API_Testing.Clients.CreateAuthentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static int bookingId;

    protected static String token;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        CreateAuthentication auth = new CreateAuthentication();
        token = auth.createToken();

        System.out.println("Token is: "+token);
    }

    public void assertions(Response response, boolean isDelete) {
        Assert.assertTrue(response.getTime()<1000);
        if (isDelete) {
            Assert.assertEquals(response.getStatusCode(), 201);

        }
        else
        {
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8", "Unexpected Content-Type");
        }

    }
}
