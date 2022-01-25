package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main
{
    static class Solution
    {
        public static int[] solution(String [] id_list, String[] report, int k)
        {
            int[] answer = new int[id_list.length];
            Map<String, List<Integer>> reportingIdPostions = new LinkedHashMap<>(id_list.length);
            int[] reportedCounts = new int[id_list.length];
            for (int i = 0; i < id_list.length; i++)
            {
                List<Integer> childOfReportingPositioins = new ArrayList<>();
                for(int j = 0; j < report.length; j++)
                {
                    if(id_list[i].compareTo(report[j].substring(0, report[j].indexOf(" "))) == 0)
                    {
                        for (int m = 0; m < id_list.length; m++)
                        {
                            if(report[j].substring(report[j].indexOf(" ") + 1)
                                    .compareTo(id_list[m]) == 0)
                            {
                                childOfReportingPositioins.add(m);
                                reportedCounts[m]++;
                                break;
                            }
                        }
                    }
                }
                reportingIdPostions.put(id_list[i], childOfReportingPositioins);
            }
            List<Integer> pausedIdIndexes = new ArrayList<>();
            for(int i = 0; i < reportedCounts.length; i++)
            {
                if(reportedCounts[i] >= k)
                {
                    pausedIdIndexes.add(i);
                }
            }
            for(int i = 0; i < reportingIdPostions.size(); i++)
            {
                for(int j = 0; j < reportingIdPostions.get(id_list[i]).size(); j++)
                {
                    for(int m = 0; m < pausedIdIndexes.size(); m++)
                    {
                        if(reportingIdPostions.get(id_list[i]).get(j).equals(pausedIdIndexes.get(m)) == true)
                        {
                            (answer[i])++;
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = Solution.solution(id_list, report, k);
        System.out.print("결과출력 : ");
        System.out.println(result);
    }
}


