package com.meylism.data;

import com.meylism.data.gen.DataGenerator;
import com.meylism.data.gen.StringsGenerator;
import com.meylism.model.Strings;
import com.meylism.provider.IntegersJsonProvider;
import com.meylism.provider.JsonProvider;

public class StringsSource extends JsonSource<Strings> {
    private static final IntegersJsonProvider integersJsonProvider = new IntegersJsonProvider();

    StringsSource(int quantity, int individualSize) {
        super(quantity, individualSize, integersJsonProvider, new StringsGenerator());
    }

    @Override
    Strings[] newPojoArray(int quantity) {
        return new Strings[quantity];
    }

    @Override
    public Class<Strings> pojoType() {
        return Strings.class;
    }
}
