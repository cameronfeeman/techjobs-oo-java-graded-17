package org.launchcode.techjobs.oo;

import java.util.Objects;

//make abstract
public abstract class JobField {

    //Set unique ID for each Job
    private int id;
    private static int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    //assigns the correct value for position, skill, etc.
    public JobField(String value) {
        this();
        this.value = value;
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.
//Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    //Check for equality
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField that = (JobField) o;
        return id == that.id;
    }



    // Getters and Setters:

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
