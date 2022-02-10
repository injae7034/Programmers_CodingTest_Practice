# 다른 사람이 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> arrList = new ArrayList<>();
        int temp = 10;
        for(int number : arr)
        {
            if(temp != number)
            {
                arrList.add(number);
            }
            temp = number;
        }
        int[] answer = new int[arrList.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

제가 푼 코드는 반복을 2번 하여 arrList에 연속되는 숫자가 중복이 안되도록 저장하였습니다.<br><br>
하지만 위의 코드를 보면 반복을 1번하여도 arrList에 연속되는 숫자가 중복이 안되게 저장할 수 있습니다.<br><br>
임시변수 temp를 10으로 저장하고, 반복분 내부에서 temp와 배열요소가 같지 않으면 arrList에 원소를 add합니다.<br><br>
처음에는 당연히 10과 같지 않을 것이기 때문에 arr배열의 첫번째 원소는 arrList에 add됩니다.<br><br>
임시변수 temp에 arr배열의 첫번째 원소를 저장합니다.<br><br>
임시변수 temp와 arr배열의 두번째 원소가 같지 않으면 arrList에 add하고, 같으면 add하지 않고 넘어갑니다.<br><br>
그리고 임시변수 temp에 다시 두번째 원소의 값을 저장합니다.<br><br>
이런식으로 반복을 돌면 한번 반복으로 arrList에 연속되는 숫자가 중복되지 않도록 저장할 수 있습니다.
