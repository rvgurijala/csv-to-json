package com.test.csvtojson.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opencsv.bean.CsvBindByName;
import org.springframework.web.bind.annotation.PathVariable;

public class Person {

    @CsvBindByName(column = "first_name")
    private String first_name;

    @CsvBindByName(column = "surname")
    private String last_name;

    @CsvBindByName(column = "age")
    private Integer age;

    @CsvBindByName(column = "nationality")
    @JsonIgnore
    private String nationality;

    @CsvBindByName(column = "favourite_colour")
    private String favourite_colour;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFavourite_colour() {
        return favourite_colour;
    }

    public void setFavourite_colour(String favourite_colour) {
        this.favourite_colour = favourite_colour;
    }
}
