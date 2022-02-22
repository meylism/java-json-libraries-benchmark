package com.meylism.provider;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.runtime.Settings;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.meylism.model.Integers;

public class IntegersJsonProvider implements JsonProvider<Integers> {
    private final ObjectMapper jackson = new ObjectMapper();
    private final ObjectMapper jacksonAfterburner = new ObjectMapper().
            registerModule(new AfterburnerModule());
    private JsonFactory jacksonFactory = new JsonFactory();
    private final Gson gson = new GsonBuilder().create();
    private final DslJson<Object> dslJson = new DslJson<>(
            Settings.withRuntime().includeServiceLoader());
    private final DslJson<Object> dsljson_reflection = new DslJson<>(Settings.withRuntime());

    public IntegersJsonProvider() {}

    @Override
    public ObjectMapper jackson() {
        return jackson;
    }

    @Override
    public JsonFactory jacksonFactory() {
        return jacksonFactory;
    }

    @Override
    public ObjectMapper jacksonAfterburner() {
        return jacksonAfterburner;
    }

    @Override
    public Gson gson() {
        return gson;
    }

    @Override
    public DslJson<Object> dsljson() {
        return dslJson;
    }

    @Override
    public DslJson<Object> dsljson_reflection() {
        return dsljson_reflection;
    }
}
