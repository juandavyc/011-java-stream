package org.juandavyc.models;

import lombok.*;
import org.juandavyc.models.enums.Gender;
import org.juandavyc.models.enums.Habitat;
import org.juandavyc.models.enums.TypeAnimal;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode() //onlyExplicitlyIncluded = true

@ToString

public abstract class Animal implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    protected Habitat habitat;
    private Float weight,length;
    private Integer age;
    @EqualsAndHashCode.Exclude
    public TypeAnimal typeAnimal;
    public boolean endangered;
    protected Gender gender;


}
