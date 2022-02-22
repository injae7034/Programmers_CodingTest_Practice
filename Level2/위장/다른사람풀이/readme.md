# 다른 사람이 푼 코드

```java
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
        //1. 옷을 종류별로 구분해서 개수 저장하기
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes)
        {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        //2. 입지 않는 경우를 추가하여 모든 경우의 수 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while(it.hasNext())
        {
            answer *= it.next().intValue() + 1;
        }
        //3. 아무 옷도 입지 않은 경우를 제외하고 반환하기
        return answer - 1;
    }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

옷을 종류별로 구분해서 개수 저장하는 방법은 제가 풀이한 방식과 똑같습니다.<br><br>
경우의 수를 구하는 방식에서 차이가 납니다.<br><br>
map의 values를 호출하면 map의 value값들만 Collection\<T\>로 반환을 받는데<br><br>
여기서 T는 Integer이고 이 반환받은 Collection의 객체에서 iterator메소드를 호출하여<br><br>
Iterator\<Integer\>클래스의 객체 it를 생성합니다.<br><br>
it의 hasNext를 호출하면 다음이 있으면 true, 다음이 없으면 false를 반환합니다.<br><br>
즉, 끝이 아닌동안 반복하는 것입니다.<br><br>
반복문 내부에서 it의 next메소드를 호출하면 다음 원소를 구할 수 있습니다.<br><br>
최초에 it는 처음원소보다 앞에 위치하고 있어서 처음 it의 next를 호출하면 it의 첫번째 원소가 반환되고<br><br>
그 원소의 자료형이 현재 Integer이기 때문에 곱셈 연산을 하기 위해 이를 intValue메소드를 이용하여 int형으로 바꿔준 다음<br><br>
1을 더해주고 그 값을 answer에 누적하여 곱해줍니다.<br><br>
반복문이 끝나면 clothes의 옷을 입는 전체 경우의 수를 구하게 되고<br><br>
이 때 옷을 최소 1개는 입어야하기 때문에 옷을 아무것도 입지 않은 경우의 수 1을 빼준 다음 반환합니다.

# 느낀 점

경우의 수를 구할 때 위처럼 모든 경우의 수를 곱셉으로 누적시켜 한 번에 구한 다음에<br><br>
예외의 경우의 수를 마지막에 빼주는 것이 훨씬 더 쉽고 깔끔한 방법입니다.<br><br>
저는 처음부터 예외를 고려하여 경우의 수를 고려하다 보니 코드가 훨씬 복잡해지고<br><br>
결국에 제 자신도 헷갈리게 되어 디버깅도 제대로 안되어 부분점수만 맞고 틀리게 되었습니다.<br><br>
다음부터 이러한 경우의 수 문제를 풀 때는 먼저 전체의 경우를 곱셈의 누적을 통하여 구한 다음<br><br>
예외의 경우의 수를 빼는 방법으로 풀도록 해야겠습니다.<br><br>
또한 다음부터 경우의 수를 구할 때는 반드시 **곱의 누적**으로 구하도록 해야겠습니다.<br><br>
예를 들어 A가 2개 있고, B가 3개가 있으면 모든 옷을 입는 경우의 수는<br><br>
(A의 개수(2) + 1(옷을 입지 않는 경우)) X (B의 개수(3) + 1(옷을 입지 않는 경우)) = 12입니다.<br><br>
여기서 옷을 하나도 입지 않은 경우 1만 빼주면 간단하게 경우의 수를 구할 수 있습니다.
