package com.meylism.data.gen;

public interface DataGenerator<T> {
    int populate(T obj, int size);
}
