# 내가 푼 코드

```java
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a < b)
        {
            for(int i = a; i <= b; i++)
            {
                answer += i;
            }
        }
        else if(a > b)
        {
            for(int i = b; i <= a; i++)
            {
                answer += i;
            }
        }
        else
        {
            answer = a;
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명
a와 b의 대소비교를 하여 b가 더 크면<br><br>
i = a부터 b까지 반복을 하면서 answer에 값을 더하여 누적시킵니다.<br><br>
a가 b보다 더 크면<br><br>
i = b부터 a까직 반복을 하면서 answer에 값을 더하여 누적시킵니다.<br><br>
a와 b가 같으면 answer에 a를 저장합니다.<br><br>
answer를 반환합니다.
