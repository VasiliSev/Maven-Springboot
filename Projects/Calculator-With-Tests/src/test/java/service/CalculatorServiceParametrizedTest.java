package service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceParametrizedTest {

    CalculatorService calculatorService = new CalculatorService();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(1, 2),
                Arguments.of(-1, 2),
                Arguments.of(1, -2),
                Arguments.of(-1, -2),
                Arguments.of(1, 0),
                Arguments.of(0, 2),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testAdd (int a, int b) {
        assertEquals(a+b, calculatorService.add(a, b));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testSub (int a, int b) {
        assertEquals(a-b, calculatorService.sub(a, b));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testMultiplication (int a, int b) {
        assertEquals(a*b, calculatorService.multiplication(a, b));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void testDiv (int a, int b) {
        if (b == 0) {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.div(a, b));
        } else {
            assertEquals((float) a / b, calculatorService.div(a, b));
        }
    }
}
