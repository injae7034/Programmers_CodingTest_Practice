# 내가 풀이한 코드

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                answer += i;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

i = 1부터 매개변수로 입력 받은 n보다 작거나 같은 동안 반복합니다.<br><br>
반복문 내에서 n을 i로 나눈 나머지가 0이면 answer에 i를 더해줍니다.<br><br.
반복문이 끝나고 answer를 반환합니다.
