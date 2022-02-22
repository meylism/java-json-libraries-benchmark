package com.meylism.data;

import com.meylism.Cli;
import com.meylism.Config;
import com.meylism.support.BenchSupport;

public final class JsonSourceFactory {
    private JsonSourceFactory() {}

    public static JsonSource<?> create() {
        Cli.AbstractCommand cmd = Config.load();
        return create(cmd.dataType, cmd.numberOfPayloads, cmd.sizeOfEachPayloadInKb * 1000);
    }

    public static JsonSource<?> create(final String datatype, final int quantity, final int size) {
        BenchSupport bs = BenchSupport.valueOf(datatype.toUpperCase());
        switch (bs) {
            case INTEGERS:
                return new IntegersSource(quantity, size);
            case FLOATS:
                return new FloatsSource(quantity, size);
            case STRINGS:
                return new StringsSource(quantity, size);
            case NON_ASCII_STRINGS:
                return new NonAsciiStringsSource(quantity, size);
            default:
                throw new RuntimeException();
        }
    }
}
