package calculator;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = input();
        String separator = decideSeparator(input);
        int result = calculate(input, separator);
        System.out.println("결과 : " + result);
    }

    private static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");

        if (!sc.hasNextLine()) {
            return "";
        }
        String s = sc.nextLine();
        s = s.replace("\\n", "\n"); //custom 구분자 사용 시 \n가 이스케이프로 사용되는 것을 방지
        if (s.trim().isEmpty()) {
            return "";
        }
        //사용자 입력이 잘못되었을 경우
        if (s.startsWith("//")) {
            int newLineIndex = s.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
        }
        return s;
    }

    private static String customSeparator(String str) {
        // "//;\n1,2,3" 형태 확인
        if (!str.startsWith("//") || !str.contains("\n")) {
            throw new IllegalArgumentException("잘못된 입력 형식");
        }
        return String.valueOf(str.charAt(2)); // 세 번째 문자가 구분자
    }

    private static String decideSeparator(String input) {
        if (!input.startsWith("//")) {
            return "[,:]"; // 기본 구분자
        }
        return customSeparator(input);
    }

    private static int calculate(String input, String separator) {
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
