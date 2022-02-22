package com.meylism.data;

import com.meylism.data.gen.IntegersGenerator;
import com.meylism.data.gen.NonAsciiStringsGenerator;
import com.meylism.model.NonAsciiStrings;
import com.meylism.provider.IntegersJsonProvider;
import com.meylism.provider.NonAsciiStringsProvider;

public class NonAsciiStringsSource extends  JsonSource<NonAsciiStrings>{
    private static final NonAsciiStringsProvider nonAsciiStringsProvider =
            new NonAsciiStringsProvider();

    NonAsciiStringsSource(int quantity, int individualSize) {
        super(quantity, individualSize, nonAsciiStringsProvider, new NonAsciiStringsGenerator());
    }

    @Override
    NonAsciiStrings[] newPojoArray(int quantity) {
        return new NonAsciiStrings[quantity];
    }

    @Override
    public Class<NonAsciiStrings> pojoType() {
        return NonAsciiStrings.class;
    }
}
