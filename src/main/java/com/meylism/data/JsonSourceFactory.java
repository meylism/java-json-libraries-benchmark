package com.meylism.data;

import com.meylism.Cli;
import com.meylism.Config;
import com.meylism.support.BenchSupport;

public final class JsonSourceFactory {
    private JsonSourceFactory() {}

    public static JsonSource<?> create() {
        Cli.AbstractCommand cmd = Config.load();
        return create("integers", 1, 1);
    }

    public static JsonSource<?> create(final String datatype, final int quantity, final int size) {
        BenchSupport bs = BenchSupport.valueOf(datatype.toUpperCase());
        switch (bs) {
            case INTEGERS:
                return new IntegersSource(quantity, size);
            case FLOATS:
                return new FloatsSource(quantity, size);
            default:
                throw new RuntimeException();
        }
    }
}
