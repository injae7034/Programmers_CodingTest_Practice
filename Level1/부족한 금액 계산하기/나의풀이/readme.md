# 내가 풀이한 코드
```java
class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 1; i <= count; i++)
        {
            answer += price * i;
        }
        answer -= money;
        if(answer < 0)
        {
            answer = 0;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명
먼저 이용하고 싶은 횟수인 count만큼의 곱을 구하기 위해<br><br>
i = 1부터 count보다 작거나 같은 동안 반복을 합니다.<br><br>
반복문 내부에서 i = 1부터 시작하여 price를 곱한 값을<br><br>
i = count 일 때 price와 곱한 값까지 더하여 누적시킵니다.<br><br>
이 값을 money로 빼주고,<br><br>
answer가 음수가 되면 0으로 바꿔준다음 answer를 반환합니다.
