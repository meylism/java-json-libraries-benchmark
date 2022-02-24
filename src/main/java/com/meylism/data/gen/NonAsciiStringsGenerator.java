package com.meylism.data.gen;

import com.meylism.RandomUtils;
import com.meylism.model.NonAsciiStrings;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class NonAsciiStringsGenerator implements DataGenerator<NonAsciiStrings> {
    @Override
    public int populate(NonAsciiStrings obj, int size) {
        int approxSize = 24; // size of {'non_ascii_strings':[]}

        obj.nonAsciiStrings = new ArrayList<>();
        approxSize += appendNonAsciiStrings(obj, size - approxSize);

        return approxSize;
    }

    private static int appendNonAsciiStrings(final NonAsciiStrings strings,
                                            final int availableSize) {
        int expectedSize = 0;
        String random;
        int randomInt;

        while (expectedSize < availableSize) {
            randomInt = RandomUtils.nextInt(0, 200);
            random = RandomUtils.random(randomInt, false, false);
            strings.nonAsciiStrings.add(random);
            expectedSize += 3 + random.getBytes(StandardCharsets.UTF_8).length; // size of quotes,
            // ',' and string
        }
        return expectedSize;
    }
}
