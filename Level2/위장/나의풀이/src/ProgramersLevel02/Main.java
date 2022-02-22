package ProgramersLevel02;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static int solution(String[][] clothes) {
        int answer = 0;
        answer += clothes.length;
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String[] cloth : clothes)
        {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(String key : map.keySet())
        {
            list.add(map.get(key));
        }
        for(int i = 2; i <= list.size(); i++)
        {
            int sum = 0;
            Integer occasion = 1;
            int j = 0;
            while(j < i - 1)
            {
                occasion *= list.get(j);
                j++;
            }
            for(int k = j - 1; k < list.size() - 1; k++)
            {
                for(int l = k + 1; l < list.size(); l++)
                {
                    sum += occasion * list.get(l);
                }
            }
            answer += sum;
        }
        return answer;
    }
    public static void main(String[] args) {
        int answer = solution(new String[][]{{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(answer);
        answer = solution(new String[][]{{"crowmask", "face"},
                {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println(answer);
    }
}
