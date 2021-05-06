package HomeWork4;

public class AreaOfTriangle2 {
    public double area(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            throw new ExceptionIncorrectValue("Нельзя использовать нулевые значения");
        }
        if (a < 0 || b < 0 || c < 0) {
            throw new ExceptionIncorrectValue("Нельзя использовать отрицательные значения");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new ExceptionIncorrectValue("Треугольника с такими сторонами не существует");
        }
        double s;
        double p = (double) (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
