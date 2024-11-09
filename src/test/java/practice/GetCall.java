package practice;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetCall {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://simple-grocery-store-api.glitch.me/";

		RestAssured.given().log().all().header("Content-Type","application/json").when().get("status").
		then().log().all().body("status", Matchers.equalTo("UP")).statusCode(200);
		
		String response = RestAssured.given().log().all().header("Content-Type","application/json").when().post("carts")
		.then().log().all().extract().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String cartId = js.getString("cartId");
		
		RestAssured.given().log().all().header("Content-Type","application/json").pathParam("cartId", cartId).body("{\r\n"
				+ "   \"productId\": 4646\r\n"
				+ "}")
		.when().post("carts/{cartId}/items")
		.then().log().all().statusCode(201);
		
	}

}
