package by.VPodelinnski.model;

/**
 * Created by viivpo2010 on 12.7.17.
 * Класс описывающий владельца
 */

public  class Owner {
    private final String firstName;
    private final String lastName;
    private Owner(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public static Owner anOwner(final String firstName, final String lastName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        return new Owner(firstName, lastName);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
