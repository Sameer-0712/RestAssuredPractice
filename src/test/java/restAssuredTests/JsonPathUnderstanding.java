package restAssuredTests;

import io.restassured.path.json.JsonPath;

public class JsonPathUnderstanding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jsonObject = "{\r\n"
				+ "    \"glossary\": {\r\n"
				+ "        \"title\": \"example glossary\",\r\n"
				+ "		\"GlossDiv\": {\r\n"
				+ "            \"title\": \"S\",\r\n"
				+ "			\"GlossList\": {\r\n"
				+ "                \"GlossEntry\": {\r\n"
				+ "                    \"ID\": \"SGML\",\r\n"
				+ "					\"SortAs\": \"SGML\",\r\n"
				+ "					\"GlossTerm\": \"Standard Generalized Markup Language\",\r\n"
				+ "					\"Acronym\": \"SGML\",\r\n"
				+ "					\"Abbrev\": \"ISO 8879:1986\",\r\n"
				+ "					\"GlossDef\": {\r\n"
				+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\r\n"
				+ "						\"GlossSeeAlso\": [\"GML\", \"XML\"]\r\n"
				+ "                    },\r\n"
				+ "					\"GlossSee\": \"markup\"\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}";
		
		JsonPath js = new JsonPath(jsonObject);
		String innerArray = js.getString("glossary.GlossDiv.GlossList.GlossEntry.GlossDef.GlossSeeAlso");
		
		System.out.println(innerArray);
		
		JsonPath js2 = new JsonPath(innerArray);
//		
		System.out.println(js2.getString("$"));
		
		
		
	}

}
