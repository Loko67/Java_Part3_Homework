package HomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;


public class TestAreaOfTriangle2 {
    AreaOfTriangle2 areaOfTriangle2 = new AreaOfTriangle2();

    @ParameterizedTest
    @CsvSource({"2,0,3", "0,2,3", "3,2,0"})
    @DisplayName("Проверка работы функции с нулевым значением")
    void isZeroValue(int a, int b, int c) {
        assertThatExceptionOfType(ExceptionIncorrectValue.class).isThrownBy(() -> areaOfTriangle2.area(a, b, c));
    }

    @Test
    @DisplayName("Проверка работы функции с корректными значениями")
    void isCorrectValue() {
        int a = 2;
        int b = 4;
        int c = 4;
        double p = (double) (a + b + c) / 2;
        double areaTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        Assertions.assertEquals(areaTriangle, areaOfTriangle2.area(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"-1,2,3", "2,-1,3", "2,3,-1"})
    @DisplayName("Проверка работы функции с отрицательными значениями")
    void isNegativeValue(int a, int b, int c) {
        assertThatExceptionOfType(ExceptionIncorrectValue.class).isThrownBy(() -> areaOfTriangle2.area(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,1,3", "2,3,1"})
    @DisplayName("Проверка работы функции при условии, что сумма двух сторон равна третьей")
    void isSumSidesEqualToThird(int a, int b, int c) {
        assertThatExceptionOfType(ExceptionIncorrectValue.class).isThrownBy(() -> areaOfTriangle2.area(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"1,2,4", "2,1,4", "2,4,1"})
    @DisplayName("Проверка работы функции при условии, что сумма двух сторон меньше третьей")
    void isSumSidesLessToThird(int a, int b, int c) {
        assertThatExceptionOfType(ExceptionIncorrectValue.class).isThrownBy(() -> areaOfTriangle2.area(a, b, c));
    }
}
