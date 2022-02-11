# 내가 풀이한 코드

```java
class Solution {
    public String solution(int n) {
        String answer = "";
        for(int i = 0; i < n; i++)
        {
            if(i % 2 == 0)
            {
                answer += "수";
            }
            else
            {
                answer += "박";
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

i = 0부터 매개변수로 입력 받은 정수 n보다 작은 동안 반복합니다.<br><br>
짝수 위치(2로 나눈 나머지가 0이면)면 "수"를 더해주고<br><br>
홀수 위치는 "박"을 더해줍니다.
