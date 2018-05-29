package com.motek.soa;

public class UUIDGenerator {
    private Integer currentId = 0;

    private static UUIDGenerator ourInstance = new UUIDGenerator();

    public static UUIDGenerator getInstance() {
        return ourInstance;
    }

    private UUIDGenerator() {
    }

    public Integer getId() {
        return currentId++;
    }
}
