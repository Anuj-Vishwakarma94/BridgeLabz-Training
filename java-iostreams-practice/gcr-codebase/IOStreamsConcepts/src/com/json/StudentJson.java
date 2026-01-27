package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.HashMap;

public class StudentJson {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> student = new HashMap<>();
        student.put("name", "Anuj");
        student.put("age", 22);
        student.put("subjects", Arrays.asList("Java", "DSA", "SQL"));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(student));
    }
}
