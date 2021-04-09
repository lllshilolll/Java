import java.util.ArrayList;
import java.util.Comparator;

class CompanyComparator1 implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        if(o1.getMonthSalary() > o2.getMonthSalary()){
            return 1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()){
            return -1;
        }return 0;
    }
}
class CompanyComparator2 implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getMonthSalary() > o2.getMonthSalary()) {
            return -1;
        }
        if (o1.getMonthSalary() < o2.getMonthSalary()) {
            return 1;
        }
            return 0;
    }
}

