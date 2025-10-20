package calculator.view;

import java.util.Scanner;

public class InputView {
    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        if (!sc.hasNextLine()) {
            return "";
        }

        String s = sc.nextLine();
        s = s.replace("\\n", "\n"); // 이스케이프 방지

        if (s.trim().isEmpty()) {
            return "";
        }

        if (s.startsWith("//")) {
            int newLineIndex = s.indexOf("\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
        }

        return s;
    }
}
