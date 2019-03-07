package com.example.demo;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.UUID;

public interface WithRandom {

    default boolean randomBoolean() {
        return RandomUtils.nextBoolean();
    }

    default UUID randomUUID() {
        return UUID.randomUUID();
    }

    default String randomString() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    default int randomInt() {
        return RandomUtils.nextInt();
    }

    default int randomIntMax(int max) {
        return RandomUtils.nextInt(0, max);
    }

    default double randomDouble() {
        return RandomUtils.nextDouble();
    }

    default <ENUM_TYPE extends Enum<?>> ENUM_TYPE randomEnum(Class<ENUM_TYPE> e) {
        ENUM_TYPE[] values = e.getEnumConstants();
        int index = this.randomIntMax(values.length);
        return values[index];
    }
}