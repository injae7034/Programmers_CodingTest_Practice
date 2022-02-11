# 내가 풀이한 코드

```java
class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if(length % 2 == 0)
        {
            answer = s.substring(length / 2 - 1, length / 2 + 1);
        }
        else
        {
            answer = s.substring(length / 2, length / 2 + 1);
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

먼저 매개변수로 입력 받은 문자열의 길이를 length에 저장합니다.<br><br>
length를 2로 나눈 나머지가 0이면 짝수이기 때문에 가운데 2글자를 잘라야 하는데<br><br>
이 때 substring을 사용하여 length를 2로 나눈 몫에 1을 빼준 값부터 1을 더해준 값까지 문자열을 자릅니다.<br><br>
-1을 해주는 이우는 문자열의 첨자가 0부터 시작해서이고, +1을 해주는 이유는 substring은 마지막 문자열 위치 이전까지 자르기 때문입니다.<br><br>
홀수이면 한글자만 출력하면 되는데 length를 2로 나눈 몫이 0부터 시작하는 첨자와 일치하기 때문에 따로 -1을 해줄 필요가 없고,<br><br>
+1을 해주는 이유는 그 전까지 글자를 자르기 때문에 1글자만 자르기 위해서입니다.<br><br>
이 후 answer를 반환합니다.
