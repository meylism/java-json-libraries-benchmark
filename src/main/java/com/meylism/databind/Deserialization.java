package com.meylism.databind;

import com.meylism.JsonBench;
import com.meylism.data.JsonSource;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

public class Deserialization extends JsonBench {
    public JsonSource JSON_SOURCE() {
        return CLI_JSON_SOURCE;
    }

    @Benchmark
    @Override
    public Object gson() throws Exception {
        return JSON_SOURCE().provider().gson().fromJson(JSON_SOURCE().nextReader(),
                JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object jackson() throws Exception {
        return JSON_SOURCE().provider().jackson().readValue(JSON_SOURCE().nextByteArray(),
                JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object jackson_afterburner() throws IOException {
        return JSON_SOURCE().provider().jacksonAfterburner().readValue(JSON_SOURCE().
                nextByteArray(), JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object dsljson() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().dsljson().deserialize(JSON_SOURCE().pojoType(), buffer,
                buffer.length);
    }

    @Benchmark
    @Override
    public Object dsljson_reflection() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().dsljson_reflection().deserialize(JSON_SOURCE().pojoType(), buffer, buffer.length);
    }

}
