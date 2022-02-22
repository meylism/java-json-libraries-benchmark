package com.meylism;

import java.io.ByteArrayOutputStream;

public final class JsonUtils {
    private JsonUtils() {}

    public static StringBuilder stringBuilder() {
        StringBuilder b = THREAD_STRING_BUILDER.get();
        b.setLength(0);
        return b;
    }

    public static ByteArrayOutputStream byteArrayOutputStream() {
        ByteArrayOutputStream baos = THREAD_BYTE_ARRAY_OUTPUT_STREAM.get();
        baos.reset();
        return baos;
    }

    private static final ThreadLocal<ByteArrayOutputStream> THREAD_BYTE_ARRAY_OUTPUT_STREAM =
            ThreadLocal.withInitial(ByteArrayOutputStream::new);

    private static final ThreadLocal<StringBuilder> THREAD_STRING_BUILDER =
            ThreadLocal.withInitial(StringBuilder::new);
}
