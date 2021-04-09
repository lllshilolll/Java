import java.util.*;

public class CarPlate {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //используемые буквы
        String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        //генерация номеров авто
        for (int e = 1; e < 200; e++) {
            for (int i = 0; i < letters.length; i++) {
                for (int j = 1; j < 10; j++) {
                    String currChar = letters[i];
                    String number = String.format("%s%d%d%d%s%s%s", currChar, j, j, j, currChar, currChar, currChar + e);
                   list.add(number);
                }
            }
        }

        HashSet<String> set = new HashSet<>();
        set.addAll(list);

        TreeSet<String> tree = new TreeSet<>();
        tree.addAll(list);

        Scanner scanner = new Scanner(System.in);
        for (;;)
        {
            String coolNumber = scanner.nextLine();

            long start1 = System.nanoTime();
            boolean value = list.contains(coolNumber);
            long time1 = System.nanoTime() - start1;
            System.out.println("Поиск перебором: номер " + (value ?  "найден": "не найден") + ", поиск занял " + time1 + "нс");

            long start2 = System.nanoTime();
            int bi = Collections.binarySearch(list, coolNumber);
            long time2 = System.nanoTime() - start2;
            System.out.println("Бинарный поиск: номер " + (bi >= 0 ?  "найден": "не найден") + ", поиск занял " + time2 + "нс");

            long start3 = System.nanoTime();
            boolean se = set.contains(coolNumber);
            long time3 = System.nanoTime() - start3;
            System.out.println("Поиск в HashSet: номер " + (se ?  "найден": "не найден") + ", поиск занял " + time3 + "нс");

            long start4 = System.nanoTime();
            boolean tr = tree.contains(coolNumber);
            long time4 = System.nanoTime() - start4;
            System.out.println("Поиск в TreeSet: номер " + (tr ?  "найден": "не найден") + ", поиск занял " + time4 + "нс");
        }
    }
}

