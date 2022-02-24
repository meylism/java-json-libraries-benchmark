package com.meylism.data.gen;

import com.meylism.RandomUtils;
import com.meylism.model.Floats;
import com.meylism.model.Integers;

import java.util.ArrayList;

public class FloatsGenerator implements DataGenerator<Floats> {
    @Override
    public int populate(Floats obj, int size) {
        int approxSize = 13; // size of {'floats':[]}

        obj.floats = new ArrayList<>();
        approxSize += appendFloats(obj, size - approxSize);

        return approxSize;
    }

    private static int appendFloats(final Floats floats, final int availableSize) {
        int expectedSize = 0;
        Float random;

        while (expectedSize < availableSize) {
            random = RandomUtils.nextFloat(0, Float.MAX_VALUE);
            floats.floats.add(random);
            expectedSize += 1 + Float.toString(random).length(); // size of ',' and float
        }
        return expectedSize;
    }
}
