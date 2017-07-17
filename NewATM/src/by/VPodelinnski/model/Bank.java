package by.VPodelinnski.model;

/**
 * Created by viivpo2010 on 12.7.17.
 * Банк
 */
public class Bank {
    private final String name;
    public Bank(final String name) {
        this.name = name;
    }
    public static Bank aBank(final String name) {
        if (name.isEmpty()|| name == null) {
            throw new IllegalArgumentException("название банка не может быть пустым");
        }
        return new Bank(name);
    }
    public String getName() {
        return name;
    }
}
