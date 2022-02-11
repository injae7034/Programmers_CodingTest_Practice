# 내가 풀이한 코드

```java
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String one, String other)
            {
                int ret;
                if(one.charAt(n) > other.charAt(n))
                {
                    ret = 1;
                }
                else if(one.charAt(n) < other.charAt(n))
                {
                    ret = -1;
                }
                else
                {
                    if(one.compareTo(other) > 0)
                    {
                        ret = 1;
                    }
                    else if(one.compareTo(other) == 0)
                    {
                        ret = 0;
                    }
                    else
                    {
                        ret = -1;
                    }
                }
                return ret;
            }
        });
        return strings;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 String배열을 Arrays의 정적메소드인 sort를 이용하여 정렬합니다.<br><br>
정렬할 때, 디폴트값인 오름차순으로 하면 안되고,<br><br>
매개변수로 입력 받은 n번째 글자를 기준으로 오름차순으로 정렬하여야 합니다.<br><br>
그렇게 하기 위해서 sort의 매개변수에 정렬의 기준이 될 Comparator의 익명클래스 객체를 같이 넣어 줍니다.<br><br>
Comparator의 익명클래스의 객체는 compare를 오버라이딩해야 하는데<br><br>
매개변수로 String객체 one과 other를 받고,<br><br>
one과 other의 charAt메소드를 통해 n번째 문자를 서로 비교합니다.<br><br>
one의 n번째 문자가 더 크면 1을 반환하고,<br><br>
other의 n번째 문자가 더 크면 -1을 반환하고<br><br>
값이 같으면 one과 other의 문자열을 비교한 결과를 반환합니다.

# 아쉬운 점
one과 other값이 같을 때 사전 순으로 출력하라고 했기 때문에<br><br>
그냥 one.compareTo(other)를 반환하면 되는데<br><br>
그걸 또 풀이하느라 코드길이가 길어짐.<br><br>
다음부터는 사전 순으로 정렬하는 경우에는 compareTo를 바로 반환하자.
