public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;
        System.out.println(sumDigits(5059191));
        }
    public static int sumDigits(int number) {
            // методы Integer: toString() - преобразование в строку, parseInt() - преобразует строку в число;
            // методы String: charAt() - возвращает символ по указанному индексу строки,
            // length() - длинна строки, valueOf() - преобразует в нужный тип данных.
            String num = Integer.toString(number);//преобразуем число в строчку
            int kol = num.length();//количество символов
            int i = 0;
            char s;
            int sum = 0;
            while (i < kol) {
                s = num.charAt(i); // возращает символы типа char по порядку
                sum = sum + Character.getNumericValue(s);// преобразуем char в int и складываем
                i++;
            }
                return sum;
    }
}
