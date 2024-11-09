package restAssuredTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EndToEnd {
	
	RequestSpecification reqSpec;

	@BeforeClass
	public void setRequestSpec() {
		
		reqSpec = RestAssured.given();
		reqSpec = reqSpec.log().
					all().
					baseUri("https://simple-grocery-store-api-testing.glitch.me/")
					.contentType(ContentType.JSON)
					.pathParam("cartId", "V2W_iNv0AurhwWKKv04gf");
		
	}
	
	@Test
	public void getCartItemsBeforeAddition() {
		
		RestAssured.
		given().
			spec(reqSpec).
			basePath("carts/{cartId}").
		when().
			get().
		then().
			log().
			all().
			statusCode(200);
		
	}
	
	@Test
	public void AddItemToCart() {
		
		RestAssured.
		given().
			spec(reqSpec).
			basePath("carts/{cartId}/items").
			body("{\r\n"
					+ "   \"productId\": 4875,\r\n"
					+ "   \"quantity\": 3\r\n"
					+ "}").
		when().
			post().
		then().
			log().
			all().
			statusCode(201);
		
	}
	
	@Test
	public void getCartItemsAfterAddition() {
		
		RestAssured.
		given().
			spec(reqSpec).
			basePath("carts/{cartId}").
		when().
			get().
		then().
			log().
			all().
			statusCode(200);
		
	}
	
}
