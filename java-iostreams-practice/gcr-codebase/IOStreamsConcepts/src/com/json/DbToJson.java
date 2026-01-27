package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class DbToJson {
    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> records = List.of(
                Map.of("id", 1, "name", "Anuj"),
                Map.of("id", 2, "name", "Ravi")
        );

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(records));
    }
}
