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
<br>
다리를 지나는 중의 트럭을 저장할 trucksOnBridge를 Queue로 생성합니다.  

그리고 다리를 건너야 하는 트럭의 개수만큼 반복을 돌립니다.  

반복문에서 break나오지 않는 한 계속해서 반복하는 반복문을 한 번 더 돌립니다.  

1. 다리를 건너고 있는 트럭의 개수가 다리를 건널 수 있는 트럭의 수인 bridge_length만큼 작은지 확인하여 작다면  

    1.1 다리가 지탱할 수 있는 무게인 weight에 다리 위에 있는 트럭들의 무게인 totalWeight를 구하여 빼줍니다.  

    1.2 이 값이 현재 다리를 건너기 위해 기다리고 있는 truck_weights의 i번째 트럭의 무게보다 크거나 같으면  

        1.2.1 다리를 건너고 있는 트럭을 의미하는 trucksOnBridge에 truck_weights의 i번째 트럭을 추가하고, 시간을 늘려주고, true무한 반복을 벗어납니다.  

        1.2.2 이 때, trucksOnBridge의 첫번째 원소가 0인 경우에 이를 빼줍니다.  

    1.3 이 값이 현재 다리를 건너기 위해 기다리고 있는 truck_weights의 i번째 트럭의 무게보다 작으면  
        
        1.3.1 trucksOnBridge에 0을 추가하고, 시간을 늘려줍니다.(현재 trucksOnBridge에 있는 트럭이 이동하고 있다는 것을 표현하기 위해 0을 사용)

2. 다리를 건너고 있는 트럭의 개수가 다리를 건널 수 있는 트럭의 수인 bridge_length만큼 작은지 확인하여 같다면

    2.1 trucksOnBridge에서 가장 앞의 원소를 꺼냅니다.  
    
그리고 이 반복이 끝나면 마지막 원소는 아직 다리를 건너지 않았기 때문에 현재 누적된 time에 다리의 길이를 의미하는 bridge_length 값을 더하야 반환합니다.  
