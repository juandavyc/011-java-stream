package org.juandavyc.models;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    // private int id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String address;
    private String floor;
    private Integer document;
    private String sex;
    private String nationality;
}
