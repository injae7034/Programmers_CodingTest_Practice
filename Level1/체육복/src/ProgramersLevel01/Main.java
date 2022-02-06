package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Main
{
    public int solution(int n, int[] lost, int[] reserve)
    {
        int answer = n - lost.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n; i++)
        {
            map.put(i, 1);
        }
        for(int i = 0; i < reserve.length; i++)
        {
            map.put(reserve[i], map.get(reserve[i]) + 1);
        }
        for(int i = 0; i < lost.length; i++)
        {
            map.put(lost[i], map.get(lost[i]) - 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry = null;
        int index = 0;
        boolean isFrontReserve = false;
        boolean isBackReserve = false;
        while(iterator.hasNext())
        {
            isFrontReserve = false;
            isBackReserve = false;
            entry = iterator.next();
            if(entry.getValue() == 0)
            {
                index = entry.getKey();
                if(index - 1 >= 1)
                {
                    if(map.get(index - 1) == 2)
                    {
                        isFrontReserve = true;
                    }
                }
                if (index + 1 <= map.size())
                {
                    if(map.get(index + 1) == 2)
                    {
                        isBackReserve = true;
                    }
                }
                if(isFrontReserve == true && isBackReserve == false)
                {
                    map.put(index - 1, 1);
                    answer++;
                }
                else if(isFrontReserve == false && isBackReserve == true)
                {
                    map.put(index + 1, 1);
                    answer++;
                }
            }
        }
        iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            entry = iterator.next();
            if(entry.getValue() == 0)
            {
                index = entry.getKey();
                if(index - 1 >= 1)
                {
                    if(map.get(index - 1) == 2)
                    {
                        answer++;
                    }
                }
                else if (index + 1 <= map.size())
                {
                    if(map.get(index + 1) == 2)
                    {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
	// write your code here
    }
}
