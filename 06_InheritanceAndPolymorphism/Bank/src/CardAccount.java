public class CardAccount extends BankAccount{
    /**Карточный счёт, при снятии денег с которого будет взиматься комиссия 1%*/

    public CardAccount(double account)
    {
        super(account);
    }

    public double withdrawMoney(double money)
    {            this.money = money;

        if (account > 0.0) {
            account = account - money - money * 0.01;
        }
        return account;
    }
}
