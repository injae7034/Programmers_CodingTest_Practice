package ProgramersLevel01;

public class Main {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            String[] numbers = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] stringNumbers = new String[]{"zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < 10; i++)
            {
                s = s.replace(stringNumbers[i], numbers[i]);
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }
    public static void main(String[] args) {
        // write your code here
    }
}
