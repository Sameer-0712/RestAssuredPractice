package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class GetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		map.put("cartId","l5sCnEL9ilHgG3HqGoBPi");
		String getResponse = RestAssured.
		given().
			baseUri("https://simple-grocery-store-api-testing.glitch.me/").
			basePath("carts/{cartId}").
			pathParams(map).
			contentType(ContentType.JSON).
		when().
			get().
		then().
			extract().
			asPrettyString();
		
		System.out.println(getResponse);
			
	}

}
