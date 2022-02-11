package ProgramersLevel01;

import java.util.StringTokenizer;

public class Main {
    public static String solution(String s) {
        char[] arr = s.toCharArray();
        StringTokenizer tokens = new StringTokenizer(s, " ");
        String word= "";
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != ' ')
            {
                word = tokens.nextToken();
                for(int j = 0; j < word.length(); j++)
                {
                    if(j % 2 == 0)
                    {
                        arr[i] = String.valueOf(arr[i]).toUpperCase().charAt(0);
                    }
                    else
                    {
                        arr[i] = String.valueOf(arr[i]).toLowerCase().charAt(0);
                    }
                    i++;
                }

            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
	    String answer = solution("try      hello    world");
        System.out.println(answer);
    }
}
