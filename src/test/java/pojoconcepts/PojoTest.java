package pojoconcepts;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class PojoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employees e1 = new Employees();
		e1.setName("Tom");
		e1.setDept("Dev");
		e1.setDesignation("Senior Dev");
		e1.setId("216458");
		
		FinData e1Data = new FinData();
		e1Data.setAccNum("3254673478");
		e1Data.setPf(3000);
		e1Data.setPfNum("PF7654");
		e1Data.setSalary(45000);
		
		e1.setFinData(e1Data);
		
		Employees e2 = new Employees();
		e2.setName("Jamie");
		e2.setDept("QA");
		e2.setDesignation("SDET1");
		e2.setId("3241235");
		
		FinData e2Data = new FinData();
		e2Data.setAccNum("6734456423");
		e2Data.setPf(5000);
		e2Data.setPfNum("PF7653");
		e2Data.setSalary(65000);
		
		e2.setFinData(e2Data);
		
		List<Employees> empList = new ArrayList<Employees>();
		empList.add(e1);
		empList.add(e2);
		
		RestAssured.given().log().all().body(empList).when().post().then().log().all();
		
	}

}
