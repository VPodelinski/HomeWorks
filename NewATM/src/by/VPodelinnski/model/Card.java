package by.VPodelinnski.model;

/**
 * Клас описывающий кредитную карту
 */
public class Card {
    private final String number;
    private final Account account;
    private final Bank bank;
    private final Owner owner;
    private final String pin;
    private boolean block = true;//поля блокировки карты, false - заблокирована блоктруется после неверного  ввода
    //пинкода 3 раза
    public Card(Account account, final Bank bank, final Owner owner, final String number, String pin) {
        this.account = account;
        this.bank = bank;
        this.owner = owner;
        this.number = number;
        this.pin = pin;
    }
    public Account getAccount() {
        return account;
    }
    public Bank getBank() {
        return bank;
    }
    public Owner getOwner() {
        return owner;
    }
    public String getNumber() {
        return number;
    }
    public String getPin() {
        return pin;
    }
    public boolean isBlock() {
        return block;
    }
    public void SetBlock(boolean b){
        block = b;
    }
}
