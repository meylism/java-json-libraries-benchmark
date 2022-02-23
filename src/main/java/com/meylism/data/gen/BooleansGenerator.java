package com.meylism.data.gen;

import com.meylism.RandomUtils;
import com.meylism.model.Booleans;
import com.meylism.model.Floats;
import com.meylism.model.Integers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BooleansGenerator implements DataGenerator<Booleans> {
    @Override
    public int populate(Booleans obj, int size) {
        int approxSize = 15; // size of {'booleans':[]}

        obj.booleans = new ArrayList<>();
        while (approxSize < size) {
            approxSize += appendBoolean(obj, size - approxSize);
            approxSize += 1; // size of ,
        }
        return approxSize;
    }

    private static int appendBoolean(final Booleans booleans, final int availableSize) {
        int expectedSize = 0;
        Boolean random;
        while (expectedSize < availableSize) {
            random = RandomUtils.nextBoolean();
            booleans.booleans.add(random);
            expectedSize += 1 + Boolean.toString(random).length(); // size of ',' and float
        }
        return expectedSize;
    }
}
