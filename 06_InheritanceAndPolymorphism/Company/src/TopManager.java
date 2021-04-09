public class TopManager implements Employee {
    /**
     * зарплата складывается из фиксированной части и бонуса в виде 150%
     * от заработной платы, если доход компании более 10 млн рублей.
     * @return
     */
    Company company;
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int salaryTopManager;
        if (company.getIncome() > 10000000) {
            salaryTopManager = 50000 + 50000 * 3 / 2;
        } else {
            salaryTopManager = 50000;
        }
        return salaryTopManager;
    }
}
