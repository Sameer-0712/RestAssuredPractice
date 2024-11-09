package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequestAddItemToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String postResBody = RestAssured.
		given().
			log().
			all().
			baseUri("https://simple-grocery-store-api-testing.glitch.me/").
			basePath("carts/{cartId}/items").
			contentType(ContentType.JSON).
			body("{\r\n"
					+ "   \"productId\": 5478,\r\n"
					+ "   \"quantity\": 3\r\n"
					+ "}").
			pathParam("cartId", "V2W_iNv0AurhwWKKv04gf").
		when().
			post().
		then().
			extract().
			asPrettyString();
		
		System.out.println(postResBody);

	}

}
