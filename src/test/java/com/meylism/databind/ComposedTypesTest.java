package com.meylism.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComposedTypesTest {
    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void ser() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);

        map.put("list", ints);
        map.put("name", "Meylis");

        String s = objectMapper.writeValueAsString(map);
    }

    @Test
    public void deser() throws JsonProcessingException {
        String s = "{\"name\":\"Meylis\"}";
        Object result = objectMapper.readTree(s);
    }


}
