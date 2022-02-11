# 내가 풀이한 코드

```java
class Solution {
    public int[] solution(long n) {
        String reverseNumber = new StringBuilder(new String(String.valueOf(n))).reverse().toString();
        int[] answer = new int[reverseNumber.length()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = Integer.parseInt(String.valueOf(reverseNumber.charAt(i)));
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 n을 string클래스이 정적메소드인 valueOf을 이용해 문자열로 바꿔줍니다.<br><br>
문자열을 넣어 StringBuilder의 객체를 생성하고, reverse메소드를 호출하여 이를 뒤집은 다음<br><br>
toString을 호출해 문자열을 반환하여 그 값을 reverseNumber에 저장합니다.<br><br>
문자열로 바꾼 후 문자열의 각 문자(숫자)를 charAt을 통해 구한 다음 다시 문자열로 바꾸고,<br><br>
Integer클래스의 parseInt를 통해 정수로 바꿔준 값을 answer의 i번째 배열요소에 저장해줍니다.<br><br>
문자열로 바꾸지 않는다면 나머지를 이용하여 자리수를 계산하는 방법도 있습니다.
