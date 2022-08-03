# 프로그래머스 연습문제 스택/큐에서 나온 level2 문제입니다.
## 이 문제는 혼자 풀지 못해서 다른 사람의 풀이를 참고하여 작성하였습니다.
### 문제의 링크는 아래에 있습니다.
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/42583" target="_blank">프로그래머스 - 다리를 지나는 트럭</a>

```java
public class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucksOnBridge = new LinkedList<>();
        int time = 0;
        long totalWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            while (true) {
                if (trucksOnBridge.size() < bridge_length) {
                    totalWeight = 0;
                    for (int truck_weight : trucksOnBridge) {
                        totalWeight += truck_weight;
                    }

                    if (weight - totalWeight >= truck_weights[i]) {
                        if(trucksOnBridge.size() > 0 && trucksOnBridge.peek() == 0) {
                            trucksOnBridge.poll();
                        }
                        trucksOnBridge.offer(truck_weights[i]);
                        time++;
                        break;
                    } else {
                        trucksOnBridge.offer(0);
                        time++;
                    }
                } else if (trucksOnBridge.size() == bridge_length) {
                    trucksOnBridge.poll();
                }
            }

        }

        return time + bridge_length;
    }
    
}
```
