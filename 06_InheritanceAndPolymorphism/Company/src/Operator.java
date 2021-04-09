public class Operator implements Employee {

    /**
     * зарплата складывается только из фиксированной части.
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
        int salaryOperator = 50000;
        return salaryOperator;
    }
}
