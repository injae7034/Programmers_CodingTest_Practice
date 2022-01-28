# 내가 푼 코드
```java
package ProgramersLevel01;

public class Main {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            s = s.replace("zero", "0");
            s = s.replace("one", "1");
            s = s.replace("two", "2");
            s = s.replace("three", "3");
            s = s.replace("four", "4");
            s = s.replace("five", "5");
            s = s.replace("six", "6");
            s = s.replace("seven", "7");
            s = s.replace("eight", "8");
            s = s.replace("nine", "9");
            answer = Integer.parseInt(s);
            return answer;
        }
    }
}
```

# 내가 푼 코드 설명

숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어지는데 이를 원래 숫자로 바꿔서 출력하는 문제입니다.<br><br>
그냥 너무 단순하게 생각해서 0부터 9까지 모두 String메소드를 이용해 replace하고,<br><br>
그 값을 Integer클래스의 정적메소드인 parseInt를 이용해 다시 정수형으로 바꾼 다음에 그 값을 반환하였습니다.

# 한계점

너무 쉽게 생각하였고, 그리고 반복해야 하는 단위가 작다보니 미처 **배열을 이용해 반복구조를 돌릴 생각을 하지 못했습니다.**<br><br>
만약에 반복단위가 컸으면 이렇게 풀이할 수 없었는데, 왜 그 생각을 못했을까?;;<br><br>
앞으로는 반복되는 행위가 있으면 이 반복단위가 작더라도 줄일 수 없을까를 항상 고민하도록 해야겠습니다.
