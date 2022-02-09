# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
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
    public List<Integer> arrangeByValue(Map<Integer, Double> map)
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
}
```

# 내가 푼 코드 설명하기

answer 정수 배열을 매개변수로 입력 받은 정수 N 크기만큼 힙에 할당합니다.<br><br>
매개변수로 입력 받은 정수배열인 stages를 오름차순으로 Arrays의 정적메소드인 sort(stages)를 호출합니다.<br><br>
List의 객체 stageList를 ArrayList의 생성자로 생성합니다.<br><br>
stages배열의 원소들을 처음부터 마지막까지 반복하면서 stageList에 add해줍니다.<br><br>
stageList에서 각 단계에 머물러 있는 플레이어의 수를 세어 저장할 Map객체인<br><br>
countMap을 HashMap의 생성자로 생성합니다.<br><br>
Key값은 stageList의 배열요소인 stage이고, Value값은 각 stage에 머물러 있는 플레이어 수,<br><br>
즉, stageList에서 같은 stage의 개수입니다.<br><br>
또한 각 stage마다 실패율을 저장할 Map의 객체인 failureMap을 HashMap의 생성자로 생성합니다.<br><br>
countMap을 초기화하기 위해서 stageList의 size만큼(stageList의 첫 원소부터 마지막 원소까지) 반복을 돌립니다.<br><br>
stageList의 원소가 countMap의 key값이고, stageList에서 해당 원소와 같은 값을 가진 원소 개수가 Value입니다.<br><br>
이를 구현하기 위해 Map의 put메소드에 key 매개변수로는 stageList.get(i)를 통해 stageList의 원소를 전달합니다.<br><br>
put메소드의 value 매개변수로는 Map의 getOrDefault메소드에 stageList.get(i)와 0을 매개변수로 전달하고,<br><br>
그 반환값에 +1 더한 값으로 정합니다.<br><br>
getOrDefault는 매개변수로 전달받은 key값인 stageList.get(i)가 Map에 존재하면 그 value값을 반환하고,<br><br>
아직 해당 key값이 Map에 없으면 0을 반환합니다.<br><br>
거기에 개수 값을 누적시키기 위해 +1을 해줍니다.<br><br>
이 반복이 끝나고 나면 countMap에는 stageList의 각 stage와 그 개수들이 저장되어 있을 것입니다.<br><br>
그러나 이렇게 하면 나중에 문제가 발생하는데, 예를 들어 문제에서 제시한 예시처럼<br><br>
stageList에 4만 저장되어 있는 경우 4의 실패율은 100퍼센트로 반영이 되지만<br><br>
그 이전 단계인 1, 2, 3 stage는 전혀 반영되지 않아서 나중에 오답이 발생합니다.<br><br>
1, 2, 3 stage의 경우 실패율이 모두 0퍼센트이기 때문에<br><br>
같은 퍼센트이면 오름차순으로 정렬해야 해서 정답은 {4, 1, 2, 3}으로 출력되도록 만들어야 합니다.<br><br>
그러기 위해서 1, 2, 3이 stageList에는 없지만  countMap에 저장되어 있어야<br><br>
나중에 실패율을 계산할 수 있기 때문에 1, 2, 3 stage는 개수를 0으로 해서 countMap에 저장해야 합니다.<br><br>
이를 위해 i = 1부터 마지막 stage인 N까지 반복을 하면서<br><br>
countMap에 해당 stage(key)가 저장되어 있는지 containsKey 메소드를 호출하여 확인합니다.<br><br>
만약에 countMap에 해당하는 stage(key)가 있으면 그냥 넘어가고,<br><br>
없다면 countMap에 해당 stage를 Key값으로 하고, value는 0으로 하여 put해줍니다.<br><br>
이제 실패율을 계산할 차례입니다.<br><br>
countMap의 entrySet메소드를 호출하면 Set\<Map.Entry\<Integer, Integer\>\>가 반환되는데<br><br>
이를 for each반복을 돌려서 set의 원소인 Map.Entry를 하나씩 구합니다.<br><br>
index는 현재 stage를 나타내는데 for each 반복 전에 index의 값은 1로 초기화한 다음에<br><br>
for each 반복문 마지막에 그 값을 +1하여 다음 stage로 넘어가는 것(set에서 다음 원소(Map.Entry)를 구하는 것)을 반영합니다.<br><br>
index값(stage)이 N보다 작거나 같은 경우에는<br><br>
각 단계의 실패율을 저장하는 failureMap의 key값에는 현재 원소(Map.Entry)의 key값을 넣어주고,<br><br>
value값에는 문제에서 정한 실패율(현재 원소(Map.Entry)의 value값에 stageList의 size를 나눈 값)을 넣어줍니다.<br><br>
이 때 실패율은 실수이기 때문에 double로 형변환을 하여 나눠줍니다.<br><br>
index값이 N + 1인 경우는 그냥 넘어갑니다.<br><br>
N + 1의 의미는 마지막 stage인 N을 통과했다는 의미이고,<br><br>
index = N일 때 N + 1을 반영하여 실패율을 구했기 때문에 그냥 넘어가면 됩니다.<br><br>
다음으로 실패율을 구할 때 첫stage부터 구하는데, 실패율을 구한 stage는 없애고, 남은 stage들 내에서 다음 실패율을 구해야 합니다.<br><br>
이를 반영하기 위해 j = 0부터 해당 stage의 value(개수)값보다 작은동안 반복을 하면서<br><br>
stageList에서 해당 stage들을 모두 remove합니다.<br><br>
이렇게 되면 stageList에서 해당 stage들이 사라져 size도 그만큼 감소하기 때문에<br><br>
남은 stage에서 실패율을 구할 때 이를 반영할 수 있습니다.<br><br>
이렇게 반복을 돌리고 나면 failureMap에는 각 stage(key)마다 실패율(value)이 저장되어 있을 것입니다.<br><br>
이제 이 stage(key)들을 실패율(value)를 기준으로 내림차순으로 정렬하여야 합니다.<br><br>
단, 실패율이 같을 경우에는 stage(key)를 기준으로 오름차순으로 정렬합니다.<br><br>
이를 구현하기 위해 arrangeByValue메소드를 정의합니다.<br><br>
매개변수의 자료형은 Map\<Integer, Double\>이고, 반환형은 List\<Integer\>입니다.<br><br>
먼저 List\<Map.Entry\<Integer, Double\>\> entryList를 new ArrayList\<\>(map.entrySet())을 통해 생성합니다.<br><br>
map.entrySet()을 ArrayList의 생성자에 매개변수로 넣는 이유는 failureMap의 entrySet의 정보를 그대로 반영하여 entryList를 생성하기 위함입니다.<br><br>
만약 ArrayList의 생성자에 매개변수가 없다면 entryList는 초기화되지 않은 채로 각 원소들이 모두 null값으로 있을 것입니다.<br><br>
그러면 별도로 failureMap의 entrySet의 정보를 반영하여 초기화해줘야하지만, 생성할 때 매개변수로 map.entrySet()을 넣으면<br><br>
생성하면서 동시에 초기화하기 때문에 별도의 초기화과정이 필요없습니다.<br><br>
이제 이 entryList를 위에서 언급한 기준대로 정렬하기 위해 Collections.sort를 호출하여 매개변수로 entryList와 Comparator를 전달합니다.<br><br>
Comparator는 익명클래스로 정의하는데, 자료형은 \<Map.Entry\<Integer, Double\>\>입니다.<br><br>
내부에서 int compare(Map.Entry\<Integer, Double\> one, Map.Entry\<Integer, Double\> other)를 원하는 기준대로 오버라이딩합니다.<br><br>
one과 other의 value(실패율)를 비교하여 one의 value가 더크면 -1을 반환합니다.<br><br>
오름차순이라면 1을 반환해야하지만 우리는 내림차순으로 해야하기 때문에 그 반대인 -1을 반환합니다.<br><br>
one과 other의 value가 같으면<br><br>
one의 key(stage)와 other의 stage(key)를 비교하여 one의 key가 더 크면 1을, other의 키가 더크면 -1을 반환합니다.<br><br>
여기서 들어오는 key값은 중복이 있을 수 없기 때문에 one의 key값과 other의 key값이 같은 경우는 없습니다.<br><br>
key값 비교는 오름차순으로 하기 때문에 내림차순으로 비교하는 value와는 반대인 값을 반환합니다.<br><br>
one의 value값이 other의 value값보다 작은 경우 1을 반환합니다.<br><br>
이렇게 Comparator익명클래스를 정의하고, sort의 매개변수로 넣어주면<br><br>
entryList는 문제에서 제시한 기준대로 정렬되어 있을 것입니다.<br><br>
이제 출력을 하기 위해 다시 List의 객체인 list를 ArrayList의 생성자로 생성해줍니다.<br><br>
list의 초기화를 위해 entryList의 각 원소를 처음부터 마지막까지 반복을 돌리면서<br><br>
list에 add해주고, 초기화과정이 끝나면 list를 반환합니다.<br><br>
다시 soultion 메소드로 돌아가서 list의 size만큼 반복을 돌리면서<br><br>
list의 원소를 answer의 배열요소에 차례대로 저장합니다.<br><br>
이 반복이 끝나면 answer에는 stage들이 문제에서 제시한 기준대로 정렬되어 있습니다.
