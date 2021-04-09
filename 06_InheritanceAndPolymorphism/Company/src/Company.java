import java.util.*;

public class Company {
    private int income = (int) (Math.random() * (100000000 - 5000000) + 5000000);

    public Company() {
        this.income = income;
    }

    //получение значения дохода компании –
    public int getIncome() {
        return this.income;
    }

    private ArrayList<Employee> staff = new ArrayList<>();

    //найм одного сотрудника —
    public void hire(Employee employee) {
        staff.add(employee);
    }

    //найм списка сотрудников –
    public void hireAll(Employee employee, int num) {
        for (int i = 0; i < num; i++) {
            staff.add(employee);
        }
    }

    //увольнение 1го сотрудника
    public void fire(Employee employee) {
        staff.remove(employee);
    }

    //увольнение сотрудников в процентах–
    public void firePer(int percent) {
        for (int i = 0; i < staff.size() * percent / 100; i++) {
            staff.remove(i);
        }
    }

    public List<Integer> getTopSalaryStaff(int count) {
        staff.sort(Comparator.comparingInt(Employee::getMonthSalary).reversed());
        List<Integer> result = new ArrayList<>();
        if (count > staff.size()) {
            for (int i = 0; i < staff.size(); i++)
                result.add(staff.get(i).getMonthSalary());
        } else {
            for (int i = 0; i < count; i++)
                result.add(staff.get(i).getMonthSalary());
        }

        return result;
    }

    public List<Integer> getLowestSalaryStaff(int count) {
        staff.sort(Comparator.comparingInt(Employee::getMonthSalary));
        List<Integer> result = new ArrayList<>();
        if (count > staff.size()) {
            for (int i = 0; i < staff.size(); i++)
                result.add(staff.get(i).getMonthSalary());
        } else {
            for (int i = 0; i < count; i++)
                result.add(staff.get(i).getMonthSalary());
        }

        return result;
    }
}
