package com.flyingbison.sample.domain;

import com.flyingbison.sample.enums.SampleDouble;
import com.flyingbison.sample.enums.SampleString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author FlyingBison
 */
@Entity
public class SampleDomain implements Serializable {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;
    @Basic
    @Convert(converter = SampleString.Converter.class)
    private SampleString stringEnum;
    @Basic
    @Convert(converter = SampleDouble.Converter.class)
    private SampleDouble doubleEnum;


    public Long getId() {
        return id;
    }

    public SampleString getStringEnum() {
        return stringEnum;
    }

    public void setStringEnum(SampleString stringEnum) {
        this.stringEnum = stringEnum;
    }

    public SampleDouble getDoubleEnum() {
        return doubleEnum;
    }

    public void setDoubleEnum(SampleDouble doubleEnum) {
        this.doubleEnum = doubleEnum;
    }
}
