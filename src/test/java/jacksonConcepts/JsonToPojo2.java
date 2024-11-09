package jacksonConcepts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonToPojo2 {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\Hp\\eclipse-workspace\\restAssured\\src\\test\\resources\\Persons.json";

        Persons persons = objectMapper.readValue(new File(filePath), Persons.class);

        String personsJson = objectMapper.writeValueAsString(persons);

        System.out.println(personsJson);

        m1();
    }

    public static void m1() throws JsonProcessingException {

        Persons p1 = new Persons();
        p1.setAge(10);
        p1.setCity(null);
        p1.setGender("Male");
        p1.setId(0);
        p1.setName("Tom");

        String personsJson = objectMapper.writeValueAsString(p1);

        System.out.println(personsJson);

    }
}
