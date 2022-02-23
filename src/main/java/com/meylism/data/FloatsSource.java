package com.meylism.data;

import com.meylism.data.gen.FloatsGenerator;
import com.meylism.model.Floats;
import com.meylism.provider.FloatsJsonProvider;

public class FloatsSource extends JsonSource<Floats> {
    private static final FloatsJsonProvider floatsJsonProvider = new FloatsJsonProvider();

    FloatsSource(int quantity, int individualSize) {
        super(quantity, individualSize, floatsJsonProvider, new FloatsGenerator());
    }

    @Override
    Floats[] newPojoArray(int quantity) {
        return new Floats[quantity];
    }

    @Override
    public Class<Floats> pojoType() {
        return Floats.class;
    }
}
