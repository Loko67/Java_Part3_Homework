package HomeWork4;

import HomeWork4.AreaOfTtriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class TestAreaOfTriangle {
    AreaOfTtriangle areaOfTtriangle = new AreaOfTtriangle();

    @ParameterizedTest
    @CsvSource({"2,0,3", "0,2,3", "3,2,0"})
    @DisplayName("Проверка работы функции с нулевым значением")
    void isZeroValueThenError(int a, int b, int c) {
        String messageTest = areaOfTtriangle.area(a, b, c);
        Assertions.assertTrue("Треугольника с такими сторонами не существует".equals(messageTest));
    }

    @Test
    @DisplayName("Проверка работы функции с корректными значениями")
    void isCorrectValueThenOk() {
        int a = 2;
        int b = 4;
        int c = 4;
        double p = (double) (a + b + c) / 2;
        double areaTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        String messageTest = areaOfTtriangle.area(a, b, c);
        String message = "Площадь треугольнка = " + areaTriangle;
        Assertions.assertTrue(message.equals(messageTest));
    }

    @ParameterizedTest
    @CsvSource({"-1,2,3", "2,-1,3", "2,3,-1"})
    @DisplayName("Проверка работы функции с отрицательными значениями")
    void isNegativeValueThenError(int a, int b, int c) {
        String messageTest = areaOfTtriangle.area(a, b, c);
        Assertions.assertTrue("Нельзя использовать отрицательные значения".equals(messageTest));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,1,3", "2,3,1"})
    @DisplayName("Проверка работы функции при условии, что сумма двух сторон равна третьей")
    void isSumSidesEqualToThirdThenError(int a, int b, int c) {
        String messageTest = areaOfTtriangle.area(a, b, c);
        Assertions.assertTrue("Треугольника с такими сторонами не существует".equals(messageTest));
    }
    @ParameterizedTest
    @CsvSource({"1,2,4", "2,1,4", "2,4,1"})
    @DisplayName("Проверка работы функции при условии, что сумма двух сторон меньше третьей")
    void isSumSidesLessToThirdThenError(int a, int b, int c) {
        String messageTest = areaOfTtriangle.area(a, b, c);
        Assertions.assertTrue("Треугольника с такими сторонами не существует".equals(messageTest));
    }
}