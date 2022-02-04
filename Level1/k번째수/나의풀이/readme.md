# 내가 푼 코드

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] copy = null;
        for(int i = 0; i < commands.length; i++)
        {
            copy = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(copy);
            answer[i] = copy[commands[i][2] - 1];
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명하기

commands 배열은 1차원 배열을 배열요소로 하는 2차원배열입니다.<br><br>
answer를 생성할 때 commands 배열의 길이만큼 힙에 할당합니다.<br><br>
commands 배열의 길이만큼 반복을 돌리면서 copy배열에 복사복을 옮깁니다.<br><br>
copy배열을 생성할 때 Arrays클래스의 정적메소드인 copyOfRange메소드를 호출합니다.<br><br>
매개변수로는 복사할 대상인 배열 객체의 참조변수와<br><br>
복사할 시작위치부터 마지막위치까지를 입력합니다.<br><br>
마지막위치의 경우 마지막위치전까지만 포함하고, 마지막위치는 포함하지 않습니다.<br><br>
commands 2차원배열의 i번째 배열요소의 0번째에는 복사시작위치가 저장되어 있고,<br><br>
1번째에는 복사마지막위치가 저장되어 있습니다.<br><br>
이 때 여기서 commands i번째 배열요소의 0번째 복사시작위치에 -1을 해주는 이유는<br><br>
배열은 0부터 시작하는데 문제에서는 1부터 시작하도록 설정되어 있기 때문에<br><br>
이 차이를 반영하기 위해 시작위치에 -1을 해줍니다.<br><br>
마지막 위치의 경우 배열의 마지막위치보다 1크기 때문에<br><br>
+1을 따로 하지 않고, commands의 i번째 배욜요소의 1번째인 복사마지막위치를 그대로 넣으면 됩니다.<br><br>
이렇게 하면 copy가 매개변수로 입력 받은 array 배열의 시작위치부터 마지막위치까지 복사하게 됩니다.<br><br>
이제 이 copy를 오름차순으로 정렬하기 위해 Arrays의 sort메소드를 호출합니다.<br><br>
copy의 commands의 i번째 배열요소에서 2번째 배열요소에 copy에서 저장해야할 배열요소의 위치가 저장되어있는데<br><br>
이 값에 -1을 한 값을 copy의 배열첨자에 입력하여 그 값을 answer의 i번째 배열요소에 저장합니다.<br><br>
-1을 하는 이유는 위와 같이 배열은 0부터 시작하는데 문제는 1부터 시작하기 때문입니다.<br><br>
반복이 끝나고 나면 answer의 각 배열요소에는 정답이 저장되어 있을 것입니다.<br><br>

# 아쉬운 점

문제 설계는 빨리 끝났으나 구현시 자꾸 에러가 발생했는데<br><br>
그 이유가 배열은 0부터 시작하는데 문제는 1부터 시작하는 것을<br><br>
알아차리지 못해서 자꾸 헤맸다.<br><br>
다음부터 indexOutofArrayExecption이 발생할 때는 항상<br><br>
0부터 시작인지 1부터 시작인지를 먼저 알아보도록 하자.
