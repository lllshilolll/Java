public class Main {
    public static void main(String[] args) {

        //юридические лица
        LegalEntities clientOne = new LegalEntities(1000.0);
        clientOne.putMoney(1000.0);
        clientOne.withdrawingMoney(500.0);
        clientOne.balance();

        //физические лица
        Individuals clientTwo = new Individuals(500.0);
        clientTwo.putMoney(100.0);
        clientTwo.withdrawingMoney(50.0);
        clientTwo.balance();

        //индивидуальные предприниматели
        Entrepreneurs clientThree = new Entrepreneurs(5000.0);
        clientThree.putMoney(1000.0);
        clientThree.withdrawingMoney(500.0);
        clientThree.balance();

    }
}
