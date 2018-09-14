package com.flyingbison.sample.converter;

import com.flyingbison.sample.enums.DatabaseEnum;
import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.List;


/**
 * @author FlyingBison
 */
public abstract class GenericEnumConverter <E extends Enum<E> & DatabaseEnum<T>, T> implements AttributeConverter<E, T> {
    private List<E> enumConstants;
    private Class<E> enumClass;

    public GenericEnumConverter(Class<E> enumType){
        this.enumConstants = Arrays.asList(enumType.getEnumConstants());
        this.enumClass = enumType;
    }

    @Override
    public T convertToDatabaseColumn(E attribute) {
        if(attribute == null){
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public E convertToEntityAttribute(T dataValue) {
        return enumConstants.stream()
                .filter(currentEnum -> currentEnum.getValue().equals(dataValue))
                .findAny()
                .orElseThrow(() -> new DataIntegrityViolationException("Invalid value: " + dataValue + " found in database for Enum: " + enumClass.getSimpleName()));
    }
}
