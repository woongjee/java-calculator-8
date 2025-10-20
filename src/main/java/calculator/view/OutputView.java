package calculator.view;

import calculator.model.CalculationResult;

public class OutputView {
    public static void printResult(CalculationResult result) {
        System.out.println("결과 : " + result.getValue());
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
