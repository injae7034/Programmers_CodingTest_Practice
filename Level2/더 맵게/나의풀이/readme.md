# 내가 푼 코드

```java
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
        {
            priorityQueue.offer(scoville[i]);
        }
        Integer first;
        Integer second;
        int answer = 0;
        while(priorityQueue.peek() < K && priorityQueue.size() > 1)
        {
            first = priorityQueue.poll();
            second = priorityQueue.poll();
            first += second * 2;
            priorityQueue.offer(first);
            answer++;
        }
        if(priorityQueue.size() == 1 && priorityQueue.peek() < K)
        {
            return -1;
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

우선 PriorityQueue를 생성하는데 원소를 추가할 때 알아서 대소비교를 하여<br><br>
오름차순으로 정렬시켜줍니다.<br><br>
scoville의 원소를 모두 PriorityQueue에 옮기면 알아서 대소비교를 하여 오름차순으로 정렬해서 저장합니다.<br><br>
PriorityQueue의 peek메소드를 호출하면 가장 상위, 즉, 가장 작은 값의 원소를 리턴하는데<br><br>
그 값이 K보다 작은동안 반복을 하고<br><br>
그리고 PriorityQueue의 size가 1보다 큰 동안 반복합니다.<br><br>
그 이유는 1개일 경우 2개를 섞을 수 없기 때문에 최소 2개가 있어야 2개를 뽑아서 섞어서 1개를 만들수 있습니다.<br><br>
반복문 내에서 가장 상위, 가장 작은 원소를 poll하여 first에 저장하고<br><br>
다시 poll하면 두번째로 작은 원소를 second에 저장합니다.<br><br>
first에 자기자신과 second를 두배 해준 값을 더해 저장하고 이를 PriorityQueue에 offer해줍니다.<br><br>
그러면 2개를 뽑아서 새로운 first를 만들고 이를 다시 넣어줬기 때문에 PriorityQueue의 size는 1감소됩니다.<br><br>
시행 횟수인 answer를 증가시켜줍니다.<br><br>
이런식으로 반복하다가 만약에 가장 작은 원소가 K와 같거나 더 커지는 경우 반복문을 벗어나 누적된 시행횟수 answer를 반환하고<br><br>
만약 PriorityQueue의 size가 1이 되어 반복문을 벗어난 경우 가장 장은 원소이자 1개의 원소가 K보다 작으면 -1을 리턴하고<br><br>
아니면 누적된 시행횟수 answer를 반환합니다.
