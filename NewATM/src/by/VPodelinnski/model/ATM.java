package by.VPodelinnski.model;

import java.util.*;

/**
 * Created by viivpo2010 on 12.7.17.
 * Банкомат
 */
public class ATM {
    private final Bank bank;
    private Map<Integer , Integer> mapCash ;// map для хранения банкнот
    public final static Set<String> setBanks = new HashSet();// set для названий банков карточек которые могут обслуживаться
    static {
        setBanks.add("BelarusBank");
        setBanks.add("BPSBank");
        setBanks.add("BelInvestBank");
    }
    private ATM(final Bank bank) {
        this.bank = bank;
        mapCash = new LinkedHashMap<>(); // Linked для порядка вставки
    }
    public static ATM aAtm(final Bank bank) {
        if (bank == null) {
            throw new IllegalArgumentException("банк не может быть пустым");
        }
        return new ATM(bank);
    }
    public Map<Integer, Integer> getMapCash() {
        return mapCash;
    }
    //добавляем банкноты и их количество
    public void addCash( Integer count5, Integer count10, Integer count20, Integer count50, Integer count100) {
        this.getMapCash().put(Cash.getCash100(), count100);
        this.getMapCash().put(Cash.getCash50(), count50);
        this.getMapCash().put(Cash.getCash20(), count20);
        this.getMapCash().put(Cash.getCash10(), count10);
        this.getMapCash().put(Cash.getCash5(), count5);
    }
    //вся  сумма денег в банкомате
    //получаю значение количества денег по ключу map и умножаю с номиналов банкноты,
    //затем все плюсую и получаю общую сумму
    //выдаем наличные и уменьшаем сумму в банкомате
    //алгоритм будет выдавть купюры номиналом от самой большой
    public void removeCash(Integer countCash) {
        if (countCash == null) {
            throw new IllegalArgumentException("сумма не должн быть пустой");
        }
        // получаю все значения ключей
        System.out.println("Выдано наличных");
        for (Map.Entry<Integer, Integer> entry : getMapCash().entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            //System.out.println( "Номинал - "+ key + " количество банкнот  " + value);//отображение значения всех банкнот
            int sumCash = countCash / key;// кол. банкнот
            if (sumCash >= 0 && key*value >= countCash ) {// если деление запрашиваемой суммы
                //на номинал банкноты и сумма в банкомате больше равно запрашиваемой
                System.out.println(" Банкноты по " + key +  " - " + sumCash + " шт.");
                mapCash.put(key,(value = value - sumCash));
                // если в сумме
                //есть такие банкноты вывожу их количество которое выдано и отнимаю в банкомате
                countCash = countCash - key * sumCash; //отнимаем наличные которые забрали
            }
            else continue;
        }
    }
    //вся  сумма денег в банкомате
    //получаю значение количества денег по ключу map и умножаю с номиналов банкноты,
    //затем все плюсую и получаю общую сумму
    public int cashsum(){
        int sum = getMapCash().get(Cash.getCash5()) * 5 + getMapCash().get(Cash.getCash10()) * 10 + getMapCash().get(Cash.getCash20()) * 20 + getMapCash().get(Cash.getCash50()) * 50 + getMapCash().get(Cash.getCash100()) * 100;
        return sum;
    }
    public Bank getBank() {
        return bank;
    }
}
