package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateCartWithJsonSchemaValidation {

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
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateCartJsonSchema.json"));

	}

}
