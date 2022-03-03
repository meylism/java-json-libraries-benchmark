package com.meylism.data.gen;

import com.meylism.model.Complex;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

public class ComplexGeneratorTest extends GeneratorTest<ComplexGenerator>{
    @Override
    @Test
    public void populate_1k() throws IOException {
        populate(10000);
    }

    @Override
    @Test
    public void populate_100k() throws IOException {
        populate(100*1000);
    }

    @Override
    @Test
    public void populate_1m() throws IOException {
        populate(1000000);
    }

    @Override
    @Test
    public void populate_10m() throws IOException {
        populate(10000000);
    }

    public void populate(int size) throws IOException {
        Complex complexObject = new Complex();
        generator = new ComplexGenerator();
        int approxSize = generator.populate(complexObject, size);
        String s = JACKSON.writeValueAsString(complexObject);
        int realSize = s.getBytes(StandardCharsets.UTF_8).length;
        int maxAllowedSIze = realSize + (realSize / MARGIN_ERROR);
        int minAllowedSIze = realSize - (realSize / MARGIN_ERROR);

        assertTrue("Generated payload is bigger than the maximum expected. Got: " + approxSize + ". Max expected: " + maxAllowedSIze, approxSize <= maxAllowedSIze);
        assertTrue("Generated payload is smaller than the minimum expected. Got: " + approxSize + ". Min expected: " + minAllowedSIze, approxSize >= minAllowedSIze);
    }
}
