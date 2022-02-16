# 내가 푼 코드

```java
package ProgramersLevel02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String one, String other)
            {
                int ret;
                if(one.length() > other.length())
                {
                    ret = 1;
                }
                else if(one.length() == other.length())
                {
                    ret = 0;
                }
                else
                {
                    ret = -1;
                }
                return ret;
            }
        });
        for(int i = 0; i < phone_book.length - 1; i++)
        {
            for(int j = i + 1;  j < phone_book.length; j ++)
            {
                if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())) == true)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean answer = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(answer);
	    answer = solution(new String[]{"123","456","789"});
        System.out.println(answer);
        answer = solution(new String[]{"12","123","1235","567","88"});
        System.out.println(answer);
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 주어지는 phone_book의 문자열 배열을 정렬해야겠다는 생각은 하였는데 엉뚱한 방향으로 정렬하였습니다.<br><br>
현재는 문자열의 길이가 뒤의 것이 앞의 것보다 더 길수도 있기 때문에 문자열의 길이를 기준으로 오름차순으로 정렬하면<br><br>
항상 앞의 원소가 뒤의 원소의 문자열 길이보다 작거나 같을 것이 보장되기 때문에 이를 바탕으로 문자를 서로 비교해야겠다는 생각을 하였습니다.<br><br>
그래서 phone_book을 Arrays의 sort를 이용해 정렬을 하는데 Comparator를 익명클래스로 생성하여<br><br>
compare함수를 오버라이딩하는데 그 길이를 기준으로 오름차순 정렬하도록 하였습니다.<br><br>
길이를 기준으로 오름차순된 phone_book을 i = 0부터 시작하여 phone_book의 length - 1 보다 작은동안 반복하고<br><br>
다시 j = i + 1부터 시작하여 phone_book의 length보다 작은동안 반복하였습니다.<br><br>
이렇게 이중반복을 통하여 phone_book의 i번째 원소를 마지막 원소까지 계속해서 비교하는 이중반복을 돌렸습니다.<br><br>
반복문 내부에서는 phone_book의 i번째 요소가 phone_book의 j번째 요소(phone_book의 i번째 요소보다 길이가 크거나 같음)를<br><br>
0번째부터 phone_book의 length - 1위치만큼 substring하여 그 값이 같으면 접두사가 있기 때문에 바로 false를 반환하여 함수를 종료시키고<br><br>
이중반복이 끝나면 접두사가 없기 때문에 true를 반환하였습니다.<br><br>
제출한 결과 정확성은 모두 통과하였으나 이중반복으로 인해 효율성에서 2문제 틀려서 통과하지 못했습니다.<br><br>

# 아쉬운 점
정렬을 하는 것은 좋았으나 이상한 방향(?)으로 한 것이 문제였습니다.<br><br>
길이 순으로 정렬하는 것이 아니라 그냥 바로 정렬하였으면<br><br>
String클래스의 특성상 사전편찬순으로 정렬이 되기 때문에 이중반복없이<br><br>
한번의 반복으로 접두사를 비교할 수 있어서 효율성을 통과할 수 있습니다.<br><br>
String클래스의 오름차순 정렬기준에 대해 다시한번 생각하고 기억해놔야겠습니다.<br><br>
또한 접두사나 접미사가 일치하는지 확인할 때는<br><br>
String클래스의 startsWith나 endsWith를 쓰면 손쉽게 비교할 수 있으니 이 또한 기억해야겠습니다.
