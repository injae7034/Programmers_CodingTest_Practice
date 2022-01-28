# 내가 쓴 코드를 개선한 코드

```java
class Solution {
        public int solution(String s) {
            int answer = 0;
            String[] numbers = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            String[] stringNumbers = new String[]{"zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine"};
            for(int i = 0; i < 10; i++)
            {
                s = s.replace(stringNumbers[i], numbers[i]);
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }
```

# 개선한 코드 설명

숫자로 표현한 문자배열 numbers를 힙에 할당하면서 초기화해줍니다.<br><br>
영단어로 숫자를 표현한 문자배열 stringNumbers를 힙에 할당하면서 초기화해줍니다.<br><br>
0부터 시작해 10보다 작은동안 반복문을 돌리면서 String의 replace메소드를 호출하여 영단어로 된 숫자가 있으면 숫자로 바꿔줍니다.<br><br>
이 후 String s를 Integer클래스의 정적메소드인 parseInt를 통해 정수형으로 바꿔준 다음에 이 값을 반환합니다.
