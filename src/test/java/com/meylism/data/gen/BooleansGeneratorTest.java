package com.meylism.data.gen;

import com.meylism.model.Booleans;
import com.meylism.model.Strings;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertTrue;

public class BooleansGeneratorTest extends GeneratorTest<BooleansGenerator> {
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
        Booleans booleans = new Booleans();
        generator = new BooleansGenerator();
        int approxSize = generator.populate(booleans, size);
        String s = JACKSON.writeValueAsString(booleans);
        // System.out.println(s);
        int realSize = s.getBytes().length;
        int maxAllowedSIze = realSize + (realSize / MARGIN_ERROR);
        int minAllowedSIze = realSize - (realSize / MARGIN_ERROR);

        assertTrue("Generated payload is bigger than the maximum expected. Got: " + approxSize + ". Max expected: " + maxAllowedSIze, approxSize <= maxAllowedSIze);
        assertTrue("Generated payload is smaller than the minimum expected. Got: " + approxSize + ". Min expected: " + minAllowedSIze, approxSize >= minAllowedSIze);
    }
}
