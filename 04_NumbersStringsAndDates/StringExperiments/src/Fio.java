import java.util.Scanner;
import  java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fio {
    public static void main(String[] args) {
        Scanner fio = new Scanner(System.in);
        String text = fio.nextLine();
/**         Проверка на:
 + количество слов 3-4 (учитываем двойные отчества «Ахмед оглы»)
 + первые три слова - с большой буквы (двойные имена и фамилии - вторая часть тоже с большой буквы, например Салтыков-Щедрин)
 + все остальные буквы - маленькие
 + нет знаков препинания и прочих символов, за исключением тире (двойные имена и фамилии могут содержать)
 */
        String regexp = "^([А-Я]{1}[а-я]+)([-][А-Я]{1}[а-я]+)*\\s+([А-Я]{1}[а-я]+)([-][А-Я]{1}[а-я]+)*\\s+" +
                "([А-Я]{1}[а-я]+)([-][А-Я][а-я])*\\s*([а-я]*)$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher1 = pattern.matcher(text);
        boolean b = matcher1.matches();

        if (b){
            String [] initials = text.split(" ");

            System.out.println("Фамилия: " + initials[0]);
            System.out.println("Имя: " + initials[1]);
            System.out.println(initials.length == 4 ? "Отчество: " + initials[2] + " " + initials[3] : "Отчество: " + initials[2]);
        }
        else {
            System.out.println("ФИО введено не корректно");
        }
    }}




