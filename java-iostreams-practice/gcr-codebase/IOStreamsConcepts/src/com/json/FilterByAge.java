package com.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterByAge {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"A\",\"age\":20},{\"name\":\"B\",\"age\":30}]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode array = mapper.readTree(json);

        for (JsonNode node : array) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node.toString());
            }
        }
    }
}
