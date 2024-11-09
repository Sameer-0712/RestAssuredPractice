package compleFlowWithDataShareWithITestContext;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddItemsToCart2 {
	
	String baseUri = "https://simple-grocery-store-api-testing.glitch.me/";
	int productId;
	String cartId;
	
	@Test(priority = 3)
	public void addItemToCart(ITestContext context) {
		RestAssured.
		given().
			log().
			all().
			baseUri(baseUri).
			basePath("carts/{cartId}/items").
			contentType(ContentType.JSON).
			body("{\r\n"
					+ "   \"productId\": "+context.getAttribute("productId")+",\r\n"
					+ "   \"quantity\": 2\r\n"
					+ "}").
			pathParam("cartId", context.getAttribute("cartId")).
		when().
			post().
		then().
			log().
			all().
			statusCode(201);
		
		System.out.println("For Thread ID: "+Thread.currentThread().getId()+"Item added: "+productId+", Item added to the cart: "+cartId);
	}
	
	@Test(priority = 4)
	public void getItemFromCart(ITestContext context) {
		RestAssured.
		given().
			log().
			all().
			baseUri(baseUri).
			basePath("carts/{cartId}/items").
			contentType(ContentType.JSON).
			pathParam("cartId", context.getAttribute("cartId")).
		when().
			get().
		then().
			log().
			all().
			statusCode(200);	
	}
	

}
