package jsonObjectCreationInJava;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class GetProductsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	List<Map<String,String>> products = 
		RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://simple-grocery-store-api-testing.glitch.me/")
			.basePath("products")
			.contentType(ContentType.JSON)
		.when()
			.get()
			.as(new TypeRef<List<Map<String,String>>>() {
			});
	System.out.println(products.size());
	System.out.println(products.get(0).get("category"));
	
	}

}
