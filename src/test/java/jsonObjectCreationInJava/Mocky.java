package jsonObjectCreationInJava;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class Mocky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map reponseMap = RestAssured
		.given()
			.log()
			.all()
		.when()
			.get("https://run.mocky.io/v3/8cd7f217-fde9-46ff-8216-4c58ef6bd12a")
			.as(new TypeRef<Map<String,String>>() {
			});
		
		System.out.println(reponseMap);
		
		reponseMap.keySet().forEach(k -> System.out.println(k));
		
		System.out.println(reponseMap.get("name"));
	}

}
