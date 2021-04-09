import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfInform {
    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008 1234 5678> 8912", "***");
        System.out.println(safe);
    }
    public static String  searchAndReplaceDiamonds(String text, String placeholder){
        Pattern pattern = Pattern.compile("<.+>");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(placeholder);

        return text;

    }
}
