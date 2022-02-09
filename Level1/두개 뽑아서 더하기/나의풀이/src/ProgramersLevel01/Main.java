package ProgramersLevel01;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    public static int[] solution(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[numberSet.size()];
        int index = 0;
        for(int number : numberSet)
        {
            answer[index] = number;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
	    int[] answer = solution(new int[]{2,1,3,4,1});
        System.out.println(Arrays.toString(answer));
        answer = solution(new int[]{5,0,2,7});
        System.out.println(Arrays.toString(answer));
    }
}
