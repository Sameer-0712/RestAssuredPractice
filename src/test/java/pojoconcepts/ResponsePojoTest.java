package pojoconcepts;

import io.restassured.RestAssured;

public class ResponsePojoTest {

    public static void main(String[] args) {

        Employees e = RestAssured.given().log().all().when().get("https://run.mocky.io/v3/a7424f79-0492-4f67-a2e6-431408a20a0d")
                .as(Employees.class);

        System.out.println(e.getName());

        FinData fd = e.getFinData();
        System.out.println(fd.getAccNum());
    }
}
