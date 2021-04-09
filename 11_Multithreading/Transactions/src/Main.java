import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static Integer TRANSFERS_QUANTITY = 100000;
    public static Integer TREADS_QUANTITY = 6;

    public static void main(String[] args) {
        Bank bank = new Bank(accounts());
        Random random = new Random();

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < TREADS_QUANTITY; i++)
        {
            threads.add(new Thread(
                    ()->{
                        for (int j = 0; j < TRANSFERS_QUANTITY; j++)
                        {
                            //accounts().keySet() - возвращает названия аккаунтов
                            //keySet().size() - кол-во переменных
                            //random.nextInt(int bound) - рандомное число от 0 до bound-1
                            String toAccounts = new ArrayList<>(accounts().keySet()).get(random.nextInt(accounts().keySet().size()));
                            String fromAccounts = new ArrayList<>(accounts().keySet()).get(random.nextInt(accounts().keySet().size()));
                            bank.transfer(fromAccounts, toAccounts, 1);
                        }}));
        }
        threads.forEach(Thread::start);
        System.out.println("Баланс до транзакции в банке: " + bank.getAmountMoney() + "\n");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        for (Thread thread : threads){
            try {
                //join - Ожидает, пока эта ветка умрет.
                thread.join();
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("1: " + bank.getBalance("1") + " status: " + !Account.isBlocked());
        System.out.println("2: " + bank.getBalance("2") + " status: " + !Account.isBlocked());
        System.out.println("3: " + bank.getBalance("3") + " status: " + !Account.isBlocked());

        System.out.println("Баланс после транзакции в банке" + bank.getAmountMoney() + "\n");
    }
    public static HashMap<String, Account> accounts()
    {
        HashMap<String, Account> accounts = new HashMap<>();
        Account id1 = new Account(1000000, "1");
        Account id2 = new Account(5000000, "2");
        Account id3 = new Account(10000, "3");

        accounts.put(id1.getAccNumber(), id1);
        accounts.put(id2.getAccNumber(), id2);
        accounts.put(id3.getAccNumber(), id3);

        return accounts;
    }
}
