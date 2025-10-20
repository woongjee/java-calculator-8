package calculator.service;

import calculator.model.CalculationResult;

public class CalculatorService {
    public String decideSeparator(String input) {
        if (!input.startsWith("//")) {
            return "[,:]"; // 기본 구분자
        }
        return customSeparator(input);
    }

    private String customSeparator(String str) {
        if (!str.startsWith("//") || !str.contains("\n")) {
            throw new IllegalArgumentException("잘못된 입력 형식");
        }
        int start = str.indexOf("//") + 2;
        int end = str.indexOf("\n");
        if (start >= end) {
            throw new IllegalArgumentException("구분자가 비어 있거나 잘못된 위치에 있음");
        }
        return str.substring(start, end);
    }

    public int calculate(String input, String separator) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String numbers = input;
        if (input.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            numbers = input.substring(newlineIndex + 1);
        }

        String[] arr = numbers.split(separator);
        int result = 0;
        for (String token : arr) {
            if (token.isEmpty()) {
                continue;
            }
            int num;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력.");
            }
            if (num < 0) {
                throw new IllegalArgumentException("양수만 입력 가능.");
            }
            result += num;
        }
        return result;
    }
}
