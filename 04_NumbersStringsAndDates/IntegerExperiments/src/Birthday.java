import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Birthday {
    public static void main(String [] args)  {
        int day = 2;
        int month = 0;
        int year = 2001;

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EEE");
        Calendar birthday = Calendar.getInstance();//дата рождения
        Calendar current = Calendar.getInstance();//текущая дата
        birthday.set(year, month, day, 0, 0, 0);
        //пока дата рождения меньше текущей даты:
        for (int i = 0; birthday.before(current); i++){
            System.out.println(i+ " - " + dateFormat.format(birthday.getTime()));
            birthday.add(Calendar.YEAR, 1);}
}}

