package Servises;

import by.VPodelinnski.model.ATM;
import by.VPodelinnski.model.Bank;
import by.VPodelinnski.model.Card;
import by.VPodelinnski.model.Cash;

import java.util.Scanner;

/**
 * Created by viivpo2010 on 12.7.17.
 * Сервис банкомата
 */
public class ATMManager {
    ATM atm;
    Card card;
    // создание банкомата
    public ATM createATM(final Bank bank) {
        atm = ATM.aAtm(bank);
        return atm;
    }
    // создаем банкомат и
    //заряжаем банкомат банкнотами добавляем количество каждого номинала банкноты
    public void addCashtoAtm(){
        atm.addCash(50, 40,30,20,0);
        //вывел общую сумму
        System.out.println( "*****" + atm.cashsum() + "*****");
    }
    //вставляем карту
    public void insertCard(Card card) {
        if (checkBank(card) && card.isBlock()) {//если обслуживаемся и карта не блокирована запрашиваем pin
            this.card = card;
            System.out.println("Вставьте карту");
            checkPin();
        } else {
            System.out.println("########################################################");
            System.out.println("Карта вашего банка не поддерживается либо заблокирована");
        }
    }
    // проверяем pin, если pin правильный показываем меню, если нет то блокируем карту
    public void checkPin(){
        System.out.println("Карта принята");
        int count = 0;
        do {
            System.out.println("#################");
            System.out.println("Введите pin-код");
            Scanner scanner = new Scanner(System.in);
            String pin = scanner.next();
            if (pin.equals(card.getPin())){
                showmenu();
                break;
            }
            else{
                count++;
                int tr = 3 - count;
                System.out.println("Неверный pin код! Осталось попыток " + tr);
                if (tr == 0){
                    card.SetBlock(false);
                    System.out.println("Карта заблокирована!");
                }
            }
        }
        while (count != 3);
    }
    //проверяем обслуживается ли карта этого банка
    public boolean checkBank(Card card){
        boolean check = true;
        int count = 0;
        for (String nameBank : atm.setBanks) {
            if(card.getBank().getName().equals(nameBank)){
                count++;
            }
        }
        if(count == 0) check = false;
        return check;
    }
    //меню
    public void showmenu(){
        int n;
        do {
            System.out.println("Введите число для выбора соответсвующего дествия: \n");
            System.out.println("1 - Посмотреть баланс");
            System.out.println("2 - Снять наличные");
            System.out.println("3 - Вернуть карту");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            if (n == 1) {
                System.out.println(card.getAccount().getAmountOfMoney());
                showmenu();
            }
            if (n == 2) secondmenu();
            if (n == 3) break;
            if (n > 3){
                System.out.println("Выберите 1 или 2");
                System.out.println("########################");
            }
        }while (n > 3);
    }
    public void secondmenu() {
        int n;
        do {
            System.out.println("Введите число для выбора соответсвующего дествия:\n");
            System.out.println("1 - Снять 5 рублей");
            System.out.println("2 - Снять 10 рублей");
            System.out.println("3 - Снять 20 рублей");
            System.out.println("4 - Снять 50 рублей");
            System.out.println("5 - Снять 100 рублей");
            System.out.println("6 - Другая сумма");
            System.out.println("0 - Выход");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            switch (n) {
                case 0 :{
                    System.out.println("Карта извлечена");
                    return;
                }
                case 1:
                    removeCash(5);
                    break;
                case 2:
                    removeCash(10);
                    break;
                case 3:
                    removeCash(20);
                    break;
                case 4:
                    removeCash(50);
                    break;
                case 5:
                    removeCash(100);
                    break;
                case 6:{
                    System.out.println("Введите сумму кратную 5");
                    int n2 = scanner.nextInt();
                    if(n2 % 5 == 0 ) removeCash(n2);
                    else{
                        System.out.println("Неверная сумма");
                        secondmenu();
                    }
                }
                break;
                default:
                    System.out.println("Выберите от 1 до 6");
            }
        }while (n > 6 ) ;
    }
    public void removeCash(int money){
        if(card.getAccount().getAmountOfMoney() < money){
            System.out.println("Недостаточно средств на карте");
        }
        if(atm.cashsum() < money){
            System.out.println("Нет денег в банкомате");
            return;
        }
        card.getAccount().removeMoney(money);
        atm.removeCash(money);
        System.out.println("Операция прошла успешно. Можете забирать наличные");
       // getCash(money);
        showmenu();
    }
       // остаток в банкомате
    public void lastCash(){
        int sum =  atm.cashsum();
        System.out.println(sum);
        if(sum <= 5) System.out.println("Нет денег");
    }
}
