package com.meylism.data.gen;


import com.meylism.RandomUtils;
import com.meylism.model.Integers;

import java.util.ArrayList;

public class IntegersGenerator implements DataGenerator<Integers> {
    @Override
    public int populate(Integers obj, int size) {
        int approxSize = 15; // size of {'integers':[]}

        obj.integers = new ArrayList<>();
        while (approxSize < size) {
            approxSize += appendInteger(obj, size - approxSize);
            approxSize += 1; // size of ,
        }
        return approxSize;
    }

    private static int appendInteger(final Integers integers, final int availableSize) {
        int expectedSize = 0;
        Integer random;

        while (expectedSize < availableSize) {
            random = RandomUtils.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            integers.integers.add(random);
            expectedSize += 1 + Integer.toString(random).length(); // size of ',' and integer
        }
        return expectedSize;
    }
}
