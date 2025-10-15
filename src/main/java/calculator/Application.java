package calculator;

import java.util.Scanner;

public class Application {
    private static String s;
    private static String seperator;
    private static int result = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        s = sc.nextLine();
        s = s.replace("\\n", "\n"); //custom 구분자 사용 시 \n가 이스케이프로 사용되는 것을 방지
        //사용자 입력이 잘못되었을 경우
        if(s.startsWith("//")){
            int newLineIndex = s.indexOf("\n");
            if(newLineIndex == -1){
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
        }
    }

    private static String customSeparator(String str) {
        String seperator = str.charAt(2) + "";
        s = s.substring(4);
        return seperator;
    }

    private static void decideSeparator(String s) {
        if(!s.startsWith("/")) seperator = "[,:]";
        else seperator = customSeparator(s);
    }

}
