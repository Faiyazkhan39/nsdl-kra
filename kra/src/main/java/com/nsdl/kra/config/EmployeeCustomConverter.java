package com.nsdl.kra.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsdl.kra.repository.EmployeeType;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmployeeCustomConverter implements AttributeConverter<EmployeeType, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(EmployeeType attribute) {
       try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public EmployeeType convertToEntityAttribute(String dbData) {
         try {
            return objectMapper.readValue(dbData, EmployeeType.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
