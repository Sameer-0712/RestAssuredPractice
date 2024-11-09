package jsonObjectCreationInJava;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

public class HandleDynamicResponses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Response response = RestAssured
			.get("https://run.mocky.io/v3/3dd6d64a-06d7-4299-ada6-3c6af1efa5be");
		
		Object responseAsObject = response.as(Object.class);
		Map<String,Object> responseMap = new LinkedHashMap<String,Object>();
		List<Object> responseList = new ArrayList<Object>();
		if(responseAsObject instanceof Map) {
			responseMap = response.as(new TypeRef<Map<String,Object>>(){});
			System.out.println(responseMap);
		}
		else
		{
			responseList = response.as(new TypeRef<List<Object>>() {});
			System.out.println(responseList);
		}
	}

}
