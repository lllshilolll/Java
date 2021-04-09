public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    //Площадь круга S = pi * radius^2
    public static double getCircleSquare(double radius) {
        double CircleSquare = Math.PI * Math.pow(radius, 2);
        return CircleSquare;
    }

    // метод должен использовать абсолютное значение radius
    //объем сферы V = 4/3 * pi * radius^3
    public static double getSphereVolume(double radius) {
        double SphereVolume = (4 / 3) * Math.PI * Math.pow(radius, 3);
        return SphereVolume;
    }

    //возможно построения треугольника (да/нет)

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        if (((a + b) > c) &&((a + c) > b) && ((b + c) > a)){
            return true;
        }
        else{
            return false;
    }
}
    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    //площадь треугольника S = (p(p-a)(p-b)(p-c))^(1/2)
    public static double getTriangleSquare(double a, double b, double c) {
            if (isTriangleRightAngled(a,b,c)){
            double p = (a + b + c)/2;
            double TriangleSquare = Math.pow(p * (p-a) * (p-b) * (p-c), 0.5);
            return TriangleSquare;}
            else {
                return -1.0;
            }
    }
}
