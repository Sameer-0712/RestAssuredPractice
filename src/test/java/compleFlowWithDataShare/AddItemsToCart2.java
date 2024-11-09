package compleFlowWithDataShare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class AddItemsToCart2 {
	
	String baseUri = "https://simple-grocery-store-api-testing.glitch.me/";
	int productId;
	String cartId;
	
	@Test(priority = 1)
	public void getProductId() {
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
			.getInt("find{it.id==4646}.id");
		
		DataShare.setMap("productId", productId);
		
		System.out.println("Thread ID: "+Thread.currentThread().getId());
	}
	
	@Test(priority = 2)
	public void createANewCart() {
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
		DataShare.setMap("cartId", cartId);
		System.out.println("For Thread ID: "+Thread.currentThread().getId()+ " Cart Id is: "+cartId);
			
	}
	
	@Test(priority = 3)
	public void addItemToCart() {
		RestAssured.
		given().
			log().
			all().
			baseUri(baseUri).
			basePath("carts/{cartId}/items").
			contentType(ContentType.JSON).
			body("{\r\n"
					+ "   \"productId\": "+productId+",\r\n"
					+ "   \"quantity\": 2\r\n"
					+ "}").
			pathParam("cartId", DataShare.getMap("cartId")).
		when().
			post().
		then().
			log().
			all().
			statusCode(201);
		
		System.out.println("For Thread ID: "+Thread.currentThread().getId()+"Item added: "+productId+", Item added to the cart: "+cartId);
	}
	
	@Test(priority = 4)
	public void getItemFromCart() {
		RestAssured.
		given().
			log().
			all().
			baseUri(baseUri).
			basePath("carts/{cartId}/items").
			contentType(ContentType.JSON).
			pathParam("cartId", DataShare.getMap("cartId")).
		when().
			get().
		then().
			log().
			all().
			statusCode(200);	
	}

}
