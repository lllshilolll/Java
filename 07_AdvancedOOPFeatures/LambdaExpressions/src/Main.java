import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    private static String staffFile = "E:/skillbox/java_basics/07_AdvancedOOPFeatures/LambdaExpressions/data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
        Calendar calendar = new GregorianCalendar(2016, 11 , 31);
        Date date = calendar.getTime();
        Calendar calendar1 = new GregorianCalendar(2018, 0, 1);
        Date date1 = calendar1.getTime();
        //выделяем людей, начавших работу 2017 году.
        List<Employee> n = staff.stream().filter(s -> s.getWorkStart().after(date) && s.getWorkStart().before(date1)).collect(Collectors.toList());
                n.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);



        /**Comparator<Employee> employee__Salary__Name__Comparator
                = Comparator.comparing(Employee::getSalary)
                .thenComparing(Employee::getName);
        Collections.sort(staff, employee__Salary__Name__Comparator);

        for (Employee employee : staff) {
            System.out.println(employee);
        }*/
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}
/**(staff, (o1, o2) -> {
 //если зарплаты не равны, выводить в порядке возрастания
 if (o1.getSalary().compareTo(o2.getSalary()) != 0) {
 return o1.getSalary().compareTo(o2.getSalary());}
 //выводить имена в алфавитном порядке
 return o1.getName().compareTo(o2.getName());
 });*/