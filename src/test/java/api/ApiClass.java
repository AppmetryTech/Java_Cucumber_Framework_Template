package api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class ApiClass {
  private String token;
  private String bookingId;
    private static String requestBody = "{  \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"}";

    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }
    @Test(priority = 0)
    public void generateToken(){
        token = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when().post("/auth")
                .jsonPath().getString("token");

        System.out.println("TOKEN --> "+token);
                /*.then()
                .statusCode(200)
                        .log().all();*/
    }

    @Test(priority = 1)
    public void createBooking(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("firstname", "Jim");
        requestBody.put("lastname", "Brown");
        requestBody.put("totalprice", 111);
        requestBody.put("depositpaid", true);

        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "Breakfast");

        bookingId = RestAssured.given()
                .header("Content-type","application/json")
                .when()
                .post("/booking")
                .then()
                .extract().response().asString();

    }
    @Test(priority = -1)
    public void healthCheck(){
        given()
                .when()
                .get("/ping")
                .then()
                .statusCode(201);
    }

    @Test(priority = 2)
    public void validateBookingId(){
           given()
                  // .queryParam("firstname","s")
                   .when()
                   .get("/booking")
                   .then()
                   .statusCode(200);
                  // .log().all();
    }

    @Test(priority = -2)
    public void validateBookingDetails(){

        int bookingId = 1;
       Response res  =  given()
                .pathParams("id",bookingId)
                .when()
                .get("/booking/{id}");
               /* .then()
                .log().all()
                .body("firstname",equalTo("Jim"))
                .body("lastname",equalTo("Brown"));*/


        Assert.assertEquals(res.getStatusCode(),200);
       String lastname = res.jsonPath().getString("lastname");
       Assert.assertEquals(lastname,"Jackson");
        //Assert.assertEquals();

                /*.then()
                .statusCode(200)
                 .log().all();*/
    }
}
