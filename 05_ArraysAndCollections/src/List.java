import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class List {
    public static void main(String[] args) {

        TreeSet<String> todoList = new TreeSet<>() {{
            add("hello@skillbox.ru");
            add("ppp@google.com");
            add("Klon@yuandex.ru");
        }};

        System.out.println("choose and write: \n ADD \n LIST");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String deals = scanner.nextLine();

            switch (deals) {
                case "ADD":
                    System.out.println("write email");
                    Scanner scanner1 = new Scanner(System.in);
                    String newEmail = scanner1.nextLine();
                    String regexp = "^(?!.*@.*@.*$)(?!.*@.*\\-\\-.*\\..*$)(?!.*@.*\\-\\..*$)(?!.*@.*\\-$)" +
                            "(.*@.+(\\..{1,11})?)$";
                    Pattern pattern = Pattern.compile(regexp);
                    Matcher matcher1 = pattern.matcher(newEmail);
                    boolean b = matcher1.matches();

                    if (b){
                        todoList.add(newEmail);}
                    continue;

                case "LIST":
                    for (String email : todoList){
                        System.out.println(email);
                    }
                    continue;
                default:
                    System.out.println("exception");
                    break;
            }
            scanner.close();
        }
    }
}
