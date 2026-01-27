package com.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

public class EmailSchemaValidation {
    public static void main(String[] args) throws Exception {

        String schema = """
        {
          "type":"object",
          "properties":{
            "email":{"type":"string","format":"email"}
          }
        }
        """;

        String json = "{ \"email\":\"test@gmail.com\" }";

        ObjectMapper mapper = new ObjectMapper();

        JsonSchemaFactory factory =
                JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);

        JsonSchema jsonSchema = factory.getSchema(schema);

        Set<ValidationMessage> errors =
                jsonSchema.validate(mapper.readTree(json));

        System.out.println(errors.isEmpty() ? "Valid Email" : errors);
    }
}
