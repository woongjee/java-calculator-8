package calculator;

import java.util.Scanner;

public class Application {
    private static String s;
    private static String seperator;
    private static int result = 0;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        input();
        decideSeparator(s);
        System.out.println("결과 : "+ calculate());
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

    private static int calculate(){
        String[] arr = s.split(seperator);
        for(String token : arr){
            if(Integer.parseInt(token) <=0) throw new IllegalArgumentException("양수만 입력 가능");
            try{
                Integer.parseInt(token);
            } catch(NumberFormatException e){
                throw new IllegalArgumentException("숫자가 아닌 값이 입력");
            }
        }
        for(String str : arr) {
            for (char c : str.toCharArray()) {
                if((!Character.isDigit(c))) continue;
                result += Integer.parseInt(c+"");
            }
        }
        return result;
    }
}
