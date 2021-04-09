import core.Line;
import core.Station;
import junit.framework.TestCase;


import java.util.*;


public class RouteCalculatorTest extends TestCase {
    List<Station> route; //маршрут
    RouteCalculator routeCalculator; //класс для поиска маршрута и расчета времени поездки
    StationIndex stationIndex; //список станции
    Line line1;
    Line line2;
    Line line3;
    Station station1 ;
    Station station2 ;
    Station station3 ;
    Station station4 ;
    Station station5 ;
    Station station6 ;
    Station station7 ;
    Station station8 ;
    TreeMap<Station, TreeSet<Station>> connections;

    protected void setUp() throws Exception {
        //создаем 2 соединения веток на определенных станциях
        TreeSet<Station> connectedStations1 = new TreeSet<>();
        TreeSet<Station> connectedStations2 = new TreeSet<>();
        connections = new TreeMap<>();
        //создаем маршрут для проверки расчета времени поездки
        route = new ArrayList<>();
        //создаем 3 ветки метро
        line1 = new Line(1, "Первая");
        line2 = new Line(2, "Вторая");
        line3 = new Line(3, "Третья");

        stationIndex = new StationIndex();

        //добавляем 6 станции
        station1 = new Station("Гостиный двор", line1);
        station2 = new Station("Маяковская", line1);
        station3 = new Station("Площадь восстания", line2);
        station4 = new Station("Чернышевская", line2);
        station5 = new Station("Невский проспект", line3);
        station6 = new Station("Горьковская", line3);
        station7 = new Station("Василеостровская", line1);
        station8 = new Station("Приморская", line1);
        //добавляем станции на ветки метро
        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station7);
        line1.addStation(station8);
        line2.addStation(station3);
        line2.addStation(station4);
        line3.addStation(station5);
        line3.addStation(station6);

        //добавляем соединения в обобщенный класс
        connectedStations1.add(station1);
        connectedStations1.add(station5);
        connectedStations2.add(station2);
        connectedStations2.add(station3);
        connections.put(station1, connectedStations1);
        connections.put(station5, connectedStations1);
        connections.put(station2, connectedStations2);
        connections.put(station3, connectedStations2);
        //добавляем станции в мршрут
        route.add(station1);
        route.add(station2);
        route.add(station3);
        route.add(station4);
        route.add(station5);
        route.add(station6);
        //добавляем ветки в обобщенный класс
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        //!!!!!!!!!!!!!!!!!!!!!
        stationIndex.connections = connections;
        //добавляем станции в обобщенный класс
        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);

        //создаем экземпляр класса расчета маршрута с нашим собранным обобщенным классом
        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetRouteOnTheLine() {
        List<Station> actual = routeCalculator.getRouteOnTheLine(station1, station8);
        List<Station> expected = new ArrayList<>();
        expected.add(station1);
        expected.add(station2);
        expected.add(station7);
        expected.add(station8);
        assertEquals(expected, actual);
    }
    public void testGetRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getRouteWithOneConnection(station1, station4);
        List<Station> expected = new ArrayList<>();
        expected.add(station1);
        expected.add(station2);
        expected.add(station3);
        expected.add(station4);
        assertEquals(expected, actual);
    }

    public void testGetRouteViaConnectedLine() {
        List<Station> actual = routeCalculator.getRouteViaConnectedLine(station2, station5);
        List<Station> expected = new ArrayList<>();
        expected.add(station2);
        expected.add(station1);
        assertEquals(expected, actual);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getRouteWithTwoConnections(station4, station6);
        List<Station> expected = new ArrayList<>();
        expected.add(station4);
        expected.add(station3);
        expected.add(station2);
        expected.add(station1);
        expected.add(station5);
        expected.add(station6);
        assertEquals(expected, actual);
    }

    public void testIsConnected(){
        boolean actual = routeCalculator.isConnected(station2, station3);
        assertTrue(actual);
    }

    public void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(station4, station6);
        List<Station> expected = new ArrayList<>();
        expected.add(station4);
        expected.add(station3);
        expected.add(station2);
        expected.add(station1);
        expected.add(station5);
        expected.add(station6);
        assertEquals(expected, actual);
    }


    }



