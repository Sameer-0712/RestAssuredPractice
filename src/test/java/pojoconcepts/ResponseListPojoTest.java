package pojoconcepts;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

import java.util.List;

public class ResponseListPojoTest {

    public static void main(String[] args) {

        List<Employees> e =  RestAssured.given().log().all().when().get("https://run.mocky.io/v3/45cc854e-412d-460f-91d2-12425dbc053c")
                .as(new TypeRef<List<Employees>>() {
                });

        System.out.println(e.size());

        System.out.println(e.get(0).getFinData().getPfNum());
    }
}
