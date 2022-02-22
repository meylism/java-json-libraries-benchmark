package com.meylism.data;

import com.meylism.data.gen.DataGenerator;
import com.meylism.data.gen.IntegersGenerator;
import com.meylism.model.Integers;
import com.meylism.provider.IntegersJsonProvider;
import com.meylism.provider.JsonProvider;

public class IntegersSource extends JsonSource<Integers> {
    private static final IntegersJsonProvider integersJsonProvider = new IntegersJsonProvider();

    IntegersSource(int quantity, int individualSize) {
        super(quantity, individualSize, integersJsonProvider, new IntegersGenerator());
    }

    @Override
    Integers[] newPojoArray(int quantity) {
        return new Integers[quantity];
    }

    @Override
    public Class<Integers> pojoType() {
        return Integers.class;
    }
}
