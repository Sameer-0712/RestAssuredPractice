package practice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GoRestAPI {

    @Test
    public void getUsersTest(){
        RestAssured.baseURI = "https://gorest.co.in";

        RestAssured.given()
                .header("Authorization","Bearer 90aef5639999c0c0a48c01259469eb5efe5e19a55d8a33ab3e3b8fc259ed088c")
                .log().all()
                .when().log().all()
                .get("/public/v2/users")
                .then().log().all()
                .statusCode(200)
                .and()
                .body("$.size()", Matchers.equalTo(10));

    }

}
