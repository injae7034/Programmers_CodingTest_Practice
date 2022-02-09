# 내가 푼 코드

```java
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for(int i = 0; i < numbers.length - 1; i++)
        {
            for(int j = i + 1; j < numbers.length; j++)
            {
                numberSet.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[numberSet.size()];
        int index = 0;
        for(int number : numberSet)
        {
            answer[index] = number;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
```

# 내가 푼 코드 설명

먼저 Set의 객체인 numberSet을 HashSet의 객체로 생성합니다.<br><br>
매개변수로 입력 받은 numbers의 배열요소에서 두 개를 뽑아서 더한 모든 경우의 수를 구하기 위해<br><br>
이중 반복을 합니다.<br><br>
첫번째 반복으로는 i = 0부터 numbers.length - 1까지<br><br>
두번째 반복으로는 j = i + 1부터 numbers.length까지 반복을 합니다.<br><br>
반복문 내부에서 numbers의 i번째 배열요소와 j번째 배열요소의 합을 numberSet에 add합니다.<br><br>
Set의 특성상 더한 값이 이미 있는 경우에는 추가되지 않고, 없는 경우에만 추가됩니다.<br><br>
즉, Set의 특성으로 인해 덧셈의 중복이 자동으로 제거되고, Set에는 모든 덧셈의 결과가 중복없이 저장됩니다.<br><br>
반복이 끝나면 정수형 배열 answer를 numberSet의 size만큼 힙에 할당합니다.<br><br>
for each 반복을 통해 numberSet에서 정수형 원소인 number를 하나씩 구하여 배열의 첨자 0부터 차례대로 저장합니다.<br><br>
반복이 끝나면 answer에는 Set의 모든 원소가 저장되어 있습니다.<br><br>
마지막으로 이를 정렬하기 위해 Arrays클래스의 sort를 이용하여 answer를 오름차순으로 정렬시킨 다음에 answer를 반환합니다.<br><br>

# 개선점
애초에 HashSet으로 Set의 객체인 numberSet을 생성하지 말고, 대신에 TreeSet의 생성자로 생성하는 방법이 있습니다.<br><br>
TreeSet의 경우 저장시 자동으로 오름차순으로 정렬이 되기 때문에 나중에 뒤에서 Arrays.sort를 사용할 필요가 없어집니다.
