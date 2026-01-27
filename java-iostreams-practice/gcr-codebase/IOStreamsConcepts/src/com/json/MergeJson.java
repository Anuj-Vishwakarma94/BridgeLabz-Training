package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ObjectNode json1 = mapper.createObjectNode();
        json1.put("name", "Anuj");

        ObjectNode json2 = mapper.createObjectNode();
        json2.put("age", 22);

        json1.setAll(json2);
        System.out.println(json1.toString());
    }
}
