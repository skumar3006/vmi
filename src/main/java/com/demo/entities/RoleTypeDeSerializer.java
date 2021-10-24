package com.demo.entities;

import java.io.IOException;

import org.apache.commons.lang.text.StrBuilder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class RoleTypeDeSerializer extends JsonDeserializer<Role> {

    @Override
    public Role deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return Role.getByName(convertCharToUpperCase(p.getText(), 0));
    }
    
    public static String convertCharToUpperCase(String string, int index) {
        return new StrBuilder(string)
                      .setCharAt(index, Character.toUpperCase(string.charAt(index)))
                      .toString();
    }
}
