package pojoconcepts;

import io.restassured.RestAssured;

public class ResponseArrayPojoTest {

    public static void main(String[] args) {

        Employees[] e =  RestAssured.given().log().all().when().get("https://run.mocky.io/v3/45cc854e-412d-460f-91d2-12425dbc053c")
                .as(Employees[].class);

        System.out.println(e.length);

        System.out.println(e[0].getFinData().getPfNum());
    }
}
