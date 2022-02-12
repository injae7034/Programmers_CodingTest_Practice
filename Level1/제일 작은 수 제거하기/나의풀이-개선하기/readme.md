# 내가 풀이한 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            arrList.add(arr[i]);
        }
        Integer min = Collections.min(arrList);
        
        while(arrList.remove(min) == true)
        {
            
        }
        int[] answer = null;
        if(arrList.size() > 0)
        {
            answer = new int[arrList.size()];
            for(int i = 0; i < answer.length; i++)
            {
                answer[i] = arrList.get(i);
            }
        }
        else
        {
            answer = new int[]{-1};
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 정수배열 arr을 담을 ArrayList를 생성합니다.<br><br>
반복을 돌면서 arr의 배열원소를 하나씩 ArrayList의 객체에 add합니다.<br><br>
이 후 ArrayList의 객체에서 제일 작은 값을 Collections의 min을 이용해 구합니다.<br><br>
반환값이 Integer이기 때문에 Integer를 이용해 반환받습니다.<br><br>
arrList에서 이 최소값을 매개변수로 넣은 remove를 호출하여<br><br>
이 값이 false인 동안 반복을 하면서 arrangedList의 첫번째 원소값과 동일한 값을 arrList에서 제거합니다.<br><br>
제거 후에 arrList의 size가 0보다 크면<br><br>
answer배열을 arrList의 size만큼 힙에 할당하여 arrList의 원소를 answer배열에 차례차례 담습니다.<br><br>
arrList의 size가 0이면 answer는 크기 1인 배열에 -1을 원소로 담습니다.<br><br>
이 후 answer배열을 반환합니다.
