package ProgramersLevel01;

public class Main {

    class Solution
    {
        public int solution(int[] nums)
        {
            int answer = 0;
            for(int i = 0; i < nums.length - 2; i++)
            {
                for(int j = i + 1; j < nums.length - 1; j++)
                {
                    for(int k = j + 1; k < nums.length; k++)
                    {
                        if(isPrimeNumber(nums[i] + nums[j] + nums[k]) == true)
                        {
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
        private boolean isPrimeNumber(int number)
        {
            for(int i=2; i*i <= number; i++)
            {
                if(number % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
