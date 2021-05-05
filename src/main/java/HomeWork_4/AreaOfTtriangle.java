package HomeWork4;

public class AreaOfTtriangle {
    public String area(int a, int b, int c) {
        double s;
        String message;
        if (a < 0 || b < 0 || c < 0) {
            message = "Нельзя использовать отрицательные значения";
            return message;
        }
        if (a + b > c && a + c > b && b + c > a) {
            double p = (double) (a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            message = "Площадь треугольнка = " + s;
            return message;
        } else
            message = "Треугольника с такими сторонами не существует";
        return message;
    }
}