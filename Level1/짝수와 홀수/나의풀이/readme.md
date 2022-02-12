# 내가 풀이한 코드

```java
class Solution {
    public String solution(int num) {
        String answer = "";
        if(num % 2 == 0)
        {
            answer = "Even";
        }
        else
        {
            answer = "Odd";
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 num을 2로 나눈 나머지가 0이면<br><br>
짝수라는 뜻이기 때문에 answer에 "Even"을 저장합니다.<br><br>
나머지가 0이 아니라면 홀수라는 뜻이기 때문에<br><br>
answer에 "Odd"를 저장합니다.
