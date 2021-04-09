package core;

public class Station {
    private String stationNumberLine;
    private String name;

    public Station(String stationNumberLine, String name) {
        this.stationNumberLine = stationNumberLine;
        this.name = name;
    }

    public String getStationNumberLine() {
        return stationNumberLine;
    }

    public String getName() {
        return name;
    }
}