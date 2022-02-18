package ProgramersLevel02;

import java.util.Arrays;

public class Main {
    public static int solution(String s) {
        StringBuilder stb;
        String front;
        String back ;
        int count;
        int[] answer = new int[s.length() / 2];
        if(s.length() == 1)
        {
            return 1;
        }
        for(int i = 1; i < s.length() / 2 + 1; i++)
        {
            front = s.substring(0, i);
            count = 1;
            stb = new StringBuilder();
            for(int j = i; j < s.length(); j += i)
            {
                if(j + i < s.length())
                {
                    back = s.substring(j, j + i);
                }
                else
                {
                    back = s.substring(j);
                }
                if(front.equals(back) == true)
                {
                    count++;
                }
                else
                {
                    if(count > 1)
                    {
                        stb.append(count);
                        count = 1;
                    }
                    stb.append(front);
                    front = back;
                }
            }
            if(count > 1)
            {
                stb.append(count);
            }
            stb.append(front);
            answer[i - 1] = stb.toString().length();
        }
        Arrays.sort(answer);
        return answer[0];
    }
    public static void main(String[] args) {
	    int answer = solution("aabbaccc");
        System.out.println(answer);
        answer = solution("ababcdcdababcdcd");
        System.out.println(answer);
        answer = solution("abcabcdede");
        System.out.println(answer);
        answer = solution("abcabcabcabcdededededede");
        System.out.println(answer);
        answer = solution("xababcdcdababcdcd");
        System.out.println(answer);
        answer = solution("a");
        System.out.println(answer);
    }
}
