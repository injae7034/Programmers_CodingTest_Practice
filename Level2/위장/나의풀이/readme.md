# 내가 푼 코드

```java
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
```

# 내가 푼 코드 설명

우선 정답으로 반환할 answer를 0으로 초기화해준다음에 옷을 최소한 1개는 입어야 하기 때문에<br><br>
clothes의 length만큼을 더해줍니다.<br><br>
그렇게 되면 옷을 1개만 입는 경우의 수는 모두 처리됩니다.<br><br>
이제 다음으로 옷을 2개 입는 경우의 수와 3개 또는 그 이상 옷을 입는 경우의 수를 구해야 합니다.<br><br>
그러기 위해 먼저 Map의 객체 map을 LinkedHashMap의 생성자로 만들고, Key는 String, Value는 Integer로 설정합니다.<br><br>
clothes 2차원 배열을 for each반복을 통해 cloth 1차원배열을 구하고 거기서 1번째 배열첨자의 요소를 key값으로<br><br>
value는 getOrDefault를 이용해 key값이 이미 map에 들어가 있는 경우 그 value값을 구한 다음 1을 더해주고,<br><br>
key값이 없는 경우에는 0을 초기값으로 한 다음 1을 더해줍니다.<br><br>
여기까지는 **Level1에서 풀이한 '완주하지 못한 선수'** 와 풀이 방법이 같습니다.<br><br>
<a href="https://programmers.co.kr/learn/courses/30/lessons/42576" target="_blank">프로그래머스 - 완주하지 못한 선수</a><br><br>
<a href="https://github.com/injae7034/Programmers_CodingTest_Practice/tree/main/Level1/%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80%20%EB%AA%BB%ED%95%9C%20%EC%84%A0%EC%88%98" target="_blank">깃허브 - 완주하지 못한 선수</a><br><br>
map을 생성하고 초기화가 끝났으면 list를 생성해서 map의 value값을 list로 옮겨줍니다.<br><br>
그 이유는 map에서는 2개의 조합, 3개의 조합, ... n개의 조합을 반복문을 이용해 표현하기가 어렵기 때문입니다.<br><br>
1개의 조합은 이미 answer에 더해져 있기 때문에<br><br>
2개의 조합부터 시작합니다.<br><br>
i = 2부터 시작하여 length보다 작거나 같은 동안 반복합니다.<br><br>
2개의 조합일 경우 while반복에서 1개 조합 경우의 수를 구한 다음 for 2중반복에서 나머지 원소들과 경우의 수를 구합니다.<br><br>
3개의 조합일 경우 while반복에서 2개의 조합 경우의 수를 구한 다음 for 2중반복에서 나머지 원소들과 경우의 수를 구합니다.<br><br>
이런식으로 for2중반복이 끝날때마다 누적된 경우의 수 sum을 answer에 누적시키고 while 반복이 끝나면 answer를 반환합니다.

# 아쉬운 점
HashMap의 key값과 value값 설정까지는 좋았으나 경우의 수를 구하는 과정에서 다중반복을 이용하면서<br><br>
코드가 길어지고 너무 복잡해서 결국 디버깅도 제대로 안되고 부분점수만 맞고 틀리게 되었습니다.<br><br>
매번 느끼는 것이지만 문제를 풀다가 너무 복잡해지고 헷갈리면 풀이방식이 잘못된 것이기 때문에<br><br>
풀이방식을 바꿔야 하는데 계속 이 풀이 방식을 고집하다가 결국에는 틀리게 되었습니다.<br><br>
다음부터 경우의 수를 구할 때는 반드시 **곱의 누적**으로 구하도록 해야겠습니다.<br><br>
예를 들어 A가 2개 있고, B가 3개가 있으면 모든 옷을 입는 경우의 수는<br><br>
(A의 개수(2) + 1(옷을 입지 않는 경우)) X (B의 개수(3) + 1(옷을 입지 않는 경우)) = 12입니다.<br><br>
여기서 옷을 하나도 입지 않은 경우 1만 빼주면 간단하게 경우의 수를 구할 수 있습니다.
