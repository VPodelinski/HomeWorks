package by.VPodelinski.ATM;

/**
 * Created by viivpo2010 on 23.6.17.
 */
public class Atm implements ATMServise {

    final private static String[] listBank = {"BPSbank", "BelarusBank", "BelInvestBank"};

    private int banknote5;
    private int banknote10;
    private int banknote20;
    private int banknote50;
    double sum ;

    public Atm(final int banknote5, final int banknote10, final int banknote20, final int banknote50) {
        if (banknote5 >= 0 && banknote10 >= 0 && banknote20 >= 0 && banknote50 >= 0) {
            this.banknote5 = banknote5;
            this.banknote10 = banknote10;
            this.banknote20 = banknote20;
            this.banknote50 = banknote50;
            listMoney();

        }
    }

    private void listMoney() {
        System.out.println("banknotes in ATM:");
        System.out.println("Банкноты номиналом 5 = " + banknote5);
        System.out.println("Банкноты номиналом 10 = " + banknote10);
        System.out.println("Банкноты номиналом 20 = " + banknote20);
        System.out.println("Банкноты номиналом 50 = " + banknote50);
        sum = banknote5 * 5 + banknote10 * 10 + banknote20 * 20 + banknote50 * 50;
        System.out.println("Сумма в банкомате " + sum);
    }



    @Override
    public boolean authorize(CashCard card, int pin) {
        boolean b = false;
        for (String bankName : listBank) {
            if (bankName.equals(card.getBankName())) {
                b = true;
            }
        }
        if (b) {
            if (pin == card.getPinCode()) {
                System.out.println("Pin ok. Авторизация прошла успешно.");
            } else {
                System.out.println("Неверный pin");
                b = false;
            }
        } else {
            System.out.println("Карточка вашего банка не поддерживается!");
        }
        return b;
    }


    @Override
    public void putMoney(double sum, CashCard card) {
        card.setBalance(card.getBalance() + sum);
        System.out.println("Зачисленно на карту " +sum  + " , баланс составляет "+card.getBalance());

    }

    @Override
    public void takeMoney ( double sum, CashCard card)  {
        System.out.println("Наличие в банкомате  "+ this.sum);
        System.out.println("Наличие на карте  "+ card.getBalance());
        System.out.println("Снятие денег " + sum);

        if (sum > this.sum){
            System.out.println("Недостаточно денег  в банкомате "); return;}
        if (sum > card.getBalance()){
            System.out.println("Недостаточно денег на карте"); return;}

        this.sum = this.sum - sum;
        card.setBalance(card.getBalance() - sum);
        System.out.println("Остаток в банкомате " + this.sum );
        System.out.println("Остаток на кате " + card.getBalance());
        System.out.println("Выдано купюрами:\n 50 - "+ (int)sum/50 +" штук,\n 20 - "+ (int)sum%50/20 +"  штук,\n 10 - "+ (int)(sum%50%20)/10+" штук,\n 5 - "+ (int)sum%10/5 + "штук.");
    }


}

