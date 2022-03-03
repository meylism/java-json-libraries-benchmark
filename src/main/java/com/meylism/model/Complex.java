package com.meylism.model;

import com.dslplatform.json.CompiledJson;

import java.util.Map;

@CompiledJson
public class Complex {

    public Map<String, Object> object;

    public Map<String, Object> getObject() {
        return object;
    }

    public void setObject(Map<String, Object> object) {
        this.object = object;
    }
}
