package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;

public class Main {

    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            Map<Integer, Boolean> numMaps = new HashMap<>();
            for(int i = 0; i < 10; i++)
            {
                numMaps.put(i, false);
            }
            for(int num : numbers)
            {
                numMaps.replace(num, true);
            }
            for(int i = 0; i < numMaps.size(); i++)
            {
                if(numMaps.get(i) == false)
                {
                    answer += i;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
