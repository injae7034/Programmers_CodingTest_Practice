# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] % divisor == 0)
            {
                arrList.add(arr[i]);
            }
        }
        if(arrList.size() > 0)
        {
            int[] answer = new int[arrList.size()];
            for(int i = 0; i < answer.length; i++)
            {
                answer[i] = arrList.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
        return new int[]{-1};
    }
}
```

# 내가 푼 코드 설명

먼저 List객체 arrList를 ArrayList의 생성자로 생성하고 자료형은 Integer로 설정합니다.<br><br>
매개변수로 입력 받은 arr배열의 첫번째 원소부터 마지막까지 반복합니다.<br><br>
반복문 내부에서 매개변수로 입력 받은 divisor로 나눈 나머지가 0이면<br><br>
arrList에 add합니다.<br><br>
arrList의 size가 0보다 크면<br><br>
즉, arr배열의 원소 중에 divisor로 나누어 떨어진 수가 1개라도 있다면<br><br>
answer배열에 arrList의 원소를 담은 다음 Arrays클래스의 정적메소드인 sort를 이용해<br><br>
오름차순으로 정렬한 answer배열을 반환합니다.<br><br>
arrList의 size가 0이라면 배열에 -1을 담아서 반환합니다.
