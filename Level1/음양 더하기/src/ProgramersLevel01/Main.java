package ProgramersLevel01;

public class Main {

    class Solution {
        public int solution(int[] absolutes, boolean[] signs) {
            int answer = 0;
            for(int i = 0; i < absolutes.length; i++)
            {
                if(signs[i] == true)
                {
                    answer += absolutes[i];
                }
                else
                {
                    answer -= absolutes[i];
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
