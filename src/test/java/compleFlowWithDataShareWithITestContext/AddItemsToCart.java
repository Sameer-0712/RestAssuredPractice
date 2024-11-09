package compleFlowWithDataShareWithITestContext;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class AddItemsToCart {
	
	String baseUri = "https://simple-grocery-store-api-testing.glitch.me/";
	int productId;
	String cartId;
	
	@Test(priority = 1)
	public void getProductId(ITestContext context) {
		productId = RestAssured.
		given()
			.baseUri(baseUri)
			.basePath("products")
			.contentType(ContentType.JSON)
		.when()
			.get()
		.then()
			.log()
			.all()
			.extract()
			.jsonPath()
			.getInt("find{it.id==3674}.id");
		
		context.setAttribute("productId", productId);
//		DataShare.setMap("productId", productId);
		
		System.out.println("Thread ID: "+Thread.currentThread().getId());
	}
	
	@Test(priority = 2)
	public void createANewCart(ITestContext context) {
		cartId = RestAssured.
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
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateCartJsonSchema.json"))
			.extract()
			.jsonPath()
			.getString("cartId");
//		DataShare.setMap("cartId", cartId);
		context.setAttribute("cartId", cartId);
		System.out.println("For Thread ID: "+Thread.currentThread().getId()+ " Cart Id is: "+cartId);
			
	}	
	

}
