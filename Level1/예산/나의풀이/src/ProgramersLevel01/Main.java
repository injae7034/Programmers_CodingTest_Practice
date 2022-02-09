package ProgramersLevel01;

import java.util.Arrays;

public class Main {
    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int i = 0;
        while(i < d.length && budget >= 0)
        {
            budget -= d[i];
            answer++;
            i++;
        }
        if(budget < 0)
        {
            answer--;
        }
        return answer;
    }
    public static void main(String[] args) {
	    int answer = solution(new int[]{1,3,2,5,4}, 9);
        System.out.println(answer);
        answer = solution(new int[]{2,2,3,3}, 10);
        System.out.println(answer);
    }
}
