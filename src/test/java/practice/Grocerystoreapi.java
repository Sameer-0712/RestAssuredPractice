package practice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Grocerystoreapi {


    @Test
    public void grocerystoretest1(){
        RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me";

        RestAssured.given()
                .log().all()
                .when().log().all()
                .get("/status")
                .then().log().all()
                .assertThat().body("status", Matchers.equalTo("UP"));

    }

}
