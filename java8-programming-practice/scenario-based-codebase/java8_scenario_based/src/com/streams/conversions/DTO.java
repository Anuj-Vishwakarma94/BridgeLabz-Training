package com.streams.conversions;

public class DTO {
    String key;
    int value;

    DTO(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + " : " + value;
    }
}
