package ProgramersLevel01;

import java.util.Arrays;

public class Main {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] arr1String = new String[arr1.length];
        for(int i = 0; i < arr1String.length; i++)
        {
            arr1String[i] = "";
        }
        for(int i  = 0; i < arr1.length; i++)
        {
            while(arr1[i] > 0)
            {
                arr1String[i] = (arr1[i] % 2) + arr1String[i];
                arr1[i] /= 2;
            }
            while(arr1String[i].length() < n)
            {
                arr1String[i] = 0 + arr1String[i];
            }
        }
        String[] arr2String = new String[arr2.length];
        for(int i = 0; i < arr2String.length; i++)
        {
            arr2String[i] = "";
        }
        for(int i  = 0; i < arr2.length; i++)
        {
            while(arr2[i] > 0)
            {
                arr2String[i] = (arr2[i] % 2) + arr2String[i];
                arr2[i] /= 2;
            }
            while(arr2String[i].length() < n)
            {
                arr2String[i] = 0 + arr2String[i];
            }
        }
        String[] answer = new String[n];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = "";
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(arr1String[i].charAt(j) == '1' || arr2String[i].charAt(j) == '1')
                {
                    answer[i] += "#";
                }
                else
                {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
	    String[] answer = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(Arrays.toString(answer));
        answer = solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
        System.out.println(Arrays.toString(answer));
    }
}
