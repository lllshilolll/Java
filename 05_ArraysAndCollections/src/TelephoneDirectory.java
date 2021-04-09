import java.lang.ref.SoftReference;
import java.security.KeyStore;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneDirectory {

    //поиск всех ключей по значению
    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

//Ключ - имя, т.к. список надо предоставить в алфавитном порядке
//Значение - номер телефона

    public static void main(String[] args) {
        TreeMap<String, String> book = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);

        for (;;){

        String data = scanner.nextLine();

            //регулярное выражение для имени абонента(ключа)
            String regexp = "^([а-я А-Я]+)$";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(data);

            //регулярное выражение для номера телефона(значения)
            String regexp1 = "[0-9]";
            Pattern pattern1 = Pattern.compile(regexp1);
            Matcher matcher1 = pattern1.matcher(data);

        if (data.equals("LIST")) {//выводить все карты.
            printTreeMap(book);
            continue;}
        else if(matcher.find())//если введен ключ:
        {
            if (book.containsKey(data))//поиск введенного ключа
                {
                    System.out.println(data + " " + book.get(data));// "ключ значение"
                }
            else{
                System.out.println("Введите номер телефона нового контакта");
                Scanner scanner1 = new Scanner(System.in);
                String phoneNumber = scanner1.nextLine();
                book.put(data, phoneNumber);//добавляем в мэп новый ключ-значение
            }
            continue;}

        else if(matcher1.find()){//если введено значение:
            if (book.containsValue(data))//поиск введенного значения
            {
                System.out.println(getKey(book, data) + " " + data);//печатаем ключ и значение
            }
            else {
            System.out.println("Введите имя нового контакта");
            Scanner scanner1 = new Scanner(System.in);
            String Name = scanner1.nextLine();
            book.put(Name, data);

        } continue;}
    }}
    //Печать мэпа
    private static void printTreeMap(TreeMap<String, String> map){
        for(String key : map.keySet())
        {
            System.out.println(key + " " +  map.get(key));
        }
    }}



