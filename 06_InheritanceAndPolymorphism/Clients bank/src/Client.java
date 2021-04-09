public abstract class Client {
    /**У каждого клиента есть сумма денег на счету (число).
     Деньги можно положить на счёт, снять и вернуть остаток на счёте.
     Каждый класс должен содержать метод, который выводит информацию в консоль о счёте:
     условие пополнения, условие снятия и баланс.*/

    protected double money;
    protected double account;

    public Client(double account) {
        this.account = account;
    }

    //положить деньги
    public double putMoney(double money){
        this.money = money;
        account = account + money;
        return account;
    }

    //снять деньги
    public double withdrawingMoney(double money){
        this.money = money;
        account = account - money;
        return account;
    }

    //баланс
    public void balance(){
        System.out.println("Balance equals: " + account);
    }

}



