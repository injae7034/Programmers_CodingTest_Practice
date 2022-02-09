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
저는 Map\<Integer, Integer\>의 객체인 countMap을 생성하여 stages의 간 단계의 개수를 세었는데,<br><br> 
이 문제에서는 굉장히 비효율적인 방법입니다.<br><br>
왜냐하면 문제에서는 stages에 없더라도 그 개수를 0으로 설정해놔야 하기 때문입니다.<br><br>
예를 들어, stages가 문제에서 주어진 예시처럼 {4, 4, 4, 4, 4}인 경우<br><br>
Map을 이용하여 그 개수를 put하면 key값 4에 5가 저장되지만,<br><br>
4의 이전 단계인 1, 2, 3은 아예 저장이 되지 않습니다.<br><br>
그래서 Map에서는 stages에 있는 배열요소를 넣는 반복이 끝나고 나면<br><br>
다시 1부터 N까지 반복하면서 stages에 없었던 단계를 key값으로 하고, value 값을 0으로 하여 put해줘야 합니다.<br><br>
즉, 쓸데없이 반복을 2번하게 되면서 시간이 낭비되고 코드가 길어집니다.<br><br>
하지만 배열을 이용하면 반복을 한 번만 하면 됩니다.<br><br>
대신 배열을 생성할 때 크기를 N + 2로 해야 합니다.<br><br>
왜냐하면 stages에 있는 단계들(배열요소)은 1부터 시작하고, 최대 N + 1까지 올 수 있고,<br><br>
배열의 첨자는 0부터 시작하여 N + 1까지를 담아야 하기 때문에 그 크기가 N + 2가 되어야 합니다.<br><br>
0번째 첨자는 사실상 쓸 일이 없는 첨자이고, N + 1첨자는 N단계를 통과한 플레이어를 의미합니다.<br><br>
이렇게 N + 2 크기로 배열을 생성하면 초기값은 모두 0으로 설정되어 있습니다.<br><br>
이제 여기서 stages에 있는 원소들을 배열첨자로 입력하여 그 배열요소의 값을 +1시켜주면서 누적시켜주면<br><br>
반복구조를 1번만해도 배열에는 stages에 있는 각 단계들(배열첨자)의 개수가 누적되어 저장되어 있고,<br><br>
stages에 없는 단계들(배열첨자)은 초기화 때 저장된 값인 0이 그대로 저장되어 있을 것입니다.<br><br>
그리고 실패율을 계산할 때 HashMap을 사용하여 각 단계들을 key값, 실패율을 value값으로 해도 되지만<br><br>
Stage라는 클래스를 생성하여 key와 value값을 멤버로 하는 방법도 있습니다.<br><br>
거기서 미리 Comparable\<Stage\>의 compareTo를 문제에서 원하는 기준에 맞게 오버라이딩합니다.<br><br>
그리고 정렬할 때 Collectons.sort를 이용하면 간단하게 정렬할 수 있습니다.<br><br>
무엇보다 solution의 코드 길이가 줄어들고, 각 기능을 구분하여 메소드를 만들기 때문에 가독성이 좋습니다.<br><br>
다음에 문제를 풀 때 무조건 HashMap만 고려하지 말고,<br><br>
이 문제의 경우처럼 HashMap을 생성할 때 \<Integer, Integer\>인 경우에는 배열을 사용하는 것이 더 나은지 아닌지를<br><br>
꼭 먼저 판단하고, 다른 자료형의 HashMap의 경우에는 클래스를 만들어서 대체할 수 없는지를 고려해보록 해야겠습니다.
