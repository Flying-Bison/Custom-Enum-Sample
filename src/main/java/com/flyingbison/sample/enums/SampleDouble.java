package com.flyingbison.sample.enums;

import com.flyingbison.sample.converter.GenericEnumConverter;

import javax.persistence.AttributeConverter;

/**
 * @author FlyingBison
 */
public enum SampleDouble implements DatabaseEnum<Double>{
    DOUBLE_1(0.04),
    DOUBLE_2(0.08);

    private final Double value;

    SampleDouble(Double value){
        this.value = value;
    }

    public Double getValue(){
        return value;
    }

    public static class Converter extends GenericEnumConverter<SampleDouble, Double> implements AttributeConverter<SampleDouble, Double> {
        public Converter() {
            super(SampleDouble.class);
        }
    }
}

