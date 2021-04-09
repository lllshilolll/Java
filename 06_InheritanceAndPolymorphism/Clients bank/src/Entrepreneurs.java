//индивидуальные предприниматели
public class Entrepreneurs extends Client {
    /**пополнение с комиссией 1%, если сумма меньше 1000 рублей.
     * И с комиссией 0,5%, если сумма больше либо равна 1000 рублей*/

    public Entrepreneurs(double account) {
        super(account);
    }

    public double putMoney(double money) {
        if (money <= 1000.0){
            account = account + money - money * 0.01;
        }
        else{
            account = account + money - money*0.005;
        }
        return account;
    }
}


