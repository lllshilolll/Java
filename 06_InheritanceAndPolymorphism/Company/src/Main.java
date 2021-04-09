
public class Main {
    public static void main(String[] args) {
        Company company1 = new Company();
        Operator operator = new Operator();
        //привязываем работника к компании
        operator.setCompany(company1);

        company1.hireAll(operator, 10);
        company1.fire(operator);

        System.out.println(company1.getTopSalaryStaff(10));
        System.out.println(operator.getCompany());
        System.out.println(company1.getIncome());
        System.out.println("====================");

        Company company2 = new Company();
        Manager manager = new Manager();
        Operator operator2 = new Operator();
        TopManager topManager = new TopManager();
        manager.setCompany(company2);
        operator2.setCompany(company2);
        topManager.setCompany(company2);

        company2.hireAll(manager, 80);
        company2.hireAll(operator2, 180);
        company2.hireAll(topManager, 10);

        System.out.println(company2.getTopSalaryStaff(10));
        System.out.println(company2.getLowestSalaryStaff(30));
        company2.firePer(50);
        System.out.println(company2.getTopSalaryStaff(10));
        System.out.println(company2.getLowestSalaryStaff(30));
        System.out.println(operator2.getCompany());
        System.out.println(company2.getIncome());

    }
}
