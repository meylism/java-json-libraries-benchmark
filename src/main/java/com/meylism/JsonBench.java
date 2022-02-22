package com.meylism;

import com.meylism.data.JsonSource;
import com.meylism.data.JsonSourceFactory;

public abstract class JsonBench {
    protected static final JsonSource CLI_JSON_SOURCE = JsonSourceFactory.create();
    public abstract JsonSource JSON_SOURCE();

    public Object gson() throws Exception {
        return null;
    }

    public Object jackson() throws Exception {
        return null;
    }

    public Object jackson_afterburner() throws Exception {
        return null;
    }

    public Object dsljson() throws Exception {
        return null;
    }

    public Object dsljson_reflection() throws Exception {
        return null;
    }
}
