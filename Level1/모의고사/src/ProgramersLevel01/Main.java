package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static int[] solution(int[] answers) {
        int countOne = 0;
        int countTwo = 0;
        int countThree = 0;
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int i = 0;
        int j = 0;
        int k = 0;
        for(int l = 0; l < answers.length; l++)
        {
            if(i >= one.length)
            {
                i = 0;
            }
            if(answers[l] == one[i])
            {
                countOne++;
            }
            i++;
            if(j >= two.length)
            {
                j = 0;
            }
            if(answers[l] == two[j])
            {
                countTwo++;
            }
            j++;
            if(k >= three.length)
            {
                k = 0;
            }
            if(answers[l] == three[k])
            {
                countThree++;
            }
            k++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, countOne);
        map.put(2, countTwo);
        map.put(3, countThree);
        int max = 0;
        for(int m = 1; m < 4; m++)
        {
            if(max < map.get(m))
            {
                max = map.get(m);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int m = 1; m < 4; m++)
        {
            if(max == map.get(m))
            {
                list.add(m);
            }
        }
        int[] answer = new int[list.size()];
        for(int m = 0; m < answer.length; m++)
        {
            answer[m] = list.get(m);
        }
        return answer;
    }

    public static void main(String[] args)
    {
        int[] answers = new int[]{1, 2, 3, 4 ,5};
        int[] answer = solution(answers);
        System.out.println(answer);
    }
}
