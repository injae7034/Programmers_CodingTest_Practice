# 내가 풀이한 코드

```java
import java.util.Collections;
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] str = new String[s.length()];
        for(int i = 0; i < str.length; i++)
        {
            str[i] = String.valueOf(s.charAt(i));
        }
        Arrays.sort(str, Collections.reverseOrder());
        s = "";
        for(int i = 0; i < str.length; i++)
        {
            s += str[i];
        }
        return s;
    }
}
```

# 내가 풀이한 코드 설명

문자열 배열 str을 문자열 s의 크기만큼 힙에 할당합니다.<br><br>
문자열 s의 한 문자씩 str문자열 배열의 배열요소에 저장합니다.<br><br>
Arrays의 sort메소드를 호출하면서 정렬기준으로 Collections의 reverseOrder를 호출합니다.<br><br>
문자열 s를 공백으로 초기화하고, str문자열 배열의 첫원소부터 마지막원소까지 더한 값을 문자열 s에 누적시킵니다.<br><br>
문자열 s는 내림차순으로 정렬됩니다.

# 아쉬운 점

StringBuilder를 이용하면 반복문을 이용하지 않고 간편하게 내림차순으로 정렬할 수 있습니다.<br><br>
```java
    char[] arr = s.toCharArray();
    Arrays.sort(arr);
    return new StringBuilder(new String(arr)).reverse().toString();
```
String객체인 s를 toCharArray를 통해 char배열로 바꿔주고,<br><br>
이를 Arrays.sort를 통해 오름차순으로 정렬합니다.<br><br>
그리고 arr을 통해 String객체를 생성하고, 이 String객체를 이용해 StringBuilder의 객체를 생성하는데,<br><br>
StringBuilder의 reverse메소드를 통해 오름차순으로 정렬된 문자들을 역으로 바꿔주면 당연히 내림차순이 됩니다.<br><br>
마지막으로 toString을 통해 String으로 변경해준 값을 출력합니다.<br><br>
이처럼 StringBuilder를 사용하면 반복문 하나없이 깔끔하게 내림차순으로 출력할 수 있습니다.
