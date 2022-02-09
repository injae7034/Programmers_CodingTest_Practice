# 내가 푼 코드

```java
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        int count = 0;
        for(int i = left; i <= right; i++)
        {
            count = 0;
            for(int j = 1; j <= i; j++)
            {
                if(i % j == 0)
                {
                    count++;
                }
            }
            if(count % 2 == 0)
            {
                answer += i;
            }
            else
            {
                answer -= i;
            }
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명하기

정답으로 반환할 answer를 0으로 초기화합니다.<br><br>
약수의 개수를 셀 변수 count를 0으로 초기화합니다.<br><br>
i = left부터 시작하여 right보다 작거나 같은 동안 반복을 합니다.<br><br>
반복문 내부에서 약수의 개수를 나타내는 count를 다시 초기화해주는데<br><br>
여기서 매번 초기화를 0으로 해줍니다.<br><br>
다시 반복문을 이용하는데 이번에는 j = 1부터 시작하여 i보다 작거나 같은 동안 반복합니다.<br><br>
반복문 내부에서 i를 j로 나눈 나머지를 구하는 연산을 사용하여 그 나머지가 0이면<br><br>
j가 i의 약수라는 뜻이므로<br><br>
약수의 개수 count를 +1 해줍니다.<br><br>
반복문이 끝나고 나서 count를 2로 나눈 나머지가 0이면<br><br>
약수의 개수가 짝수라는 뜻이기 때문에 answer에 i를 더해주고,<br><br>
count를 2로 나눈 나머지가 0이 아니면<br><br>
약수의 개수삭 홀수라는 뜻이기 때문에 answer에 i를 빼줍니다.<br><br>
반복문이 끝나면 answer에는 값이 누적되어 있을 것이고, 이를 반환해줍니다. 
