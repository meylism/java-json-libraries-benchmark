package com.meylism.data;

import com.meylism.RandomUtils;
import com.meylism.data.gen.DataGenerator;
import com.meylism.provider.JsonProvider;

import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class JsonSource<T> {
    static {

    }

    private final JsonProvider<T> provider;

    private final T[] jsonAsObject;
    private final String[] jsonAsString;
    private final byte[][] jsonAsBytes;
    private final ThreadLocal<ByteArrayInputStream[]> jsonAsByteArrayInputStream;


    private final DataGenerator<T> dataGenerator;

    JsonSource(final int quantity, final int individualSize, final JsonProvider provider,
               final DataGenerator<T> dataGenerator) {
        this.provider = provider;

        this.jsonAsObject = newPojoArray(quantity);
        this.jsonAsString = new String[quantity];
        this.jsonAsBytes = new byte[quantity][];

        this.dataGenerator = dataGenerator;
        populateFields(quantity, individualSize);

        this.jsonAsByteArrayInputStream = ThreadLocal.withInitial(() -> {
            ByteArrayInputStream[] arr = new ByteArrayInputStream[quantity];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ByteArrayInputStream(jsonAsBytes[i]);
            }
            return arr;
        });
    }

    private final void populateFields(final int quantity, final int individualSize) {
        try {
            for (int i = 0; i < quantity; i++) {
                T obj = pojoType().newInstance();
                dataGenerator.populate(obj, individualSize);
                jsonAsObject[i] = obj;

                String json = provider.jackson().writeValueAsString(obj);
                jsonAsString[i] = json;
                jsonAsBytes[i] = json.getBytes();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public JsonProvider<T> provider() {
        return provider;
    }

    public String nextString() {
        return jsonAsString[index(jsonAsString.length)];
    }

    public InputStream nextInputStream() {
        ByteArrayInputStream[] arr = jsonAsByteArrayInputStream.get();
        ByteArrayInputStream bais = arr[index(arr.length)];
        bais.reset();
        return bais;
    }

    public byte[] nextByteArray() {
        return jsonAsBytes[index(jsonAsBytes.length)];
    }

    public Reader nextReader() {
        return new InputStreamReader(nextInputStream());
    }

    public BufferedSource nextOkioBufferedSource() {
        return Okio.buffer(new ForwardingSource(Okio.source(nextInputStream())) {
            @Override
            public void close() {
            }
        });
    }

    public T nextPojo() {
        return jsonAsObject[index(jsonAsObject.length)];
    }

    abstract T[] newPojoArray(int quantity);

    public abstract Class<T> pojoType();

    private int index(final int bound) {
        return bound == 1 ? 0 : RandomUtils.nextInt(bound);
    }
}
