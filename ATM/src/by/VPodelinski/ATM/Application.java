package by.VPodelinski.ATM;

/**
 * Created by viivpo2010 on 23.6.17.
 */
public class Application {
    public static void main(String[] args) {
        CashCard card1 = new CashCard("BPSbank", 1234, 600 );
        CashCard card2 = new CashCard("BelarusBank", 1434, 600 );
        Atm atm = new Atm(5, 10, 14,7);
        atm.authorize(card2,1434);
        atm.putMoney(100, card1);
        atm.takeMoney(700,card1);
    }

}
