package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.Attributes;

public class Main {
    public static int[] solution(int []arr) {
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                {
                    arr[j] = 10;
                }
                else
                {
                    break;
                }
            }
        }
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 10)
            {
                arrList.add(arr[i]);
            }
        }
        int[] answer = new int[arrList.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = arrList.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
	    int[] answer = solution(new int[]{1,1,3,3,0,1,1});
        System.out.println(Arrays.toString(answer));
        answer = solution(new int[]{4,4,4,3,3});
        System.out.println(Arrays.toString(answer));
    }
}