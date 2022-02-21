package ProgramersLevel02;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static int solution(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++)
        {
            list.add(priorities[i]);
        }
        int temp;
        int i = 0;
        int answer = 0;
        while(i < list.size())
        {
            temp = list.get(0);
            int j = 1;
            while(j < list.size())
            {
                if(temp < list.get(j))
                {
                    list.remove(0);
                    list.add(temp);
                    if(location > 0)
                    {
                        location--;
                    }
                    else
                    {
                        location = list.size() - 1;
                    }
                    temp = list.get(0);
                    j = 1;
                }
                else
                {
                    j++;
                }
            }
            answer++;
            list.remove(0);
            if(location == 0)
            {
                break;
            }
            else
            {
                location--;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
	    int answer = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(answer);
        answer  = solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(answer);
    }
}
