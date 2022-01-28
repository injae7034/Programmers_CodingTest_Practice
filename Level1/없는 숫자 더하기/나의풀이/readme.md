# 내가 푼 코드
 ```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Map<Integer, Boolean> numMaps = new HashMap<>();
        for(int i = 0; i < 10; i++)
        {
            numMaps.put(i, false);
        }
        for(int num : numbers)
        {
            numMaps.replace(num, true);
        }
        for(int i = 0; i < numMaps.size(); i++)
        {
            if(numMaps.get(i) == false)
            {
                answer += i;
            }
        }
        return answer;
    }
} 
 ```
 
 # 내가 푼 코드 설명
 
 먼저 Key값이 Integer이고, Value값이 Boolean인 Map의 객체 numMaps를 HashMap 생성자를 이용해 생성합니다.<br><br>
 for 반복구조를 통해 i=0부터 9까지 순차적으로 반복을 돌면서 모든 key값의 value값을 false로 초기화해줍니다.<br><br>
 for each 반복구조를 통해 매개변수로 입력 받은 정수형 숫자배열 numbers에서 배열요소인 중복이 없는 숫자를 하나씩 구한 다음<br><br>
 이를 HashMap의 replace 메소드의 Key값으로 전달하고, value값은 true를 전달하여,<br><br>
 해당 숫자를 key값으로 가지는 엔트리의 value 값을 true로 변경해줍니다.<br><br>
 다시 해쉬맵의 size만큼 반복을 돌면서 해당 key값의 value가 false인 key값을 answer에 누적시켜서 더합니다.<br><br>
 반복구조가 끝나고 나면 answer에는 숫자배열에 없는 숫자들의 합이 구해져 있을 것입니다.
 
 # 아쉬운 점
 반복구조를 3번이나 돌리면서 문제를 풀 필요가 있었을까?
 굳이 HashMap을 사용할 필요가 있었을까?
 좀 더 단순하게 문제를 풀 수는 없었을까?
