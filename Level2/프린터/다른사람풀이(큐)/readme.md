# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++)
        {
            list.add(priorities[i]);
        }
        int temp;
        int i = 0;
        int answer = 0;
        while(i < list.size())
        {
            temp = list.get(0);
            int j = 1;
            while(j < list.size())
            {
                if(temp < list.get(j))
                {
                    list.remove(0);
                    list.add(temp);
                    if(location > 0)
                    {
                        location--;
                    }
                    else
                    {
                        location = list.size() - 1;
                    }
                    temp = list.get(0);
                    j = 1;
                }
                else
                {
                    j++;
                }
            }
            answer++;
            list.remove(0);
            if(location == 0)
            {
                break;
            }
            else
            {
                location--;
            }
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

List의 객체를 생성하여 매개변수로 입력 받은 priorites 배열요소들을 add시킵니다.<br><br>
i = 0부터 list의 size보다 작은 동안 반복을 합니다.<br><br>
첫번째 원소 값을 구해서 temp에 저장하고 다시 j = 1부터 list의 size보다 작은 동안 반복합니다.<br><br>
반복문 내부에서 temp가 list의 j번째 원소보다 작으면<br><br>
list의 0번째 원소를 제거하고, temp를 add시켜줍니다.<br><br>
location이 0보다 크면 location의 위치를 -1 감소시켜주고<br><br>
location이 0이면 location의 위치를 list의 size에서 1 감소한 값을 대입해줍니다.<br><br>
temp에는 다시 list의 첫번째 원소를 저장시키고<br><br>
j = 1로 초기화시킵니다.<br><br>
temp가 list의 j번째 원소보다 크면 j의 값을 +1시켜 줍니다.<br><br>
첫번째 반복문에서 나오면 가장 우선순위가 높은 원소를 실행시켜주는 의미로<br><br>
answer를 +1시켜주고<br><br>
list에서 첫번째 원소가 현재 가장 우선순위가 높은 원소이기 떄문에 실행했다는 의미로 remove시켜줍니다.<br><br>
이 때 location의 위치가 0 이면 반복문을 빠져나가고<br><br>
location이 0이 아니면 1감소시킵니다.<br><br>
location이 0이 되거나 i가 list의 size와 같아지는 경우 반복문을 벗어나고<br><br>
이 때 누적된 answer를 반환합니다.

# 아쉬운 점
location의 값이 계속 변동되어서 이에 대한 처리를 어떻게 해야 할지 잘몰라서 많이 헤맸습니다.<br><br>
헤메다가 결국에 location의 위치를 감소시키고 0이 될 때가 프린터에서 출력되는 순서라는 것을 나중에 알게 되어 시간이 많이 걸렸습니다.<br><br>
그리고 첫번째 원소를 미리 꺼내지 않고 get하여 비교한 다음에 꺼낼지 말지 결정하다보니 코드 중복이 심해졌습니다.<br><br>
어차피 최대값이라면 실행을 해야 해서 remove해야하고 최대값이 아니면 뒤로 가야해서 remove해야했기 때문에 무조건 remove를 하면 됬는데<br><br>
그렇게 하지 않고 빼기 전에 get으로 값을 구한 다음 뺄지 말지 여부를 정하느라 코드 중복이 심해지고 코드가 길어졌습니다.
