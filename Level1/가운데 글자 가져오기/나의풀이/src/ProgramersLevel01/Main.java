package ProgramersLevel01;

public class Main {
    public static String solution(String s) {
        String answer = "";
        int length = s.length();
        if(length % 2 == 0)
        {
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        }
        else
        {
            answer = s.substring(length / 2, length / 2 + 1);
        }
        return answer;
    }
    public static void main(String[] args) {
	    String answer = solution("abcde");
        System.out.println(answer);
        answer = solution("qwer");
        System.out.println(answer);
    }
}
