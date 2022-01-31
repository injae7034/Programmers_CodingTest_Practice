# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> completionList = new ArrayList<>();
        for(String player : completion)
        {
            completionList.add(player);
        }
        boolean doesComplete = false;
        for(String player : participant)
        {
            doesComplete = false;
            for(String completePlayer : completionList)
            {
                if(player.compareTo(completePlayer) == 0)
                {
                    doesComplete = true;
                    completionList.remove(completePlayer);
                    break;
                }
            }
            if(doesComplete == false)
            {
                answer = player;
                break;
            }
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

ArrayList를 생성해서 매개변수로 입력된 completion 문자열 배열의 배열요소들을<br><br>
for 반복문을 통해 처음부터 마지막까지 add합니다.<br><br>
그리고 매개변수로 입력 받은 participant 문자열 배열의 처음부터 마지막까지 반복합니다.<br><br>
반복문 내부에서 flag로 이용할 boolean 변수인 doesComplete을 false로 초기화해줍니다.<br><br>
그런 다음 아까 생성한 ArrayList의 처음부터 마지막까지 반복을 합니다.<br><br>
participant에서 구한 배열요소인 문자열 player와<br><br>
ArrayList에서 구한 배열요소인 문자열 completionList를 비교하여<br><br>
그 문자열이 같으면 boolean 변수인 doesComplete을 true로 바꿔줍니다.<br><br>
그리고 매개변수로 입력 받는 문자열 배열인 participant와 completion은<br><br>
동명이인을 포함할 수도 있기 때문에 중복이 있을 수도 있습니다.<br><br>
따라서 중복을 제거하기 위해서 completion 문자열 배열을 그대로 옮긴 completionList에서<br><br>
participant와 일치하는 문자열을 remove합니다.<br><br>
예를 들어, participant에 홍길동이 2명 있고, completion에는 홍길동이 1명이 있는 경우<br><br>
한 명의 홍길동은 완주했고, 다른 한 명의 홍길동은 완주하기 못한 선수가 됩니다.<br><br>
그러나 completionList에 한 명의 홍길동이 있음으로 인해 participant의 2명의 홍길동과<br><br>
completionList에 한 명의 홍길동이 혼자서 2번 비교를 하면서<br><br>
participant에 있는 2명의 홍길동이 모두 완주한 것으로 간주됩니다.<br><br>
이러한 문제를 방지하기 위해 participant에서 첫번째 홍길동과 completionList에서 홍길동을 비교해서<br><br>
같은 홍길동을 찾았으면 completionList에서 홍길동을 remove함으로써 나중에<br><br>
participant에서 2번째 홍길동이 나왔을 때 completionList에서는 더이상 홍길동이 없기 때문에<br><br>
성공적으로 2번째 홍길동은 완주하지 못한 선수로 분류할 수 있습니다.<br><br>
그 다음 일치하는 문자열(완주한 선수)을 찾았기 때문에 더이상 completionList의 반복을 할 필요가 없기 때문에<br><br>
break를 통해 completionList의 처음부터 마지막까지 반복구조를 벗어납니다.<br><br>
반복구조를 벗어나면 아까 초기값이 false인 doesComplete의 값을 통해 선택구조로 들어갈지 말지 결정합니다.<br><br>
같은 문자열을 찾았으면 초기값이 false에서 true로 바꼈을 것이기 때문에 선택구조로 들어가지 않고,<br><br>
같은 문자열을 찾지 못했으면 초기값이 그대로 false이기 때문에 선택구조로 들어갑니다.<br><br>
선택구조 내부에서 출력할 문자열인 answer에 player(completionList에 없는, 완주하지 못한 선수명)를 대입합니다.<br><br>
그런 다음 더이상 participant의 처음부터 마지막까지 반복을 돌 필요가 없기 때문에 break를 통해 반복을 벗어납니다.<br><br>
그런 다음 answer를 반환합니다.

# 한계점

위의 코드대로 하면 정답은 정확하게 나오지만 효율성(시간)에서 0점이 나와서 통과할 수 없습니다.<br><br>
이 문제는 정확하기 푸는 것도 중요하지만 속도도 중요하다고 할 수 있습니다.<br><br>
그래서 속도를 향상시키는 방법을 생각해봤습니다.<br><br>

# 효율성을 올리기 위한 시도(착각?;;)

위의 코드에서 participant와 completion에는 중복이 있을 수 있기 때문에<br><br>
participant와 completionList에서 배열요소를 비교해 같은 배열요소가 있으면<br><br>
completionList에서 해당 문자열을 remove했습니다.<br><br>
이를 차용하여 participant에서도 ArrayList(participantList)를 생성하여 participant의 문자열 배열을 옮깁니다.<br><br>
그 다음 participantList와 completionList에서 배열요소(문자열)이 일치할 때<br><br>
completionList를 지우면서 participantList도 같이 지웁니다.<br><br>
코드는 아래와 같습니다.<br>
```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> participantList = mew ArrayList<>();
        for(String player : participant)
        {
            participantList.add(player);
        }
        List<String> completionList = new ArrayList<>();
        for(String player : completion)
        {
            completionList.add(player);
        }
        boolean doesComplete = false;
        for(String player : participantList)
        {
            doesComplete = false;
            for(String completePlayer : completionList)
            {
                if(player.compareTo(completePlayer) == 0)
                {
                    doesComplete = true;
                    participantList.remove(player);
                    completionList.remove(completePlayer);
                    break;
                }
            }
            if(doesComplete == false)
            {
                answer = player;
                break;
            }
        }
        return answer;
    }
}
```
아까 전에는 pariticpant 문자열배열만큼 반복을 돌렸는데,<br><br>
이제는 ArrayList\<String\> participantList의 size만큼 반복을 돌리면서<br><br>
실시간으로 size크기를 반영하여(반복 도중에 completionList와 일치하는 문자열이 있으면<br><br>
remove하기 때문에 size가 1씩 감소됨.)<br><br>
이미 비교를 한 불필요한 배열요소는 다음에 비교하지 않도록 remove해버립니다.<br><br>
그런데 이제 와서 생각해보니 어차피 문자열배열 participant에서<br><br>
순차적으로 처음부터 마지막까지 배열요소를 하나씩 구하면<br><br>
이미 구한 배열요소를 다음에 또 구하는 중복이 없는데(굳이 remove를 하지 않더라도)<br><br>
그 때는 생각을 미처 못했습니다.<br><br>
아무튼 그 때는 paricipantList에서 반복을 돌리면서 일치하는 문자열이 생길 때마다<br><br>
일치하는 배열요소를 지워주면 효율성이 올라갈 것이라는 착각을 하여,<br><br>
위 코드처럼 participantList에서 반복을 돌리는 도중에<br><br>
participantList의 원소를 지우는 작업을 합니다.<br><br>

# concurrentModificationException 발생

그 결과는 List 순회 중에 발생하는 예외 중 하나인 concurrentModificationException이 발생합니다.<br><br>
알아 본 결과를 간략하게 요약하자면 List의 size만큼 순회를 도는 와중에 List의 size가 변경, 즉, 원소가 지워지면<br><br>
concurrentModificationException이 발생합니다.<br><br>
그렇게 하지 못하도록 자바에서 막아놨습니다.<br><br>
그러면 왜 아까 똑같은 List인 completionList에서는 순회 도중에<br><br>
remove를 해도 concurrentModificationException가 발생하지 않을까요?<br><br>
답은 바로 break에 있습니다.<br><br>
completionList에서 일치하는 문자열이 생기면 completionList의 원소를 지우고,<br><br>
그러면 completionList의 size가 변경되는데, 이 때 다시 반복 조건문으로 가서 반복을 하게 되면<br><br>
concurrentModificationException이 발생할텐데<br><br>
위 코드에서는 조건문으로 가기 전에 break를 사용해 해당 반복을 탈출해버립니다.<br><br>
그래서 concurrentModificationException이 발생하지 않습니다.<br><br>
이로써 알 수 있는 것은 List 순회 중에 해당 원소를 삭제하여 그 size가 변경되면,<br><br>
다시 반복조건문으로 돌아 갔을 때(즉, List의 원소 크기가 변경된 상태에서 반복이 계속되면)<br><br>
concurrentModificationException이 발생합니다.<br><br>
그러나 원소를 삭제 후(크기가 변경된 후) 반복조건문으로 돌아가지 않고(반복이 계속되지 않고)<br><br>
break를 통해 반복을 탈출하게 되면 concurrentModificationException이 발생하지 않습니다.<br><br>
concurrentModificationException라는 새로운 예외를 발견할 수 있어서 의미는 있었지만<br><br>
어짜되었든 이 방식은 일단 불가능한 방법이라서 차치할 수 밖에 없습니다.

# Iterator 클래스 사용

굳이 이 방식(List순회 중에 원소를 지우면서 반복을 진행하는 구조)을 구현해보려면(효율성이 개선되지 않음에도 불구하고,)<br><br>
Iterator를 사용하는 방법이 있습니다.<br><br>
반복 도중에 List를 지우면서 List에 손대는 것이 아니라<br><br>
Iterator를 별도로 생성하여 Iterator의 원소를 remove하는 방법이 있습니다.<br><br>
이 방식을 사용하면 이제 이중 반복에서 첫번째 반복이 participantList의 size만큼 반복이 아니라<br><br>
별도로 생성한 Iterator가 hasNext()가 true인동안 반복하면서 일치하는 문자열이 있을 경우<br><br>
일치하는 문자열에 해당하는 Itertor의 원소를 remove하는 방법입니다.<br><br>
그러나 앞에서 언급했듯이 문자열배열에서 배열요소를 하나씩 순차적으로 구하는 과정에서<br><br>
배열첨자는 누적되어 이전에 비교한 원소를 다시 구하는 일은 없습니다.<br><br>
즉, ArrayList에서 반복을 진행하는 과정에 이미 비교한 원소를 지우는 것은<br><br>
효율성(시간)을 증가시키는 것과 아무런 상관이 없습니다.<br><br>
그러니까 굳이 Iterator를 사용하여 List순회 도중에<br><br>
자기 원소를 지우는 과정을 구현할 필요가 없습니다.<br><br>
이 방법으로는 효율성을 증가시킬 수 없기 때문에 다른 방식을 생각해봐야 합니다.

