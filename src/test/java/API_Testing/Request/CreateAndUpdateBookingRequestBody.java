package API_Testing.Request;

import org.json.JSONObject;

public class CreateAndUpdateBookingRequestBody {

    public static JSONObject createBooking(String firstname, String lastname) {
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2025-01-01");
        bookingDates.put("checkout", "2025-01-15");

        JSONObject booking = new JSONObject();
        booking.put("firstname", firstname);
        booking.put("lastname", lastname);
        booking.put("totalprice", 111);
        booking.put("depositpaid", true);
        booking.put("bookingdates", bookingDates);
        booking.put("additionalneeds", "Breakfast");

        return booking;
    }
}
