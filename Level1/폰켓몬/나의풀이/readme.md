# 내가 풀이 한 코드

```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> numberSet = new HashSet<>();
        for(int number : nums)
        {
            numberSet.add(number);
        }
        for(int i = 1; i <= nums.length / 2; i++)
        {
            if(i <= numberSet.size())
            {
                answer++;
            }
            else
            {
                break;
            }
        }
        return answer;
    }
}
```

# 내가 풀이 한 코드 설명

먼저 Set의 객체인 numberSet을 자료형은 Integer로 하여 HashSet의 생성자로 생성합니다.<br><br>
이 후 매개변수로 입력 받은 nums배열에서 배열요소를 하나씩 구하여<br><br>
처음부터 마지막까지 반복하면서 numberSet에서 배열요소를 add해줍니다.<br><br>
Set의 경우 중복된 값을 입력하면, 이를 add하지 않고, 중복된 값이 없는 경우에만 add하기 때문에<br><br>
반복문이 끝나고 나면 numberSet에는 nums에서 중복되지 않은 배열요소들만 저장되어 있을 것입니다.<br><br>
다시 반복을 돌리는데 i = 1부터 시작하야 nums.length를 2로 나눈 값보다 작거나 같은 동안 반복합니다.<br><br>
문제에서 nums길이의 절반을 선택할 수 있다고 했기 때문에 이렇게 설정하였습니다.<br><br>
내부에서 i가 numberSet의 크기보다 작은동안은 answer값을 +1씩 증가시켜 주고,<br><br>
i가 numberSet의 크기보다 커지는 경우 break를 이용하여 바로 반복문을 종료하고,<br><br>
answer값을 반환합니다.<br><br>
만약에 nums가 모두 다른 배열요소를 가져서 numberSet의 사이즈가 nums.length를 2로 나눈 값보다 크더라도<br><br>
반복문이 종료된 뒤에 answer값에는 numberSet의 사이즈의 절반값이 저장되어 있기 때문에 문제없이 정답을 구할 수 있습니다.
