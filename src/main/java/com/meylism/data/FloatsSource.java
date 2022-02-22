package com.meylism.data;

import com.meylism.data.gen.FloatGenerator;
import com.meylism.data.gen.IntegersGenerator;
import com.meylism.model.Floats;
import com.meylism.model.Integers;
import com.meylism.provider.FloatsJsonProvider;
import com.meylism.provider.IntegersJsonProvider;
import com.meylism.provider.JsonProvider;

public class FloatsSource extends JsonSource<Floats> {
    private static final FloatsJsonProvider floatsJsonProvider = new FloatsJsonProvider();

    FloatsSource(int quantity, int individualSize) {
        super(quantity, individualSize, floatsJsonProvider, new FloatGenerator());
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
