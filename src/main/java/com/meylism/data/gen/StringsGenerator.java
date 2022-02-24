package com.meylism.data.gen;

import com.meylism.RandomUtils;
import com.meylism.model.NonAsciiStrings;
import com.meylism.model.Strings;

import java.util.ArrayList;

public class StringsGenerator implements DataGenerator<Strings> {
    @Override
    public int populate(Strings obj, int size) {
        int approxSize = 14; // size of {'strings':[]}

        obj.strings = new ArrayList<>();
        approxSize += appendStrings(obj, size - approxSize);

        return approxSize;
    }

    private static int appendStrings(final Strings strings, final int availableSize) {
        int expectedSize = 0;
        String random;
        int randomInt;

        while (expectedSize < availableSize) {
            randomInt = RandomUtils.nextInt(0, 200);
            random = RandomUtils.randomAlphanumeric(randomInt);
            strings.strings.add(random);
            expectedSize += 3 + random.length(); // size of quotes, ',' and string
        }
        return expectedSize;
    }
}
