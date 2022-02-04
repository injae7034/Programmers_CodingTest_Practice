# 다른 사람 풀이

```java
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        while(i < completion.length)
        {
            if(participant[i].equals(completion[i]) == false)
            {
                break;
            }
            i++;
        }
        return participant[i];
    }
}
```

# 다른 사람 풀이 해석하며 공부하기

이 문제는 그냥 푼다고 해결되는 것이 아니라 얼마나 효율성(얼마나 시간을 빠르게)있게<br><br>
문제를 해결하느냐도 중요합니다.<br><br>
저자는 해쉬맵을 이용하여 문제를 해결할 것을 원하지만<br><br>
해쉬맵을 사용하지 않고, 리스트를 이용하여서도 원하는 속도로 문제를 풀 수 있습니다.<br><br>
기존에 제가 풀었던 방식 역시 ArrayList를 사용하여 문제를 풀었지만,<br><br>
정렬을 사용하지 않았기 때문에 속도가 매우 느려서 통과하지 못했습니다.<br><br>
participant와 completion은 길이 1 차이가 나고,<br><br>
participant가 딱 1개의 배열요소가 더 많은 것 빼고는 똑같습니다.<br><br>
그런데 예전 풀이에서는 정렬을 하지 않았기 때문에 매번 participant에서 원소 하나를 구하고,<br><br>
그 원소를 completion의 처음부터 마지막까지 원소를 하나씩 꺼내면서 찾기 때문에 매우 느렸습니다.<br><br>
그러나 두 문자열 배열은 원소 1개 빼고는 똑같기 때문에<br><br>
정렬을 한 다음에 비교를 하면 굉장히 빠른 속도로<br><br>
completion에 없는 participant 원소(완주하지 못한 선수)를 찾을 수 있습니다.<br><br>
코드를 차례로 설명해보면 우선 매개변수로 입력 받은 participant와 completion을<br><br>
Arrays.sort를 이용해 정렬시킵니다.<br><br>
그리고 i = 0부터 시작해서 completion의 length만큼 반복을 합니다.<br><br>
반복문 내에서 participant의 i번째 원소와 completion의 i번째 원소끼리 equals로 비교합니다.<br><br>
두 배열은 1개 원소만 participant가 모두 같고 정렬을 했기 때문에<br><br>
두 배열의 원소를 차례로 처음부터 마지막까지 차례로 비교하면 같을 수 밖에 없습니다.<br><br>
다른 경우가 생긴다면 그게 바로 participant에만 있고, complement에는 없는<br><br>
완주하지 못한 선수입니다.<br><br>
그래서 그 완주하지 못한 선수를 찾았다면 더이상 반복을 할 필요가 없기 때문에<br><br>
break를 통해 반복문을 벗어나고, 해당 완주하지 못한 선수를 반환합니다.<br><br>
만약에 completion 반복이 끝나는동안 반복문 내에서 같지 않은 선수, 완주 못한 선수를<br><br>
발견하지 못했다면 정렬된 participant의 마지막에 위치한 선수가 바로 완주하지 못한 선수이기 때문에<br><br>
i = completion.lenght에 반복을 벗어난 첨자 위치에 있는 participant[i] 선수가 바로 완주하지 못한 선수이기 때문에<br><br>
그대로 participant[i]를 출력하면 됩니다.<br><br>
다만 반복이 끝나더라도 i에 저장된 숫자를 기억해야 하기 때문에 for대신에 while을 사용하여서<br><br>
초기값 i = 0을 반복문 시작하기 전에 선언 및 정의를 하여<br><br>
반복문이 끝나더라도 i에 저장된 숫자를 알 수 있도록 정하였습니다.

# 깨달은 점

ArrayList를 활용할 때 왜 sorting을 생각하지 못했을까?<br><br>
다음에는 ArrayList를 사용할 때 sorting도 이용할 수 있다는 것을 항상 염두하자.
