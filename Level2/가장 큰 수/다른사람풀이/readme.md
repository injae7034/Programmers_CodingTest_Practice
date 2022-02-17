# 다른 사람이 풀이한 코드
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for(int i = 0; i < stringNumbers.length; i++)
        {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(stringNumbers, new Comparator<String>(){
            @Override
            public int compare(String one, String other)
            {
                //내림차순
                return (other + one).compareTo(one + other);
            }
        });
        //0만 있는 경우 0 하나만 리턴
        if(stringNumbers[0].equals("0"))
        {
            return "0";
        }
        String answer = "";
        for(String str : stringNumbers)
        {
            answer += str;
        }
        return answer;
    }
}
```

# 다른 사람이 풀이한 코드 해석하며 공부하기

다른 사람이 풀이한 코드를 보면 각자리수를 구해서 비교하지 않았습니다.<br><br>
먼저 정수배열을 문자배열로 바꾼 다음에<br><br>
앞뒤를 더해서 그 중에 더 큰 값을 내림차순으로 정렬하였습니다.<br><br>
이 후 0만 있는 경우도 있어서 그 경우에는 0 하나만 리턴하도록 하였습니다.

# 느낀 점

가장 단순하게 떠오른 방법이 각 자리수 하나씩 꺼내서 비교하는 것인데<br><br>
이는 너무 복잡합니다.<br><br>
이럴 경우 **문자열의 덧셈으로 대소비교를 할 수 있다**는 것을 항상 명심해야겠습니다.
