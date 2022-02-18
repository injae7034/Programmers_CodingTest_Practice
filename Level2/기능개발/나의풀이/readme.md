# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progressesList = new ArrayList<>();
        List<Integer> speedsList = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++)
        {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }
        int count;
        List<Integer> countList = new ArrayList<>();
        while(progressesList.size() > 0)
        {
            count = 0;
            for(int i = 0; i < progressesList.size(); i++)
            {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
            while(progressesList.size() > 0 && progressesList.get(0) >= 100)
            {
                count++;
                progressesList.remove(0);
                speedsList.remove(0);
            }
            if(count > 0)
            {
                countList.add(count);
            }
        }
        int[] answer = new int[countList.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = countList.get(i);
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

List의 객체 progressesList와 speedsList들 ArrayList의 생성자로 생성하여<br><br>
매개변수로 입력 받은 정수형 배열 progresses와 speeds의 원소들을 옮겨줍니다.<br><br>
그리고 한번에 배포되는 기능 개수를 저장할 countList를 ArrayList의 생성자로 생성해줍니다.<br><br>
progressesList의 size가 0보다 큰 동안 반복합니다.<br><br>
즉, progressesList에서 100이 된 원소(기능)들은 배포할텐데(꺼낼텐데)<br><br>
progressesList의 모든 원소(기능)들이 배포가 다 될때까지(다 꺼낼때까지) 반복합니다.<br><br>
count를 0으로 초기화해줍니다.<br><br>
progressesList의 모든 원소에 speedsList의 원소들을 더해줍니다.<br><br>
progressesList의 크기가 0보다 크고 첫번째 원소가 100보다 크거나 같은동안 반복을 합니다<br><br>
즉, progressesList에 배포할 기능이 있고, 그 기능이 완성되어있는 동안 반복합니다.<br><br>
배포할 기능이 더이상 없으면 반복문에 들어가지 않고,<br><br>
배포할 기능이 있고, 현재 제일 첫번째 기능이 완성이 되었으면 반복문에 들어갑니다.<br><br>
반복문 내부에서 count를 증가시켜주고, progressesList와 speedsList에서 첫번째 원소(기능)을 remove해줍니다.<br><br>
다시 반복문 조건으로 가서 조건이 성립하면 계속 반복을 하고 성립하지 않으면 반복문을 벗어납니다.<br><br>
반복문을 나와서 count가 0보다 크면, 즉, 배포한 기능(지운 원소)이 있으면<br><br>
배포한 기능의 개수(count)를 countList에 add해줍니다.<br><br>
이렇게 반복을 하면 배포가 다 될때까지 반복을 하고, 한 번에 배포되는 기능의 개수가 countList에 저장됩니다.<br><br>
반복문이 끝나면 countList에 있는 원소를 정수형 배열 answer에 옮겨주고 answer를 반환합니다.
