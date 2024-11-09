package jsonObjectCreationInJava;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

public class JsonArrayPayload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Object> jsonObject = new LinkedHashMap<String, Object>();
		
		List<Map<String, Object>> empList = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> empDetails = new LinkedHashMap<String, Object>();
		
		empDetails.put("name", "John");
		empDetails.put("age", 30);
		empDetails.put("department", "Engineering");
		List<Map<String, String>> projectList = new ArrayList<Map<String, String>>();
		Map<String, String> project_1 = new LinkedHashMap<String, String>();
		project_1.put("name", "Project A");
		project_1.put("status", "In Progress");
		
		Map<String, String> project_2 = new LinkedHashMap<String, String>();
		project_2.put("name", "Project B");
		project_2.put("status", "Completed");

		
		projectList.add(project_1);
		projectList.add(project_2);
		
		empDetails.put("projects", projectList);

		empList.add(empDetails);
		
		jsonObject.put("employees", empList);
		
		//*************
		
		
		Map<String, Object> empDetails2 = new LinkedHashMap<String, Object>();
		
		empDetails2.put("name", "Alice");
		empDetails2.put("age", 28);
		empDetails2.put("department", "Marketing");
		List<Map<String, String>> projectList2 = new ArrayList<Map<String, String>>();
		Map<String, String> project2_1 = new LinkedHashMap<String, String>();
		project2_1.put("name", "Campaign X");
		project2_1.put("status", "In Progress");
		
		Map<String, String> project2_2 = new LinkedHashMap<String, String>();
		project2_2.put("name", "Campaign Y");
		project2_2.put("status", "Planned");

		
		projectList2.add(project2_1);
		projectList2.add(project2_2);
		
		empDetails2.put("projects", projectList2);

		empList.add(empDetails2);
		
		jsonObject.put("employees", empList);
		
		
		
		RestAssured.given().log().all().body(jsonObject).get();

	}

}
