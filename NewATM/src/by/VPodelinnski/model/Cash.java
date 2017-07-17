package by.VPodelinnski.model;

/**
 * Created by viivpo2010 on 12.7.17.
 * Банкноты и номинал их
 */
public class Cash {
    private static final int cash5 = 5;
    private static final int cash10 = 10;
    private static final int cash20 = 20;
    private static final int cash50 = 50;
    private static final int cash100 = 100;
    public static int getCash5() {
        return cash5;
    }
    public static int getCash10() {
        return cash10;
    }
    public static int getCash20() {
        return cash20;
    }
    public static int getCash50() {
        return cash50;
    }
    public static int getCash100() {
        return cash100;
    }
}
