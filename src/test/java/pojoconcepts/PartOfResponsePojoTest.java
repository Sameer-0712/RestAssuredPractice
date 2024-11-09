package pojoconcepts;

import java.util.Map;

import io.restassured.RestAssured;

public class PartOfResponsePojoTest {

    public static void main(String[] args) {

       FinData fd = RestAssured.given().log().all().when().get("https://run.mocky.io/v3/a7424f79-0492-4f67-a2e6-431408a20a0d")
                .jsonPath().getObject("finData",FinData.class);

       System.out.println(fd.getPf());

    }
}
