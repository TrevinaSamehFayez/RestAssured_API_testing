package API_Testing.Request;

import org.json.JSONObject;

public class PartialUpdateBookingBody {

    public static JSONObject partialUpdateBooking(String firstname) {
        JSONObject bookingUpdate = new JSONObject();
        bookingUpdate.put("firstname", firstname);

        return bookingUpdate;
    }
}
