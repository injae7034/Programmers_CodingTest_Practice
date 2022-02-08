package ProgramersLevel01;

import java.util.Set;
import java.util.HashSet;

public class Main {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> numberSet = new HashSet<>();
        for(int number : nums)
        {
            numberSet.add(number);
        }
        for(int i = 1; i <= nums.length / 2; i++)
        {
            if(i <= numberSet.size())
            {
                answer++;
            }
            else
            {
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
