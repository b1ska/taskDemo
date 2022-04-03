package com.example.demo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.util.Constants.DATE_TIME_FORMAT;

public class Util {
    private static final ObjectMapper LIST_OBJECT_MAPPER = getListObjectMapper();

    private static ObjectMapper getListObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATE_TIME_FORMAT));
        mapper.registerModule(javaTimeModule);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return mapper;
    }

    public static <E> List<E> getList(Object data, Class<E> cls) throws IOException {
        CollectionType javaType = LIST_OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, cls);
        return LIST_OBJECT_MAPPER.readValue(data.toString(), javaType);
    }
}
