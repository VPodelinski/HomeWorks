package Servises;

import by.VPodelinnski.model.Account;
import by.VPodelinnski.model.Bank;
import by.VPodelinnski.model.Card;
import by.VPodelinnski.model.Owner;

import java.util.Random;

/**
 * Created by viivpo2010 on 12.7.17.
 * Класс описывающий управление и создания кредитной карты
 */
public class CardManager {
    public Card createCard(Account account, final Bank bank, final Owner owner, final String number, String pin) {
        return new Card(account,  bank,  owner, number, pin);
    }
    public String createNumberCard(){
        Random number = new Random();
        String cardNumber = "444444444444" + number.nextInt(10) + number.nextInt(10)
                + number.nextInt(10) + number.nextInt(10);
        return cardNumber;
    }
    public String createPinCode(){
        Random number = new Random();
        String pinCode = "" + number.nextInt(10) + number.nextInt(10)
                + number.nextInt(10) + number.nextInt(10);
        return pinCode;
    }
    public Bank createBank(String name){
        Bank bank = new Bank(name);
        return bank;
    }
    public Owner owner(final String firstName, final String lastName){
        Owner owner = Owner.anOwner(firstName,lastName);
        return owner;
    }
}
