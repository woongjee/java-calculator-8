package calculator.controller;

import calculator.model.CalculationResult;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();

    public void run() {
        try {
            String input = InputView.input();
            String separator = calculatorService.decideSeparator(input);
            int result = calculatorService.calculate(input, separator);
            OutputView.printResult(new CalculationResult(result));
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
