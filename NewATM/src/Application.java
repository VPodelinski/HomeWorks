import Servises.ATMManager;
import Servises.AccountManager;
import Servises.CardManager;
import by.VPodelinnski.model.Bank;
import by.VPodelinnski.model.Card;

/**
 * Created by viivpo2010 on 12.7.17.
 */
public class Application {
    public static void main(String... args) {
        CardManager cardManager = new CardManager();//создаю объект сервиса управления аккаунтом
        AccountManager accountManager = new AccountManager();//создаю объект сервиса управления карты
        // создаем кредитную карту и генерим пинкод и номер карты, заполняем данные и создаем аккаунт в банке
        Card card1 =  cardManager.createCard(accountManager.createAccount(), cardManager.createBank("BPSBank"), cardManager.owner("Vitali", "Podelinski"),cardManager.createNumberCard(), cardManager.createPinCode());
        Card card2 =  cardManager.createCard(accountManager.createAccount(), cardManager.createBank(" IDEABANK"), cardManager.owner("Ivan", "Ivanov"),cardManager.createNumberCard(), cardManager.createPinCode());
        card1.getAccount().addMoney(1000);//счет на аккаунте при 0 рублей, добавляю на счет сумму
        //вывожу все данные по карте для наглядности
        System.out.println("Баланс на карте: "+card1.getAccount().getAmountOfMoney() + " рублей Название банка: "+ card1.getBank().getName()+ " номер карты: "+card1.getNumber()+ " пинкод: " + card1.getPin()+" владелец: "+card1.getOwner().getFirstName() +" "+ card1.getOwner().getLastName());
        System.out.println("Баланс на карте: "+card2.getAccount().getAmountOfMoney() + " рублей Название банка: "+ card2.getBank().getName()+ " номер карты: "+card2.getNumber()+ " пинкод: " + card2.getPin()+" владелец: "+card2.getOwner().getFirstName() +" "+ card2.getOwner().getLastName());
        System.out.println("Пинкод " + card1.getPin());//вывожу пинкод для наглядности
        System.out.println("Сумма на счете: " + card1.getAccount().getAmountOfMoney());// сумма на карточке
        accountManager.takeMoneyFromAccount(card1.getAccount(), 354);// снятие суммы c аккаунта
        ATMManager atmManager = new ATMManager();//создаю объект сервиса банкомата
        Bank bank = new Bank("BPS");// создаю банк
        atmManager.createATM(bank);// создаю банкомат
        System.out.println("Общая сумма в банкомате по умолчанию");
        atmManager.addCashtoAtm();
        atmManager.checkBank(card1);//запускаю эмуляцию банкомата
        atmManager.insertCard(card1);//вставка карты в банкомат
        System.out.println("Сумма на счете: " + card1.getAccount().getAmountOfMoney());// сумма на карточке
        System.out.println("Общая сумма в банкомате остаток ");
        atmManager.lastCash();// остаток в банкомате
    }
   }
