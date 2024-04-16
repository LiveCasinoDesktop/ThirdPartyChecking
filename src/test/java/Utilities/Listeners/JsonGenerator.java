package Utilities.Listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class JsonGenerator {

    public static Map<String, Object> generate(String product, List<String> baseList, List<String> addedList, List<String> removedList) throws JsonProcessingException {

        Map<String, Object> data = new LinkedHashMap<>();

        data.put("category", product);
        data.put("baseList", baseList);
        data.put("addedList", addedList);
        data.put("removedList", removedList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonData = mapper.writeValueAsString(data);
        System.out.println(jsonData);


        return data;

    }
}
