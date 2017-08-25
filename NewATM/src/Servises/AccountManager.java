package Servises;

import by.VPodelinnski.model.Account;
import by.VPodelinnski.model.Card;

/**
 * Created by viivpo2010 on 12.7.17.
 * Класс описывающий сервис по управлению аккаунтом
 */
public class AccountManager {
    public Account createAccount() {
        Account account = Account.anAccount();
        //  addMoneyToAccount(account);
        return account;
    }
    public void addMoneyToAccount(final Account account, final int sum) {
        if (account == null) {
            throw new IllegalArgumentException("Аккаунт должен быть не null");
        }
        account.addMoney(Math.abs(sum));
    }
    public void takeMoneyFromAccount(final Account account, final int sum) {
        if (account == null) {
            throw new IllegalArgumentException("Аккаунт должен быть не null, вычитаемая сумма должна быть не отрицательна");
        }
        account.removeMoney(Math.abs(sum));
    }
}
