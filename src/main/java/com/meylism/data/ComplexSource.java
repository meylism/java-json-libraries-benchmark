package com.meylism.data;

import com.meylism.data.gen.ComplexGenerator;
import com.meylism.model.Complex;
import com.meylism.provider.ComplexJsonProvider;

public class ComplexSource extends JsonSource<Complex> {
    private static final ComplexJsonProvider complexJsonProvider = new ComplexJsonProvider();

    ComplexSource(int quantity, int individualSize) {
        super(quantity, individualSize, complexJsonProvider, new ComplexGenerator());
    }

    @Override
    Complex[] newPojoArray(int quantity) {
        return new Complex[quantity];
    }

    @Override
    public Class<Complex> pojoType() {
        return Complex.class;
    }
}
