package com.json;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToXml {
    public static void main(String[] args) throws Exception {
        String json = "{ \"name\":\"Anuj\", \"age\":22 }";

        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        String xml = xmlMapper.writeValueAsString(jsonMapper.readTree(json));
        System.out.println(xml);
    }
}
