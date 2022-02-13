package ProgramersLevel02;

import java.util.StringTokenizer;

public class Main {
    public static String solution(String s) {
        s = s.toLowerCase();
        StringTokenizer tokens = new StringTokenizer(s, " ");
        char[] strArr = s.toCharArray();
        for(int i = 0; i < strArr.length; i++)
        {
            if(strArr[i] != ' ')
            {
                if(48 > strArr[i] || strArr[i] > 57)
                {
                    strArr[i] = String.valueOf(strArr[i]).toUpperCase().charAt(0);
                }
                i += tokens.nextToken().length() - 1;
            }
        }
        return new String(strArr);
    }
    public static void main(String[] args) {
	    String answer = solution("3people unFollowed me");
        System.out.println(answer);
        answer = solution("for the last week");
        System.out.println(answer);
    }
}
