# 다른 사람이 푼 코드

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution
{
    public int[] solution(int N, int[] stages)
    {
        int playerCount = stages.length;
        int[] stagePlayers = new int[N + 2];
        for(int stage : stages)
        {
            stagePlayers[stage] += 1;
        }
        int remainingPlayerCount = playerCount;
        List<Stage> stageList = new ArrayList<>();
        double failure = 0.0;
        for(int level = 1; level <= N; level++)
        {
            failure = (double) stagePlayers[level] / remainingPlayerCount;
            remainingPlayerCount -= stagePlayers[level];

            Stage s = new Stage(level, failure);
            stageList.add(s);
        }
        Collections.sort(stageList, Collections.reverseOrder());
        int[] answer = new int[N];
        for(int i = 0; i < N; i++)
        {
            answer[i] = stageList.get(i).level;
        }
        return answer;
    }
    class Stage implements Comparable<Stage>
    {
        public int level;
        public double failure;

        public Stage(int level, double failure)
        {
            this.level = level;
            this.failure = failure;
        }

        @Override
        public int compareTo(Stage one)
        {
            if(this.failure < one.failure)
            {
                return  -1;
            }
            else if(this.failure > one.failure)
            {
                return 1;
            }
            return 0;
        }
    }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

정수자료형 변수인 playerCount에 매개변수로 입력 받은 stages의 개수(플레이어의 수)를 저장합니다.<br><br>
정수형배열인 stagePlayers를 N + 2 크기만큼 힙에 할당합니다.<br><br>
크기를 N + 2만큼 하는 이유는 문제에서 stages에는 1 이상 N + 1 이하의 자연수가 배열요소로 담겨 있다고 제시했기 때문입니다.<br><br>
스테이지의 개수 N은 1 이상 500 이하의 자연수인데, 즉, stages에는 1이상 501이하의 자연수가 담길 수 있습니다.<br><br>
우리가 만든 배열인 stagePlayers는 스테이지를 배열첨자로 활용할 것이기 때문에<br><br>
배열첨자가 최대 501까지 들어올 수 있습니다.<br><br>
배열첨자는 0부터 최대 501까지 들어오려면 배열의 길이는 502가 되어야 하기 때문에<br><br>
stagePlayer의 크기를 N + 2만큼 힙에 할당해야 합니다.<br><br>
for each 반복을 하여 stages에서 첫원소부터 마지막 원소까지 하나씩 구합니다.<br><br>
원소를 배열첨자로 하여 stagePlayers의 배열요소에 값을 +1 해줍니다.<br><br>
반복이 끝나고 나면 stagePlayers에는 stages에 있는 각각의 배열요소들의 개수가 저장됩니다.<br><br>
예를 들어 stages에 2가 3개 3이 4개 저장되어 있었다면<br><br>
stagePlayers의 배열첨자 2에는 3의 값이, 배열첨자 3에는 4의값이 저장되고,<br><br>
배열첨자 stages에 없는 0, 1과 나머지는 모드 배열을 생성할 때 초기값인 0이 저장되어 있습니다.<br><br>
남아있는 플레이어의 수를 저장할 정수형 변수 remainingPlayerCount에 playerCount를 초기값을 저장합니다.<br><br>
그리고 자료형이 Stage클래스인 List객체 stageList를 ArrayList의 생성자를 이용하여 생성합니다.<br><br>
Stage클래스는 Comparable\<Stage\>를 구현하여 정렬기준으로 삼습니다.<br><br>
멤버로는 state단계를 저장하는 정수자료형 level, 각 level마다 실패율을 저장하는 실수자료형 failure이 있습니다.<br><br>
매개변수를 2개 가지는 생성자를 통해 객체 생성시 초기값을 입력 받아 멤버를 초기화합니다.<br><br>
다음으로 compareTo메소드를 오버라이딩하는데 매개변수로 입력 받은 Stage의 객체인 one과 비교하여,<br><br>
this의 failure이 one의 failure보다 작으면 -1을, 그 반대면 1을 반환합니다.<br><br>
this의 failure이 one의 failure이 같으면 0을 반환합니다.<br><br>
다시 solution메소드로 돌아와서 level = 1부터 N보다 작거나 같은 동안 반복을 합니다.<br><br>
각 level마다 stagePlayer의 수를 남아있는 플레이어의 수를 저장한 remainingPlayerCount로 나눠주면 이 값이 실패율입니다.<br><br>
실패율을 구한 다음 remainingPlayerCount에서 각 level마다 stagePlayer의 수를 빼줍니다.<br><br>
현재 level과 실패율을 매개변수로 하여 Stage클래스의 객체를 생성하고, 이를 stageList에 add해줍니다.<br><br>
마지막 level N의 실패율을 계산할 때 stagePlayers에 N+1 배열첨자의 값이 0이 아니면,<br><br>
N + 1은 마지막 level인 N을 통과했다는 의미인데<br><br>
stagePlayer에 N + 1의 값이 0이면 마지막 level인 N을 통과한 사람이 없다는 뜻이고,<br><br>
N + 1의 값이 0이 아니면 N을 통과한 사람이 있다는 뜻입니다.<br><br>
그래서 N + 1은 실패한 것 없이 다 통과했기 때문에 N + 1에 대해서는 실패율을 구할 필요가 없고,<br><br>
다만 N + 1을 통과한 사람의 수는 level N의 실패율을 구할 때 남아있는 유저수에서 반영이 됩니다.<br><br>
즉, N의 실패율을 구하는 방법은 현재 level N에 머물러 있는 플레이어의 수를<br><br>
(현재 level N에 머물러 있는 플레이어의 수 + level N을 통과한 플레이어의 수)로 나눠줍니다.<br><br>
이렇게 마지막 level N의 실패율까지 구하여 Stage객체를 만든 다음 stageList에 add해줍니다.<br><br>
다음으로 정렬을 해줄 차례인데, 이 때 Collections클래스의 정적메소드인 sort를 호출합니다.<br><br>
Stage클래스에는 이미 compareTo를 통해 정렬기준을 제시하였는데, 현재 정렬 기준이 오름차순 기준입니다.<br><br>
그러나 문제에서는 내림차순으로 정렬하라고 지시하고 있기 때문에<br><br>
Collections.reverseOrder()를 매개변수로 입력하여 현재 오름차순을 내림차순으로 변경하여 정렬합니다.<br><br>
Collections.reverseOrder() 매개변수로 입력하지 않고도 내림차순으로 변경하려면<br><br>
compareTo에서 반환값을 변경하여야 합니다.<br><br>
현재 compareTo에서는 this의 failure가 one의 failure보다 작은 경우에는 -1을, 큰 경우에는 1을 반환합니다.<br><br>
이 값을 바꾸어 this의 failure가 one의 failure보다 작은 경우에는 1을, 큰 경우에는 -1을 반환합니다.<br><br>
즉, 현재 반환하고 있는 값을 서로 바꿔주면 Collections.reverseOrder()없이도 내림차순으로 변경됩니다.<br><br>
그리고 실패율이 같은 경우에는 0을 반환하는데, 실패율이 같은 경우에는 level에 따라 오름차순으로 정렬하고 있기 때문에<br><br>
별도의 처리과정없이 0을 반환하면 됩니다.<br><br>
만약에 level을 내림차순으로 정렬하고 싶다면 
```java
@Override
        public int compareTo(Stage one)
        {
            int ret = 0;
            if(this.failure < one.failure)
            {
                ret = 1;
            }
            else if(this.failure > one.failure)
            {
                ret = -1;
            }
            else
            {
                if(this.level < one.level)
                {
                    ret = 1;
                }
                else if(this.level > one.level)
                {
                    ret = -1;
                }
            }
            return ret;
        }
```
위 코드와 같이 같은 경우를 처리해줘야 합니다.<br><br>
즉, sort의 default기준이 오름차순이기 때문에 failure값이 같은 경우<br><br>
return 0을 하면 자동으로 level을 기준으로 오름차순이 되지만<br><br>
level역시 내림차순으로 정렬하고 싶다면 위에서 제시한 방법대로<br><br>
별도로 코드를 작성해줘야 합니다.<br><br>
정렬이 끝났으면 정수형 배열인 answer를 크기 N만큼 힙에 할당합니다.<br><br>
i = 0부터 N보다 작은동안 반복을 하면서 정렬된 stageList의 원소를 하나씩 구하여<br><br>
answer의 배열요소에 하나씩 차례대로 저장한 뒤에 이를 반환합니다.

# 느낀 점
