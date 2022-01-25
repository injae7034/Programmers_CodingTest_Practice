# 내가 푼 코드

```java
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
```

# 내가 푼 코드에서 부족한 점
## 첫번째, Map<String, List\<Integer\>\>까지 밖에 생각을 못함.
### 그래서 한 회원이 똑같은 회원을 중복해서 신고하는 경우를 거르지 못함.
## 두번째, 신고한 회원만 Map을 이용하고, 신고당한 회원은 ArrayList를 사용
### 이로 인해 이중반복구조와 선택구조가 많아져서 코드가 복잡하고 이해하기 어려움.
<br><br>
# 아쉬운점과 깨달은 점
## 처음에 왜 Map을 이용하면서 회원id를 key값으로 이용할 생각을 하지 않고, 왜 id_list에 있는 배열첨자(회원id위치)를 Key(Integer)값으로 하려 했을까?;;
## 그리고 결국에 마지막에 회원id를 key값으로 쓰는데 까지는 갔는데 거기서 왜 Set은 생각을 못하고, List밖에 생각을 못했을까?
## Set을 이용하면 중복이 되는 것을 쉽게 거를 수 있는데, List를 이용해서 중복을 어떻게 하면 거를까 왜 고민했을까?;;
## 신고당한 회원은 ArrayList로 이용했는데 결국에 id_list와 일치하는 배열첨자를 이용하여 신고당한 횟수를 저장하고, 가져오려 했으나 이는 직관적이지 못하고 헷갈림.
### Map과 Set에 대해서 잘알고 있다고 생각했으나 전혀 잘알지못하고 있었음;;
### 또한 String에서 문자열을 분리하는 방법은 substring말고 split도 있고, StringTokenizer클래스를 이용해서도 가능하다는 것을 알게됨. 
