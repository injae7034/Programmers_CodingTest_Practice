# 내가 푼 코드

```java
import java.util.Arrays;

class Solution {
    public int solution(String s) {
        StringBuilder stb;
        String front;
        String back;
        int count;
        int[] answer = new int[s.length() / 2];
        if(s.length() == 1)
        {
            return 1;
        }
        for(int i = 1; i < s.length() / 2 + 1; i++)
        {
            front = s.substring(0, i);
            count = 1;
            stb = new StringBuilder();
            for(int j = i; j < s.length(); j += i)
            {
                if(j + i < s.length())
                {
                    back = s.substring(j, j + i);
                }
                else
                {
                    back = s.substring(j);
                }
                if(front.equals(back) == true)
                {
                    count++;
                }
                else
                {
                    if(count > 1)
                    {
                        stb.append(count);
                        count = 1;
                    }
                    stb.append(front);
                    front = back;
                }
            }
            if(count > 1)
            {
                stb.append(count);
            }
            stb.append(front);
            answer[i - 1] = stb.toString().length();
        }
        Arrays.sort(answer);
        return answer[0];
    }
}
```

# 내가 푼 코드 섷명하기

반복을 하는데 반복의 기준이 문자열을 압축하는 단위 기준으로 반복합니다.<br><br>
즉, 시작은 1단위로 압축하기 때문에 i = 1부터 시작하는 것이고<br><br>
문자열 압축 단위가 문자열 길의의 절반을 넘어가면 압축이 안되기 때문에<br><br>
마지막의 값을 절반, 즉, 문자열의 길이를 절반으로 나눈 몫에 + 1 보다 작은동안 반복합니다.<br><br>
반복문 내부에서 front는 0부터 시작하여 문자열 압축 단위 i까지 문자열을 잘라서(substring) 저장합니다.<br><br>
같은 문자열의 개수를 세는 count는 1로 초기화해줍니다.<br><br>
문자열을 이어 붙일 StringBuilder의 객체 stb를 생성해줍니다.<br><br>
다시 반복을 해야하는데 이번 반복은 문자열을 압축할 단위가 정해졌으면 문자열의 처음부터 시작해서<br><br>
문자열의 압축 단위만큼 증가시키면서 문자열의 마지막까지 압축할 문자를 찾는 과정입니다.<br><br>
그래서 j는 문자열의 압축단위 i로 초기화시키고,<br><br>
문자열의 길이보도 작은동안 그리고 반복할 때마다 문자열의 압축 단위인 i만큼 증가시켜줍니다.<br><br>
반복문 내부에서 j에 문자열의 압축단위 i를 더한 값이 문자열의 길이를 넘지 않으면<br><br>
j부터 시작해서 문자열의 압축단위 i까지 문자열을 잘라서(substring) back에 저장합니다.<br><br>
만약에 j에 문자열의 압축단위 i를 더한 값이 문자열의 길이보다 크면<br><br>
즉, j에서 시작해서 남은 문자열이 문자열을 압축하는 단위인 i보다 작으면<br><br>
더이상 문자열을 압축할 수 없기 때문에 문자열의 압축단위 i로 자르지 않고<br><br>
j부터 시작해서 남아 있는 문자열을 구하여(substring) back에 저장합니다.<br><br>
front에 저장된 문자열과 back에 저장된 문자열이 같으면 count를 세줍니다.<br><br>
다르다면 count가 1보다 크면 즉, 압축할 문자열이 있으면 앞에 count개수를 붙여주고<br><br>
count개수는 다시 1로 초기화 시켜줍니다.<br><br>
다음으로 count뒤에 front문자열을 붙여줍니다.<br><br>
front와 back이 서로 달랐기 때문에 전체 문자열에서 다음 문자열을 비교하러 가기 위해<br><br>
front에 back을 저장해줍니다.<br><br>
반복이 끝나고 나면 전체문자열 압축 처리과정에서 마지막 부분이 아직 처리가 안되어있는데<br><br>
count가 1보다 크다면 count먼저 붙여준다음 front를 붙여주고<br><br>
그게 아니라면 바로 front를 붙여줍니다.<br><br>
그러면 압축된 문자열이 stb에 저장이 될 것이고 이 문자열의 길이를<br><br>
정수형 1차원 배열 answer의 i - 1번째에 저장해줍니다.<br><br>
전체 반복이 끝나면 answer에는 각 압축문자열의 길이가 저장되어 있을 것이고<br><br>
이를 오름차순으로 정렬한다음 가장 첫번째 원소인 최소길이값을 반환합니다.<br><br>
그리고 처음에는 매개변수로 주어지는 문자열의 길이가 1인 경우를 반영하지 못해<br><br>
테스트케이스에서 1문제가 오답처리 되었습니다.<br><br>
그래서 이를 반영하여 매개변수로 주어지는 문자열 s의 길이가 1인 경우는<br><br>
압축이 안되기 때문에 바로 1을 반환합니다.
