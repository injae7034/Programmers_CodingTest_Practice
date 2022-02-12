# 내가 풀이한 코드

```java
class Solution {
    public long[] solution(int x, int n) {
        long number = x;
        long[] answer = new long[n];
        for(int i = 1; i <= answer.length; i++)
        {
            answer[i - 1] = number * i;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

매개변수로 입력받은 int형 x에 int형 정수를 곱한 값을 long배열 answer의 배열요소에 저장해야하는데<br><br>
이 때 x도 정수형이고 곱한 값도 int형일 때 그 2개를 곱한 값이 int의 범위를 벗어나면<br><br>
answer의 배열요소에 저장될 때 오류가 발생할 수 있기 때문에<br><br>
이를 방지하기 위해 long형 number에 x를 옮깁니다.<br><br>
answer배열을 매개변수로 입력 받은 n만큼 힙에 할당합니다.<br><br>
i = 1부터 시작하여 answer의 length보다 작거나 같은동안 반복합니다.<br><br>
i는 number에 곱해주기 위해 1부터 시작하였고, 배열의 첨자는 0부터 시작하기 때문에<br><br>
answer의 i - 1번째 첨자부터 number에 i를 곱한 값을 저장해줍니다.
