package service;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(3, calculatorService.add(1, 2));
        assertEquals(1, calculatorService.add(-1, 2));
        assertEquals(-1, calculatorService.add(1, -2));
        assertEquals(-3, calculatorService.add(-1, -2));
        assertEquals(2, calculatorService.add(0, 2));
        assertEquals(1, calculatorService.add(1, 0));
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    void testSub() {
        assertEquals(-1, calculatorService.sub(1, 2));
        assertEquals(3, calculatorService.sub(1, -2));
        assertEquals(-3, calculatorService.sub(-1, 2));
        assertEquals(1, calculatorService.sub(-1, -2));
        assertEquals(-2, calculatorService.sub(0, 2));
        assertEquals(1, calculatorService.sub(1, 0));
        assertEquals(0, calculatorService.sub(0, 0));
    }

    @Test
    void multiplicationTest() {
        assertEquals(2, calculatorService.multiplication(1, 2));
        assertEquals(-2, calculatorService.multiplication(-1, 2));
        assertEquals(-2, calculatorService.multiplication(1, -2));
        assertEquals(0, calculatorService.multiplication(0, 2));
        assertEquals(0, calculatorService.multiplication(1, 0));
        assertEquals(0, calculatorService.multiplication(0, 0));
    }

    @Test
    void divTest() {
        assertEquals(0.5, calculatorService.div(1, 2));
        assertEquals(2, calculatorService.div(2, 1));
        assertEquals(0, calculatorService.div(0, 2));
    }

    @Test
    void illegalArgumentInDiv(){
        assertThrows(IllegalArgumentException.class, () -> calculatorService.div(1, 0));
    }
}