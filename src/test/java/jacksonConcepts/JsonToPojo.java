package jacksonConcepts;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonToPojo {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Hp\\eclipse-workspace\\restAssured\\src\\test\\resources\\Persons.json";
        Persons persons;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            persons = objectMapper.readValue(new File(filePath), Persons.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(persons.getAge());
        String updatedJson;
        try {
            updatedJson = objectMapper.writeValueAsString(persons);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(updatedJson);
        persons.setAge(56);

        System.out.println(persons.getAge());


        try {
            updatedJson = objectMapper.writeValueAsString(persons);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(updatedJson);
    }
}
