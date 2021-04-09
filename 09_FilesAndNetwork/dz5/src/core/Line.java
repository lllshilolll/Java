package core;

import java.util.List;

public class Line {
    private String number;//номер линии
    private String name;//имя линии
    private List<Station> stations;//станции на этой линии

    public Line(String number, String name, List<Station> stations) {
        this.number = number;
        this.name = name;
        this.stations = stations;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }
}