import java.util.HashMap;
import java.util.Map;

public class CSVParser {

    private double income = 0;//приход
    private double expense = 0;//расход
    //создаем мэп Компания-Расходы
    private final Map<String, Double> expenseList = new HashMap<>();

    //считываем csv-файл
    public void CalculateData(String input) {
        //разделяем строку на 8 элементов массива по ","
        String[] columns = input.split(",", 8);
        //парсим 6-ой элемент как дабл Приход
        double incomeTmp = Double.parseDouble(columns[6]);
        //парсим 7-ой элемент как дабл Расход, заменяя \ и , на нужные символы
        double expenseTmp = Double.parseDouble(columns[7].replaceAll("\"", "").replace(',', '.'));
        //если Приход равен 0 -> считаем расход (компания, расход)
        if (incomeTmp == 0) calculateExpense(columns[5], expenseTmp);
            //иначе складываем Приход компании
        else this.income += incomeTmp;
    }

    //считаем Расход (компания, расход)
    private void calculateExpense(String expenseName, double expense) {
        //суммируем Расходы
        this.expense += expense;
        String[] transaction = expenseName.trim().split(" {3,}");
        String[] temp = transaction[1].split("/");
        String[] suppliesTemp = temp[temp.length - 1].split("\\\\");
        String supplies = suppliesTemp[suppliesTemp.length - 1];
        if (!expenseList.containsKey(supplies))
            expenseList.put(supplies, expense);
        else {
            double sum = expenseList.get(supplies);
            sum += expense;
            expenseList.put(supplies.trim(), sum);
        }
    }

    public void printData() {
        System.out.println("Сумма расходов: " + expense + " руб.");
        System.out.println("Сумма доходов: " + income + " руб.");
        System.out.println("              ");
        System.out.println("Суммы расходов по организациям:");

        for (String supplies : expenseList.keySet()) {
            System.out.println(supplies + "\t" + expenseList.get(supplies) + " руб");
        }

    }
}

