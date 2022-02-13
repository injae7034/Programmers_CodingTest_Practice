# 내가 푼 코드

```java
import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringTokenizer tokens = new StringTokenizer(s, " ");
        char[] strArr = s.toCharArray();
        for(int i = 0; i < strArr.length; i++)
        {
            if(strArr[i] != ' ')
            {
                if(strArr[i] < 48 || strArr[i] > 57)
                {
                    strArr[i] = String.valueOf(strArr[i]).toUpperCase().charAt(0);
                }
                i += tokens.nextToken().length() - 1;
            }
        }
        return new String(strArr);
    }
}
```

# 내가 푼 코드 설명

먼저 매개변수로 입력 받은 s를 toLowerCase를 호출하여 모두 소문자로 변경해줍니다.<br><br>
다음으로 StringTokenizer 객체 tokens를 생성하는데 공백을 기준으로 단어를 구분하여 저장합니다.<br><br>
StringTokenizer의 경우 String의 split과는 다르게 공백이 여러 개 연속으로 나오더라도 단어만 구하여 저장합니다.<br><br>
String 객체 s의 toCharArray를 호출하여 문자배열 strArrr을 생성합니다.<br><br>
strArr은 s의 공백부터 포함하여 모든 문자를 배열로 저장합니다.<br><br>
i = 0부터 시작하여 strArr의 길이보다 작은동안 반복합니다.<br><br>
strArr의 i번째 배열요소가 공백이라면 그냥 넘어가서 다음 배열요소로 이동하고,<br><br>
strArr의 i번째 배열요소가 공백이 아니라면 그 문자가 숫자인지 확인합니다.<br><br>
숫자는 아스키코드에서 48이상 57미만이기 때문에<br><br>
해당 문자가 48보다 작거나 57보다 큰지 확인하여 맞다면 숫자가 아닌 문자이기 때문에<br><br>
해당 문자를 문자열로 바꿔주고(String.valueOf), 대문자로 바꿔주고(toUpperCase),<br><br>
문자열에서 첫번째 문자를 구합니다.(charAt(0))<br><br>
한 문자가 문자열로 비뀐 것이기 때문에 charAt(0)을 하면 대문자로 바뀐 문자를 구할 수 있습니다.<br><br>
이를 strArr의 i번째 배열요소에 저장합니다.<br><br>
그리고 현재 strArr의 i번째 문자가 숫자이든 알파벳이든 단어의 첫 시작입니다.<br><br>
단어의 첫부분이 숫자이면 해당 단어는 대문자로 바꿔줄 것이 없고, 단어의 첫부분이 알파벳이면 처음만 대문자로 바꿔주면 됩니다.<br><br>
그렇다면 이미 해당 단어에 해줘야할 처리는 다 해줬기 때문에 다음 단어로 바로 넘어가야 합니다.<br><br>
이를 위해 아까 StringTokenizer에서 구한 단어를 nextToken으로 하여 반환 받고, 그 문자열의 길이를 구하여 i에 더해줍니다.<br><br>
그러면 i는 처리된 단어는 건너 뛰고 다음 단어 또는 공백의 위치로 이동합니다.<br><br>
코드에서는 tokens.nextToken().length() - 1을 해줬는데 -1을 해줘도 되고 안해줘도 됩니다.<br><br>
왜냐하면 어차피 단어는 최소 1개 이상의 공백으로 구분되기 때문에 -1을 안해주면 바로 단어로 이동하거나 공백을 하나 건너 뛰는 것이기 때문에<br><br>
오히려 -1을 안해주면 반복횟수를 줄이게 됩니다.<br><br>
이런식으로 반복하면 성공적으로 JadenCase 문자열을 만들 수 있습니다.
