package restAssuredTests;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class JsonPathUnderstanding2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Sample.json";
		File file = new File(filePath);
		
//		String jsonObject = file.toString();
		
		JsonPath jsonPath = new JsonPath(file);
		
		System.out.println(jsonPath.getList("employees.name"));
		System.out.println(jsonPath.getString("employees[1].projects.status"));

		String personsFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Persons.json";
		File personsFile = new File(personsFilePath);
		
		JsonPath jsonPath2 = new JsonPath(personsFile);
		
		System.out.println(jsonPath2.getList("findAll{it.id>5}.name"));
		
		System.out.println(jsonPath2.getList("findAll{it.city.equals('Phoenix') | it.age==25}.name"));
		
		System.out.println(jsonPath2.getString("find{it.city.equals('Phoenix') | it.age==25}.name"));


		
	}

}
