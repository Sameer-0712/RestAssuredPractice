package restAssuredTests;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PostRequestReqSpecAndResSpec {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://simple-grocery-store-api-testing.glitch.me/";
		RestAssured.basePath = "carts";
		
		RequestSpecification reqSpec = RestAssured.given();
				
		reqSpec.log()
			.all()
			.contentType(ContentType.JSON);
		
		ResponseSpecification resSpec = RestAssured.expect();
		
		resSpec.statusCode(201);
//		resSpec.time(Matchers.both(Matchers.lessThan(5000L)).and(Matchers.greaterThan(1000L)));
		resSpec.contentType(ContentType.JSON);
			
		System.out.println(RestAssured.
			given().
				spec(reqSpec).		
			when().
				post().
			then().
				spec(resSpec)
				.extract()
				.asPrettyString());
	}

}
