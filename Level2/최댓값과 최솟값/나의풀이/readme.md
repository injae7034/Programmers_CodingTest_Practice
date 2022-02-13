# 내가 풀이한 코드
```java
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer tokens = new StringTokenizer(s, " ");
        while(tokens.countTokens() > 0)
        {
            list.add(Integer.parseInt(tokens.nextToken()));
        }
        Collections.sort(list);
        String answer = String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size() - 1));
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기
매개변수로 입력 받은 s에 있는 숫자들을 담을 List의 객체 list를 ArrayList의 생성자를 이용하여 생성합니다.<br><br>
매개변수 s는 공백으로 구분하여 숫자들을 저장하고 있습니다.<br><br>
여기서 숫자들만 가져오기 위해 StringTokenizer의 객체 tokens를 생성하면서 공백을 구분 기준으로 하여 숫자만 추출합니다.<br><br>
StrinkToken의 경우 nextToken을 호출하면 그 개수가 줄게 되는데 이를 활용하여<br><br>
tokens의 메소드 countTokens를 호출하여 그 값이 0보다 큰 동안 반복합니다.<br><br>
nextToken을 계속 호출하여 tokens에 더이상 저장된 문자열이 없다면 0이 반환될 것이기 때문에<br><br>
여기서 반복조건문으로 쓰이기 좋습니다.<br><br>
반복문 내부에서는 tokens의 nextToken을 호출하여 저장된 문자열(숫자)을 구하고, 이를 정수로 바꿉니다.(Integer.pareseInt)<br><br>
그리고 정수로 바뀐 값을 list에 add해줍니다.<br><br>
이 반복을 통해 문자열 s의 모든 숫자들을 list에 저장할 수 있습니다.<br><br>
이제 list를 Collections의 sort메소드를 호출하여 오름차순으로 정렬합니다.<br><br>
answer에 list의 처음원소(최솟값)과 공백을 더해주고 다시 마지막원소(최댓값)을 더해준 값을 반환합니다.
