import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import core.Line;
import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String URL = "https://ru.wikipedia.org/wiki/Список_станций_Московского_метрополитена";
    public static final String FILE_NAME = "E:/skillbox/java_basics/09_FilesAndNetwork/dz5/data/MoscowMerto.json";
    //"Буквы от А до я один или более раз, еще один или отсутствует любой символ один или более раз,
    // один или отсутствует пробел Буквы от А до я один или более раз"
    public static final String LINE_NAME_REGEX = "\"[А-я]+?.+?\\s[А-я]+?.+?\\s[А-я]+\"";


    public static void main(String[] args) {
        try {
            //maxBodySize(0) - метод, устанавливающий максимальное значение получаемых данных
            Element table = Jsoup.connect(URL).maxBodySize(0).get()
                    //Найти первый table содержащие <span title="Сокольническая линия">
                    .select("table:has(span[title='Сокольническая линия'])").first();
            //Распределение станций на линии
            List<Line> linesWithStations = getLinesWithStations(getLines(table), getStations(table));
            //Создание json-файла
            JSONObject metro = new JSONObject();
            JSONArray lines = getJsonLines(linesWithStations);
            JSONObject stations = getJsonStations(linesWithStations);
            metro.put("stations", stations);
            metro.put("lines", lines);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.write(Paths.get(FILE_NAME), gson.toJson(metro).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

//======================================================================================

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            System.out.println("Количество станций на каждой линии: ");
            stationsObject.keySet().stream()
                    .sorted(Comparator.comparingInt(s ->
                            Integer.parseInt(((String) s).replaceAll("[^\\d]", "")))
                    )
                    .forEach(lineNumberObject ->
                    {
                        JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
                        int stationsOnLineCount = stationsArray.size();
                        System.out.println(lineNumberObject + " : " + stationsOnLineCount);
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //мэп Линий(Номер линии, Имя линии) на вход ("парсингованый" текст)
    public static Map<String, String> getLines(Element table) {
        TreeMap<String, String> lines = new TreeMap<>();
        //выделяем элементы по tr - внутри каждого линия, станция, инфа о станции
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            //выделяем элементы по td - подразделы
            Elements cols = rows.get(i).select("td");
            //выделяем 1-ый подраздел и в нем первого потомка span (номер линии)
            String lineNumber = cols.get(0).select("span:first-child").text();
            //если номер линии < 10
            if (lineNumber.charAt(0) == '0') {
                //записать номер линии со 2-го символа "01"->"1"
                lineNumber = lineNumber.substring(1);
            }

            Matcher m = Pattern.compile(LINE_NAME_REGEX).matcher(cols.get(0).html());
            // если в 1-ом подразделе есть название линии
            if (m.find()) {
                //group() - возвращает символы найденного совпадени.
                //Имя линии записывается без ковычек
                String lineName = m.group().substring(1, m.group().length() - 1);
                //в трииМэп записыватся: Номер линии, Имя линии
                lines.put(lineNumber, lineName);
            }
        }
        return lines;
    }

    //Список всех станций
    public static List<Station> getStations(Element table) {
        List<Station> stations = new ArrayList<>();
        //выделяем элементы по tr - внутри каждого линия, станция, инфа о станции
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++) {
            //выделяем элементы по td - подразделы
            Elements cols = rows.get(i).select("td");
            //выделяем 1-ый подраздел и в нем первого потомка span (номер линии)
            String lineNumber = cols.get(0).select("span:first-child").text();
            if (lineNumber.charAt(0) == '0') {
                lineNumber = lineNumber.substring(1);
            }
            //выделяем второй подраздел - Имя станции
            String station = cols.get(1).select("span a").text();
            //В список станций добавляем новую станцию(Номер линии, Имя станции)
            stations.add(new Station(lineNumber, station));
        }
        return stations;
    }

    //мэп (Номера, Имена линий), Список всех Станций
    public static List<Line> getLinesWithStations(Map<String, String> lines, List<Station> stations) {
        List<Line> linesWithStations = new ArrayList<>();
        for (String lineNumber : lines.keySet()) {
            List<Station> stationsOnLine = new ArrayList<>();
            for (Station station : stations) {
                //если Номер линии станции равен номеру линии
                if (station.getStationNumberLine().equals(lineNumber)) {
                    //добавить станцию на линию
                    stationsOnLine.add(station);
                }
            }
            //добавить новую линию(номер линии, название линии, станции на линии)
            linesWithStations.add(new Line(lineNumber, lines.get(lineNumber), stationsOnLine));
        }
        return linesWithStations;
    }

    public static JSONArray getJsonLines(List<Line> linesWithStations) {
        JSONArray lines = new JSONArray();
        for (Line line : linesWithStations) {
            JSONObject l = new JSONObject();
            l.put("number", line.getNumber());
            l.put("name", line.getName());
            lines.add(l);
        }
        return lines;
    }

    public static JSONObject getJsonStations(List<Line> linesWithStations) {
        JSONObject stations = new JSONObject();
        for (Line line : linesWithStations) {
            JSONArray list = new JSONArray();
            line.getStations().forEach(station -> list.add(station.getName()));
            stations.put(line.getNumber(), list);
        }
        return stations;
    }


    public static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
