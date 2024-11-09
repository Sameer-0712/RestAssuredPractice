package restAssuredTests;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateCartWithInlineAssertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.
		given().
			log().
			all().
			baseUri("https://simple-grocery-store-api-testing.glitch.me/").
			basePath("carts").
			contentType(ContentType.JSON).
		when().
			post().
		then().
			log().
			all().
			statusCode(201)
			.body("created",Matchers.equalTo(true))
			.body("cartId", Matchers.notNullValue());
	}

}
