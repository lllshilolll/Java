public class Manager implements Employee {
    /**
     * зарплата складывается из фиксированной части и бонуса в виде 5% от
     * заработанных для компании денег. Количество заработанных денег для
     * компании генерируйте случайным образом от 115 000 до 140 000 рублей.
     * @return
     */

    Company company;
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getMonthSalary() {
        int moneyCompany = (int) (Math.random() * (140000 - 115000) + 115000);
        int salaryManager = 50000 + moneyCompany * 100 / 5;
        return salaryManager;
    }
}


