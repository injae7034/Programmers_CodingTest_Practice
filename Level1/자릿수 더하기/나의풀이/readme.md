# 내가 풀이한 코드

```java
public class Solution {
    public int solution(int n) {
        String number = String.valueOf(n);
        int answer = 0;
        for(int i = 0; i < number.length(); i++)
        {
            answer += Integer.parseInt(String.valueOf(number.charAt(i)));
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 n을 string클래스이 정적메소드인 valueOf을 이용해 문자열로 바꿔줍니다.<br><br>
문자열로 바꾼 후 문자열의 각 문자(숫자)를 charAt을 통해 구한 다음 다시 문자열로 바꾸고,<br><br>
Integer클래스의 parseInt를 통해 정수로 바꿔준 값을 answer에 더해줍니다.<br><br>
문자열로 바꾸지 않는다면 나머지를 이용하여 자리수를 계산하는 방법도 있습니다.
