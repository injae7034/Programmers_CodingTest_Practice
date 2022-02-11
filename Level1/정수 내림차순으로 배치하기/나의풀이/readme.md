# 내가 풀이한 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String number = "" + n;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < number.length(); i++)
        {
            list.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder stb = new StringBuilder();
        for(int num : list)
        {
            stb.append(String.valueOf(num));
        }
        long answer = Long.parseLong(stb.toString());
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 n에 공백을 더해줘서 문자열 객체 number에 저장합니다.<br><br>
ArrayList\<Integer\>를 생성하여 문자열의 각 문자를 정수로 바꿔준 다음에 각 문자를 일일이 add합니다.<br><br>
이후 이 list를 내림차순으로 sort합니다.<br><br>
StringBuilder객체를 생성하고, 내림차순으로 정렬된 list에서 각 원소를 하나씩 구해서<br><br>
이를 문자열로 바꿔준다음에 StringBuilder객체에 append합니다.<br><br>
StringBuilder객체를 toString을 호출하여 문자열로 바꿔주고 그 값을 Long의 paresLong을 통해 long으로 바꿔 준 값을 반홥합니다.
