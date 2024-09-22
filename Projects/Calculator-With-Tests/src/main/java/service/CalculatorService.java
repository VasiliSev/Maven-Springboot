package service;

import model.CalculatorFunctions;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements CalculatorFunctions {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public float div(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divide by zero");
        return (float) a / b;
    }
}