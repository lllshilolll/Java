public class Account
{
    //блокировка счета(да/нет)
    private static boolean blocked;
    //кол-во денег на счете - значение
    private long money;
    //номер счета - ключ
    private String accNumber;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
        blocked = false;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public static synchronized boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
