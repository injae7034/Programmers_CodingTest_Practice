# 내가 풀이한 코드

```java
class Solution {
    public int solution(int n) {
       String sum = "";
        while(n > 0)
        {
            sum += (n % 3);
            n /= 3;
        }
        return Integer.parseInt(sum, 3);
    }
}
```

# 내가 풀이한 코드 설명하기

매개변수로 입력 받은 10진수 n을 3진수로 변경하여 담을 sum이라는 문자열 변수를 생성합니다.<br><br>
n이 0보다 큰 동안 반복을 합니다.<br><br>
반복문 내부에서 10진수 n을 3으로 나눈 나머지를 더하는데 이 때,<br><br>
3진수를 뒤집어야 하기 때문에 sum = sum + (n % 3)으로 표현합니다.<br><br>
n에는 3으로 나눈 몫을 저장합니다.<br><br>
반복문이 끝나면 문자열 sum에는 10진수 n을 3진법으로 표현하고 이를 뒤집은 값이 저장되어 있습니다.<br><br>
이를 다시 정수형으로 바꾸기 위해 Integer클래스의 정적메소드인 parseInt를 호출하는데<br><br>
매개변수로 문자열 sum과 함께 3(진법)을 같이 전달하면 해당 문자열을 3진수로 인식하고,<br><br>
이를 10진수로 바꿔줍니다.
