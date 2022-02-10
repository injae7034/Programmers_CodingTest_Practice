# 내가 풀이한 코드

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i < n; i++)
        {
            if(n % i == 1)
            {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 n은 3부터 시작하기 때문에<br><br>
반복을 할 때 i = 2부터 시작하여 n보다 작은동안 반복합니다.<br><br>
반복문 내부에서 n을 i로 나눈 나머지를 구하는 연산을 하여<br><br>
그 값이 1이면 answer에 i를 저장하고, break를 하여 반복문을 벗어난 뒤<br><br>
answer를 반환합니다.
