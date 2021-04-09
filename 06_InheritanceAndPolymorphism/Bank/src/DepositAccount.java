public class DepositAccount extends BankAccount {
    /**
     * Депозитный расчётный счёт, с которого нельзя снимать деньги в течение месяца после последнего внесения
     */

    public DepositAccount(double account) {
        super(account);
    }

    public double withdrawMoney(double money) {
        this.money = money;
        System.out.println("С депозитного расчетного счета нельзя снять деньги!");
        return account;
    }

    public boolean send(BankAccount receiver, double amount) {
            return false;
    }
}


