import com.skillbox.airport.*;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Air {

    public static void main (String[] args){

Airport airport = Airport.getInstance();

    //Текущая дата и время
    Calendar dataNow = Calendar.getInstance();
    Date date1 = dataNow.getTime();
    //Дата через 2 часа
        dataNow.setTime(date1);
        dataNow.add(Calendar.HOUR_OF_DAY, 2);
    Date date2 = dataNow.getTime();

    //getTerminals() там getFlights() -->> getDate()
        airport.getTerminals()
                .forEach(terminal -> terminal.getFlights().stream()
    .filter(flight ->flight.getDate().after(date1) && flight.getDate().before(date2)).collect(Collectors.toList()).forEach(System.out::println));
             }
}
