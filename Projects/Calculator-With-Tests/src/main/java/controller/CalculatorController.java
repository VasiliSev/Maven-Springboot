package controller;

import model.CalculatorFunctions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {

    private final CalculatorFunctions calculatorService;

    public CalculatorController(CalculatorFunctions calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String hello() {
        return "Добро пожаловать в калькулятор" ;
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null) {
            return "Введите первое слагаемое" ;
        } else if (num2 == null) {
            return "Введите второе слагаемое" ;
        }
        int result = calculatorService.add(num1, num2);
        return num1 + "+" + num2 + "=" + result;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null) {
            return "Введите уменьшаемое" ;
        } else if (num2 == null) {
            return "Введите вычитаемое" ;
        }
        int result = calculatorService.sub(num1, num2);
        return num1 + "-" + num2 + "=" + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null) {
            return "Введите первый множитель" ;
        } else if (num2 == null) {
            return "Введите второй множитель" ;
        }
        int result = calculatorService.multiplication(num1, num2);
        return num1 + "*" + num2 + "=" + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null) {
            return "Введите делимое" ;
        } else if (num2 == null) {
            return "Введите делитель" ;
        }
        if (num2 == 0) {
            return "Введите значение делителя, отличное от нуля" ;
        }
        float result = calculatorService.div(num1, num2);
        return num1 + ":" + num2 + "=" + result;

    }

}
