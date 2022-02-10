# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                if(arr[i] == arr[j])
                {
                    arr[j] = 10;
                }
                else
                {
                    break;
                }
            }
        }
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 10)
            {
                arrList.add(arr[i]);
            }
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

# 내가 푼 코드 설명

이중반복을 통해 arr배열의 i번째 배열요소를 arr배열의 j번째 배열원소와 비교합니다.<br><br>
i번째 배열요소와 j번째 배열요소가 같으면 j번째 배열요소에 10을 대입합니다.<br><br>
arr배열의 각 원소는 0~9까지이므로 중복되는 요소는 나중에 제거하기 위해 10을 저장해줍니다.<br><br>
같지 않으면 break를 통해 이중반복중에 하나의 반복에서 벗어나고 상위 반복의 조건문으로 돌아갑니다.<br><br>
반복이 끝나면 연속해서 같은 숫자는 처음만 제외하고 모두 10이 저장되어 있을 것입니다.<br><br>
List객체를 ArrayList의 생성자로 생성하여 반복을 돌리면서 값이 10미만인 원소만 add해줍니다.<br><br>
그러면 List객체에는 연속되는 숫자는 모두 제거되고, 연속 안된 숫자만 저장될 것입니다.<br><br>
이를 answer에 담아서 출력합니다.
