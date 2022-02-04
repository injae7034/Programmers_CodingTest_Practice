package ProgramersLevel01;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static int[] solution(int[] answers)
    {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] hitCounts = new int[3];
        for(int i = 0; i < hitCounts.length; i++)
        {
            for(int j = 0; j < answers.length; j++)
            {
                if(patterns[i][j % patterns[i].length] == answers[j])
                {
                    hitCounts[i]++;
                }
            }
        }
        int max = Math.max(hitCounts[0], Math.max(hitCounts[1], hitCounts[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hitCounts.length; i++)
        {
            if(max == hitCounts[i])
            {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int number : list)
        {
            answer[index++] = number;
        }
        return  answer;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
