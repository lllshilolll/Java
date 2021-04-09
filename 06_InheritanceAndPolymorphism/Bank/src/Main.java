import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        System.out.println("проверка банковского счета: ");
        BankAccount myMoney = new BankAccount(15000.0);
        myMoney.putMoney(1500.0);
        myMoney.withdrawMoney(100.0);
        myMoney.balance();
        System.out.println("------------------");

        System.out.println("проверка депозитного счета: ");
        DepositAccount myDepositMoney = new DepositAccount(100000.0);
        myDepositMoney.putMoney(1500.0);
        myDepositMoney.balance();
        myDepositMoney.withdrawMoney(2000.0);
        System.out.println("------------------");

        System.out.println("проверка карточного счета");
        CardAccount myCardMoney = new CardAccount(20000.0);
        myCardMoney.putMoney(1500.0);
        myCardMoney.withdrawMoney(100.0);
        myCardMoney.balance();
        System.out.println("------------------");

        System.out.println("переводы между банками: ");
        BankAccount bank = new BankAccount(15000.0);
        DepositAccount deposit = new DepositAccount(800.0);
        CardAccount card = new CardAccount(500.0);
        // с депозита на банковский
        System.out.println(deposit.send(bank,200.0));
        deposit.balance();
        bank.balance();
        //с карты на депозит
        System.out.println(card.send(deposit, 100.0));
        card.balance();
        deposit.balance();
        //с банка на карту
        System.out.println(bank.send(card, 2000.0));
        bank.balance();
        card.balance();
    }
}
