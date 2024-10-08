package com.project.librarymanagement.model;

public class AuthorDto {
    private String name;
    private String lastName;

    public AuthorDto(){

    }

    public AuthorDto(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
