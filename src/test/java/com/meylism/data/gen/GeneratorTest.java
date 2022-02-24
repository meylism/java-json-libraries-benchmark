package com.meylism.data.gen;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;


public abstract class GeneratorTest<T> {
    protected static final int MARGIN_ERROR = 10; // %
    protected static final ObjectMapper JACKSON = new ObjectMapper();
    protected T generator;

    public abstract void populate_1k() throws IOException;

    public abstract void populate_100k() throws IOException;

    public abstract void populate_1m() throws IOException;

    public abstract void populate_10m() throws IOException;

    public abstract void populate(int size) throws IOException;
}
