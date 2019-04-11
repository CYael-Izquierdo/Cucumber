package utilities;


import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;


public class JsonReader {

    public static Map<String, Object> getJsonObject(String file) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> carMap = null;

        try {
            carMap = mapper.readValue(new File(
                    file), new TypeReference<Map<String, Object>>() {
            });

            System.out.println(carMap.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return carMap;
    }
}
