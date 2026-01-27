package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class MergeJsonFiles {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode a = (ObjectNode) mapper.readTree(new File("src/com/json/a.json"));
        ObjectNode b = (ObjectNode) mapper.readTree(new File("src/com/json/b.json"));
        a.setAll(b);
        System.out.println(a.toString());
    }
}
