package com.meylism;

import java.util.Random;

public final class RandomUtils {
    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    private RandomUtils() {}

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int nextInt(final int startInclusive, final int endExclusive) {
        assert endExclusive >= startInclusive;
        assert startInclusive >= 0;

        if (startInclusive == endExclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
    }

    public static float nextFloat(final float startInclusive, final float endInclusive) {
        assert endInclusive >= startInclusive;
        assert startInclusive >= 0;

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + ((endInclusive - startInclusive) * RANDOM.nextFloat());
    }
}
