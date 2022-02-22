package com.meylism.databind;

import com.meylism.JsonBench;
import com.meylism.JsonUtils;
import com.meylism.data.JsonSource;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.ByteArrayOutputStream;

public class Serialization extends JsonBench {
    @Override
    public JsonSource JSON_SOURCE() {
        return CLI_JSON_SOURCE;
    }

    @Benchmark
    @Override
    public Object gson() {
        StringBuilder b = JsonUtils.stringBuilder();
        JSON_SOURCE().provider().gson().toJson(JSON_SOURCE().nextPojo(), b);
        return b;
    }

    @Benchmark
    @Override
    public Object jackson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().jackson().writeValue(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object jackson_afterburner() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().jacksonAfterburner().writeValue(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object dsljson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().dsljson().serialize(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }

    @Benchmark
    @Override
    public Object dsljson_reflection() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().dsljson_reflection().serialize(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }
}
