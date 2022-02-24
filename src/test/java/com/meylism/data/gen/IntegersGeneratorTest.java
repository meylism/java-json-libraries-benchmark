package com.meylism.data.gen;

import com.meylism.model.Integers;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class IntegersGeneratorTest extends GeneratorTest<IntegersGenerator> {

    @Test
    @Override
    public void populate_1k() throws IOException {
        populate(1*1000);
    }

    @Test
    @Override
    public void populate_100k() throws IOException {
        populate(100*1000);
    }

    @Test
    @Override
    public void populate_1m() throws IOException {
        populate(1000*1000);
    }

    @Test
    @Override
    public void populate_10m() throws IOException {
        populate(10000*1000);
    }

    @Override
    public void populate(int size) throws IOException {
        Integers ints = new Integers();
        generator = new IntegersGenerator();
        int approxSize = generator.populate(ints, size);
        String s = JACKSON.writeValueAsString(ints);
        // System.out.println(s);
        int realSize = s.getBytes().length;
        int maxAllowedSIze = realSize + (realSize / MARGIN_ERROR);
        int minAllowedSIze = realSize - (realSize / MARGIN_ERROR);

        assertTrue("Generated payload is bigger than the maximum expected. Got: " + approxSize + ". Max expected: " + maxAllowedSIze, approxSize <= maxAllowedSIze);
        assertTrue("Generated payload is smaller than the minimum expected. Got: " + approxSize + ". Min expected: " + minAllowedSIze, approxSize >= minAllowedSIze);
    }
}