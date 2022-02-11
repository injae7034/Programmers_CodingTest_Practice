# 내가 푼 코드

```java
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        char[] arr = s.toCharArray();
        StringTokenizer tokens = new StringTokenizer(s, " ");
        String word= "";
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != ' ')
            {
                word = tokens.nextToken();
                for(int j = 0; j < word.length(); j++)
                {
                    if(j % 2 == 0)
                    {
                        arr[i] = String.valueOf(arr[i]).toUpperCase().charAt(0);
                    }
                    else
                    {
                        arr[i] = String.valueOf(arr[i]).toLowerCase().charAt(0);
                    }
                    i++;
                }
                
            }
        }
        return new String(arr);
    }
}
```

# 내가 푼 코드 설명하기

문제를 풀기 전에 주의할 점은 예시를 들지 않았지만 문제에서 단어사이의 공백은 하나이상 일 수 있다는 점입니다.<br><br>
이것을 놓치면 계속 오답을 내면서 왜 틀렸지하고 헤매게 됩니다.<br><br>
제가 그랬습니다ㅠ<br><br>
각설하고 코드 설명을 들어가면<br><br>
먼저 매개변수로 입력 받은 문자열 s를 toCharArray를 호출하여 문자배열을 반환받아 arr에 저장합니다.<br><br>
StringTokenizer의 객체 tokens를 생성하면서 공백을 기준으로 단어를 구분하여 저장하도록 합니다.<br><br>
s에 단어사이에 공백이 여러 개 있을 때 StringTokenizer 생성시 기준으로 공백 한 칸만 입력하여도<br><br>
성공적으로 단어만 분리하여 저장합니다.<br><br>
문자배열 arr의 처음원소부터 마지막원소까지 반복을 구하면서 각 원소를 구하는데<br><br>
원소값이 공백이면 다음 원소로 넘어가고,<br><br>
공백이 아니면<br><br>
tokens의 nextToken메소드를 통해 분리한 단어를 구합니다.<br><br>
단어를 기준으로 하여 j부터 시작하여 단어의 길이보다 작은동안 반복을 하는데<br><br>
j가 짝수번째 위치이면 arr의 i번째 위치의 문자를 대문자로 바꿔주고<br><br>
j가 홀수번째 위치이면 arr의 i번째 위치의 문자를 소문자로 바꿔줍니다.<br><br>
문자를 바꿔준다음 arr의 i번째 첨자 위치를 +1 증가시킨다음 다시 j의 반복조건문으로 돌아갑니다.<br><br>
이러한 반복이 끝나고 나면 arr에는 문제에서 제시한대로 문자들이 저장되고<br><br>
이를 String클래스의 생성자에 넣어서 반환합니다.
toCharArray를 통해 char배열을 이용하는 방법도 있지만<br><br>
split("")을 이용해 모든 문자와 공백을 각각 전부 문자열로 변환하여<br><br>
이 문자열을 배열요소로 하는 문자열 배열을 반환하는 방법도 있습니다.
