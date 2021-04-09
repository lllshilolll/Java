import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator
{
    private StationIndex stationIndex;

    private static double interStationDuration = 2.5;
    private static double interConnectionDuration = 3.5;

    public RouteCalculator(StationIndex stationIndex)
    {
        this.stationIndex = stationIndex;
    }

    //получить кратчайший маршрут
    public List<Station> getShortestRoute(Station from, Station to)
    {
        //Маршрут = Маршрут по одной линии
        List<Station> route = getRouteOnTheLine(from, to);
        if(route != null) {
            return route;
        }
        //Маршрут = Маршрут с одной развязкой
        route = getRouteWithOneConnection(from, to);
        //!!!!!!!!!!!!!!!!!
        //Если размер Маршрута не равен 0
        if(route.size() != 0) {
            return route;
        }
        //Маршрут = Маршрут с двумя развязками
        route = getRouteWithTwoConnections(from, to);
        return route;
    }
    //рассчитать время
    public static double calculateDuration(List<Station> route)
    {
        //Продолжительность
        double duration = 0;
        //предыдущая станция
        Station previousStation = null;
        for(int i = 0; i < route.size(); i++)
        {
            Station station = route.get(i);
            if(i > 0)
            {
                //если пердыдущия и следующая станции находятся на одной Линии +2,5, иначе +3,5
                duration += previousStation.getLine().equals(station.getLine()) ?
                    interStationDuration : interConnectionDuration;
            }
            previousStation = station;
        }
        return duration;
    }

    //=========================================================================

    //получить маршрут на Одной Линии
    List<Station> getRouteOnTheLine(Station from, Station to)
    {
        //если Линии метро не равны возвращать null
        if(!from.getLine().equals(to.getLine())) {
            return null;
        }
        //создание массива Маршрут
        ArrayList<Station> route = new ArrayList<>();
        //лист Станций по начальной линии
        List<Station> stations = from.getLine().getStations();
        //направление
        int direction = 0;
        for(Station station : stations)
        {
            //если направление не меняется
            if(direction == 0)
            {
                //перебор станций
                //если станция равна начальной
                if(station.equals(from)) {
                    //направление = 1
                    direction = 1;
                }
                //если станция равна конечной
                else if(station.equals(to)) {
                    //направление = -1
                    direction = -1;
                }
            }
            //если направление не равно 0
            if(direction != 0) {
                //добавить в маршрут станцию
                route.add(station);
            }
            //если направление = 1 и станция равна конечной
            //или направление равно -1 и станция равна начальной
            //выходить из цикла
            if((direction == 1 && station.equals(to)) ||
                (direction == -1 && station.equals(from))) {
                break;
            }
        }
        //если направление равно -1
        if(direction == -1) {
            //Маршрут развернуть в обратном порядке
            Collections.reverse(route);
        }
        return route;
    }
    //получить маршрут с Одной Развязкой
    List<Station> getRouteWithOneConnection(Station from, Station to)
    {
        //если Линии метро равны вернуть null
        if(from.getLine().equals(to.getLine())) {
            return null;
        }
        //новый Маршрут
        ArrayList<Station> route = new ArrayList<>();
        //лист станций по Начальной линии
        List<Station> fromLineStations = from.getLine().getStations();
        //лист станций по Конечной линии
        List<Station> toLineStations = to.getLine().getStations();
        for(Station srcStation : fromLineStations)
        {
            for(Station dstStation : toLineStations)
            {
                //перебор элементов в листах
                //если станции на ветках совпали
                //(srcStation==dstStation)
                if(isConnected(srcStation, dstStation))
                {
                    //новый массиы Путь
                    ArrayList<Station> way = new ArrayList<>();
                    //добавить станции от начальной до Совпадающей
                    way.addAll(getRouteOnTheLine(from, srcStation));
                    //и от совпадающей до конечной
                    way.addAll(getRouteOnTheLine(dstStation, to));
                    //если Маршрут пуст  или размер Маршрута > размера Пути--??
                    if(route.isEmpty() || route.size() > way.size())
                    {
                        //отчистить Маршрут
                        route.clear();
                        //добавить в пустой Маршрут Путь
                        route.addAll(way);
                    }
                }
            }
        }
        return route;
    }
    //есть ли Соединение(развязка)
    boolean isConnected(Station station1, Station station2)
    {
        //в connected кладется второе название станции
        Set<Station> connected = stationIndex.getConnectedStations(station1);
        //если station2 совпадает со вторым название True, иначе - False
        return connected.contains(station2);
    }
    //получить маршрут через соединенные линии
    List<Station> getRouteViaConnectedLine(Station from, Station to)
    {
        //Сет станций по Начальной линии
        Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        //Сет станций по Конечной линии
        Set<Station> toConnected = stationIndex.getConnectedStations(to);
        for(Station srcStation : fromConnected)
        {
            for(Station dstStation : toConnected)
            {
                //перебор сетов
                //если Линия станции srcStation равна Линии станции dstStation
                if(srcStation.getLine().equals(dstStation.getLine())) {
                    //Вывод Маршрута на одной линии--??
                    return getRouteOnTheLine(srcStation, dstStation);
                }
            }
        }
        return null;
    }
    //получить маршрут с двумя Развязками
    List<Station> getRouteWithTwoConnections(Station from, Station to)
    {
        //если линии у станций одинаковы - возвращать null
        if (from.getLine().equals(to.getLine())) {
            return null;
        }
        //новый Маршрут
        ArrayList<Station> route = new ArrayList<>();
        //лист станций по Начальной линии
        List<Station> fromLineStations = from.getLine().getStations();
        //лист станций по Конечной линии
        List<Station> toLineStations = to.getLine().getStations();
        for(Station srcStation : fromLineStations)
        {
            for (Station dstStation : toLineStations)
            {
                //Лист соединенных линий по пути
                List<Station> connectedLineRoute = getRouteViaConnectedLine(srcStation, dstStation);
                if(connectedLineRoute == null) {
                    continue;
                }
                //Новый массив Путь
                ArrayList<Station> way = new ArrayList<>();
                //добавить в Путь все станции линии от начальной
                way.addAll(getRouteOnTheLine(from, srcStation));
                //добавить в Путь Лист соединенных линий по пути
                way.addAll(connectedLineRoute);
                //добавить в Путь все станции линии до конечной
                way.addAll(getRouteOnTheLine(dstStation, to));
                //если Маршрут пуст или размер Маршрута > размера Пути
                if(route.isEmpty() || route.size() > way.size())
                {
                    //перезаписать Маршрут
                    route.clear();
                    route.addAll(way);
                }
            }
        }

        return route;
    }
}