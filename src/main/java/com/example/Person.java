package com.example;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Person {
    
    private String name;
    private String surname;

    // Constructor name should match the class name
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    // Optional: Provide setters if needed
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
