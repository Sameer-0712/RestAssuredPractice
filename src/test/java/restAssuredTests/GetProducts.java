package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://simple-grocery-store-api-testing.glitch.me/")
				.basePath("products/{productId}")
				.pathParam("productId", "4646")
				.contentType(ContentType.JSON)
			.when()
				.get()
			.then()
				.log()
				.all();

	}

}
