package com.flyingbison.sample.enums;

import com.flyingbison.sample.converter.GenericEnumConverter;

import javax.persistence.AttributeConverter;

/**
 * @author FlyingBison
 */
public enum SampleString implements DatabaseEnum<String>{
    TEST("Some Value"),
    TEST2("Different Value");

    private final String value;

    SampleString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static class Converter extends GenericEnumConverter<SampleString, String> implements AttributeConverter<SampleString, String> {
        public Converter() {
            super(SampleString.class);
        }
    }
}
