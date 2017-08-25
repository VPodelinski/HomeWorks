package by.VPodelinnski.model;

/**
 * Created by viivpo2010 on 12.7.17.
 * Клас описывающий аккаунт и наличие в нем суммы денег
 */
public class Account {
    private int sumOfMoney;
    private Account() {
        this.sumOfMoney = 0;
    }
    public static Account anAccount() {
        return new Account();
    }
    public int getAmountOfMoney() {
        return sumOfMoney;
    }

    public void addMoney(int sumOfMoney) {
        this.sumOfMoney += sumOfMoney;
    }

    public void removeMoney(int sumOfMoney) {
        this.sumOfMoney -= sumOfMoney;
    }
}
