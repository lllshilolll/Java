import java.util.HashMap;
import java.util.Random;

public class Bank {
    public static Double PROBABILITY_OF_TRANSACTION = 0.05;

    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    final double numRandom = Math.random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public long getAmountMoney()
    {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount) {
        //кол-во денег на счетеОтправителе и счетеПринимателе
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        //если проверка не пройдена
        if (!(isChecked(fromAccount, toAccount, amount)))
        {
            return;
        }
        reduceMoney(fromAccount, amount);
        increaseMoney(toAccount, amount);

        //если кол-во суммы > 50000 и это мошенничество
        try {
            if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                //заблокировать счета
                fromAccount.setBlocked(true);
                toAccount.setBlocked(true);
                System.out.println("Аккаунты заблокированы\n");
            }
            //иначе - операция выполена!
            else {
                //System.out.println("Перевод выполнен!\n");
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    private boolean isChecked(Account from, Account to, long amount)
    {   //если один из аккаунтов заблокирован
        if (from.isBlocked() || to.isBlocked())
        {
            System.out.println("Аккаунт заблокирован\n");
            return false;
        }
        //если транзакция входит в 5%
        if (numRandom == Math.random() * PROBABILITY_OF_TRANSACTION)
        {
            final boolean bool = (from.isBlocked() && to.isBlocked());
            return bool;
        }
        //если отправляемая сумма больше суммы аккаунта или сумма < 0
        if (!(from.getMoney() >= amount && amount > 0))
        {
            System.out.println("Ошибка перевода!");
            return false;
        }
        //иначе - проверка пройдена
        return true;
    }
    //уменьшить сумму
    private void reduceMoney(Account account, long amount) {
        account.setMoney(account.getMoney() - amount);
    }
    //увеличить сумму
    private void increaseMoney(Account account, long amount) {
        account.setMoney(account.getMoney() + amount);
    }
}