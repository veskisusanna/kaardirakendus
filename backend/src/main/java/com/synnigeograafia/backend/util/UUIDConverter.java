package com.synnigeograafia.backend.util;

import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

public class UUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        try {
            return UUID.fromString(source);
        } catch (IllegalArgumentException e) {
            // Handle the exception if the string is not a valid UUID
            // Log an error, throw an exception, or perform any other necessary actions
            return null;
        }
    }

}
