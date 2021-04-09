public class BankAccount {

    protected double account;//счет в банке
    protected double money;

    public BankAccount(double account) {
        this.account = account;

    }
 //Снять со счёта сумму денег (без комиссии).
    public double withdrawMoney(double money)
    {            this.money = money;

        if (account> 0.0) {
            account = account - money;
        }
        return account;

    }
    //Вносить на счёт сумму денег (без комиссии).
    public double putMoney(double money)
    {
        this.money = money;
        account = account + money;
        return account;
    }
    //Получить остаток на счёте.
    public void balance()
    {
        System.out.println("Баланс: " + account);
    }

    public boolean send(BankAccount receiver, double amount)
    {
        if (amount <= account)
        {
            withdrawMoney(amount);
            receiver.putMoney(amount);
            return true;
        }
            else {
            return false;
        }
    }



}
