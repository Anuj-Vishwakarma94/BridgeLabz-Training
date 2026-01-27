package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class CsvToJson {
    public static void main(String[] args) throws Exception {
        String csv = "name,age\nAnuj,22";

        String[] lines = csv.split("\n");
        String[] headers = lines[0].split(",");

        Map<String, String> map = new HashMap<>();
        String[] values = lines[1].split(",");

        for (int i = 0; i < headers.length; i++) {
            map.put(headers[i], values[i]);
        }

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(map));
    }
}
