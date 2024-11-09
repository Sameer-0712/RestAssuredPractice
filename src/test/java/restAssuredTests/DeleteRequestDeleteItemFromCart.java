package restAssuredTests;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequestDeleteItemFromCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("cartId", "bPD1lY2h_Wiyo94_MpVgl");
		hm.put("itemId", "778203954");
		
		RestAssured.
		given().
			log().
			all().
			baseUri("https://simple-grocery-store-api-testing.glitch.me/").
			basePath("carts/{cartId}/items/{itemId}").
			contentType(ContentType.JSON).
			pathParams(hm).
		when().
			delete().
		then().
			log().
			all().
			statusCode(204);

	}

}
