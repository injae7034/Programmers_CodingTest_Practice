package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;

public class Main {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Arrays.sort(stages);
        List<Integer> stageList = new ArrayList<>();
        for(int stage : stages)
        {
            stageList.add(stage);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Double> failureMap = new HashMap<>();
        for(int i = 0; i < stageList.size(); i++)
        {
            countMap.put(stageList.get(i), countMap.getOrDefault(stageList.get(i), 0) + 1);
        }
        for(int i = 1; i <= N; i++)
        {
            if(countMap.containsKey(i) == false)
            {
                countMap.put(i, 0);
            }
        }
        int index = 1;
        for(Map.Entry<Integer, Integer> map : countMap.entrySet())
        {
            if(index <= N)
            {
                failureMap.put(map.getKey(), (double)map.getValue()
                        / (double)stageList.size());
            }
            for(int j = 0; j < map.getValue(); j++)
            {
                stageList.remove(map.getKey());
            }
            index++;
        }
        List<Integer> resultList = arrangeByValue(failureMap);
        for(int i = 0; i < resultList.size(); i++)
        {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
    public static List<Integer> arrangeByValue(Map<Integer, Double> map)
    {
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Double>>(){
            @Override
            public int compare(Map.Entry<Integer, Double> one, Map.Entry<Integer, Double> other){
                int ret = 0;
                if(one.getValue() > other.getValue())
                {
                    ret = -1;
                }
                else if(one.getValue() == other.getValue())
                {
                    if(one.getKey() > other.getKey())
                    {
                        ret = 1;
                    }
                    else if(one.getKey() > other.getKey())
                    {
                        ret = -1;
                    }
                }
                else if(one.getValue() < other.getValue())
                {
                    ret = 1;
                }
                return ret;
            }
        });
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Double> entryMap : entryList)
        {
            list.add(entryMap.getKey());
        }
        return list;
    }
    public static void main(String[] args) {
	    int[] answer = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(answer.toString());
    }
}
