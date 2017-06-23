package by.VPodelinski.ATM;

/**
 * Created by viivpo2010 on 23.6.17.
 */
public class CashCard {

    private String bankName;
    private int pinCode;
    private double balance;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public CashCard(String bankName, int pinCode, int balance) {
        this.bankName = bankName;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public CashCard(String lastName, int pinCode) {
        this(lastName, pinCode, 0);
    }
}
