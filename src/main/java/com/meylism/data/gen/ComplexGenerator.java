package com.meylism.data.gen;

import com.meylism.RandomUtils;
import com.meylism.model.Complex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComplexGenerator implements DataGenerator<Complex>{
    private enum DataType {
        OBJECT,
        ARRAY,
        STRING,
        INTEGER,
        FLOAT
    }

    @Override
    public int populate(Complex complexObject, int availableSize) {
        int approxSize = 13; // size of {"object":{}}
        complexObject.object = new HashMap<>();

        while (availableSize > approxSize) {
            approxSize += appendSomething(complexObject.object, getRandomButUniqueMapKey(complexObject.object),
                    availableSize - approxSize);
            approxSize += 1; // size of ,
        }

        return approxSize;
    }

    private static int appendSomething(Map<String, Object> map, String key, int availableSize) {
        if (availableSize < 0) return 0;
        int size = 0;
        size += key.length() + 3; // size of : and ""

        switch(getRandomDataType()) {
            case STRING:
                Object randomStr = getRandomPrimitiveValue(DataType.STRING);
                size += ((String)randomStr).getBytes().length + 2; // size
                // of ""
                map.put(key, randomStr);
                break;
            case INTEGER:
                Object randomInt = getRandomPrimitiveValue(DataType.INTEGER);
                size += randomInt.toString().length();
                map.put(key, randomInt);
                break;
            case FLOAT:
                Object randomFloat = getRandomPrimitiveValue(DataType.FLOAT);
                size += randomFloat.toString().length();
                map.put(key, randomFloat);
                break;
            case ARRAY:
                size += appendArray(map, key, availableSize - size);
                break;
            case OBJECT:
                Map<String, Object> subMap = new HashMap<>();
                size += 2; // {}
                size += appendSomething(subMap, getRandomButUniqueMapKey(subMap), availableSize - size);
                map.put(key, subMap);
                break;
        }

        return size;
    }

    private static int appendArray(Map<String, Object> map, String key, int availableSize) {
        List<Object> list = new ArrayList<>();
        int size = 0;
        size += 2;  // size of []
        int sizeForArray = RandomUtils.nextInt(0, 25);
        DataType type = getRandomPrimitiveType();

        while (availableSize > size && sizeForArray > 0) {
            Object value = getRandomPrimitiveValue(type);
            list.add(value);

            int valueSize = value.toString().getBytes().length;
            size += valueSize + 1; // size of ,

            sizeForArray -= 1;

            if (type == DataType.STRING) {
                size += 2; // size of ""
            }
        }

        map.put(key, list);
        return size;
    }

    private static DataType getRandomDataType() {
        // We want the dataset to be rich in nested data
        // So the chance of getting primitive vs object vs array is 1:2:1
        int randomInt = RandomUtils.nextInt(0, 4);

        if (randomInt == 0) return getRandomPrimitiveType();
        else if (randomInt == 1) return DataType.ARRAY;
        else return DataType.OBJECT;
    }

    private static DataType getRandomPrimitiveType() {
        int randomInt = RandomUtils.nextInt(0, 3);

        if (randomInt == 0) return DataType.INTEGER;
        else if (randomInt == 1) return DataType.STRING;
        else return DataType.FLOAT;
    }

    private static Object getRandomPrimitiveValue(DataType dataType) {
        switch (dataType) {
            case INTEGER:
                return RandomUtils.nextInt(Integer.MAX_VALUE);
            case FLOAT:
                return RandomUtils.nextFloat(Float.MIN_VALUE, Float.MAX_VALUE);
            case STRING:
                int random = RandomUtils.nextInt(0, 40);
                return RandomUtils.randomAlphanumeric(random);
            default:
                throw new RuntimeException("Given primitive type not supported: " + dataType);
        }
    }

    private static String getRandomButUniqueMapKey(Map<String, Object> map) {
        String randomKey = RandomUtils.randomAlphabetic(1, 7);
        while (map.containsKey(randomKey))
            randomKey = RandomUtils.randomAlphabetic(1, 7);
        return randomKey;
    }
}
