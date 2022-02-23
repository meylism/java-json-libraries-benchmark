package com.meylism.data;

import com.meylism.data.gen.BooleansGenerator;
import com.meylism.model.Booleans;
import com.meylism.provider.BooleansJsonProvider;

public class BooleansSource extends JsonSource<Booleans> {
    private static final BooleansJsonProvider booleansJsonProvider = new BooleansJsonProvider();

    BooleansSource(int quantity, int individualSize) {
        super(quantity, individualSize, booleansJsonProvider, new BooleansGenerator());
    }

    @Override
    Booleans[] newPojoArray(int quantity) {
        return new Booleans[quantity];
    }

    @Override
    public Class<Booleans> pojoType() {
        return Booleans.class;
    }
}
