//юридические лица
public class LegalEntities extends  Client{
    /**У юридических лиц — снятие с комиссией 1%*/

    public LegalEntities(double account) {
        super(account);
    }

    @Override
    public double withdrawingMoney(double money) {
        this.money = money;
        account = account - money - money*0.01;
        return account;
    }

}
