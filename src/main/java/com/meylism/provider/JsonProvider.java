package com.meylism.provider;

import com.dslplatform.json.DslJson;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public interface JsonProvider<T> {
    ObjectMapper jackson();

    JsonFactory jacksonFactory();

    ObjectMapper jacksonAfterburner();

    Gson gson();

    DslJson<Object> dsljson();

    DslJson<Object> dsljson_reflection();
}
