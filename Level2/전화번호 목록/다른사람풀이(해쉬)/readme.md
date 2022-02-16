# 다른사람이 푼 코드

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++)
        {
            map.put(phone_book[i], 1);
        }
        for(int i = 0; i < phone_book.length; i++)
        {
            for(int j = 1; j < phone_book[i].length(); j++)
            {
                if(map.containsKey(phone_book[i].substring(0, j)))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
```

# 다른 사람이 풀이한 코드 분석하며 공부하기

매개변수로 주어지는 phone_book의 문자열 배열의 원소 String을 Key값으로 하는 Map의 객체를 생성합니다.<br><br>
i = 0부터 phone_book의 길이보다 작은동안 반복을 하면서 phone_book의 원소인 문자열을 key값으로<br><br>
Value값은 해당 키가 있다는 표현을 하기 위해 Integer로 1을 put합니다.<br><br>
map의 초기화작업이 끝났으면 이중반복을 할 차례인데<br><br>
i = 0부터 시작하여 phone_book의 길이보다 작은동안 반복합니다.<br><br>
j = 1부터 시작하여 phone_book의 i번째 배열요소인 문자열의 길이보다 작은동안 반복합니다.<br><br>
반복문 내부에서 map의 containsKey메소드를 통해 매개변수로 넣은 문자열이 map의 key로 존재하는지 여부를 반환받습니다.<br><br>
이 때 매개변수로 phone_book의 i번째 문자열을 substring을 통해 0번째부터 j - 1번째까지 잘라줍니다.<br><br>
j = 1부터 시작하기 때문에 처음에는 접두사 1글자가 해당 map에 key로 존재하는지 확인하고<br><br>
없다면 j값을 계속 늘려가면서 확인합니다.<br><br>
phone_book의 i번째 원소의 길이보다 작은동안 반복이기 때문에<br><br>
substring에는 최대 phone_book의 i번째 배열요소의 길이보다 -1 작은 값이 들어오기 때문에<br><br>
map에서 자기 자신을 검색하는 일은 없습니다.<br><br>
딱 자기 자신이 되기 전의 앞글자까지만 검색합니다.<br><br>
즉, phone_book의 전체 원소를 처음부터 마지막까지 하나씩 구해서<br><br>
그 원소(문자열)를 한 글자씩 늘려가면서 잘라서 map에 접두사로 저장된 key가 있는지 확인하는 방법입니다.<br><br>
즉, Map의 Key값에 저장되어 있는 값들은 전화번호(잘리지 않은 원본)이고,<br><br>
phone_book의 i번째 원소(전화번호)에서 처음부터 특정위치까지 잘린번호를 확인하는데<br><br>
그게 map의 key에 있다면 phone_book의 i번째 원소(전화번호)는 누군가의 전화번호를 접두사로 포함하고 있다는 뜻입니다.
