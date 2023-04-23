package edu.guilford;

public class User {
    // atrributes
    private String name;
    private String lastName;
    private int birthYear;
    private String favoriteColor;
    // constructor
    public User(String name, String lastName, int birthYear, String favoriteColor) {
        this.name = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.favoriteColor = favoriteColor;
    }
    // getters
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }
}