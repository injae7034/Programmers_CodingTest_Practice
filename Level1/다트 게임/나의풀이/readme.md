# 내가 풀이한 코드

```java
import java.util.StringTokenizer;

class Solution {
    public int solution(String dartResult) {
        StringTokenizer scoreTokens = new StringTokenizer(dartResult, "SDT*#");
        int[] scores = new int[]{0, Integer.parseInt(scoreTokens.nextToken()),
                Integer.parseInt(scoreTokens.nextToken()),
                Integer.parseInt(scoreTokens.nextToken())};
        StringTokenizer bonusTokens = new StringTokenizer(dartResult, "012345678910*#");
        String[] bonuses = new String[]{"", bonusTokens.nextToken(), bonusTokens.nextToken(),
                bonusTokens.nextToken()};
        String[] options = new String[]{"", "", "", ""};
        for(int i = 1; i < options.length; i++)
        {
            dartResult = dartResult.substring(dartResult.indexOf(bonuses[i]) + 1);
            if(dartResult.compareTo("") != 0 &&
                    (dartResult.charAt(0) == '*' || dartResult.charAt(0) == '#'))
            {
                options[i] = String.valueOf(dartResult.charAt(0));
            }
        }
        for(int i = 1; i < scores.length; i++)
        {
            if(bonuses[i].compareTo("D") == 0)
            {
                scores[i] *= scores[i];
            }
            else if(bonuses[i].compareTo("T") == 0)
            {
                scores[i] = scores[i] * scores[i] * scores[i];
            }
            if(options[i].compareTo("*") == 0)
            {
                scores[i - 1] *= 2;
                scores[i] *= 2;
            }
            else if(options[i].compareTo("#") == 0)
            {
                scores[i] *= -1;
            }
        }
        return scores[1] + scores[2] + scores[3];
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 문자열 dartResult에서 StringTokenizer클래스의 객체 scoreTokens를 생성할 때<br><br>
"S", "D", "T", "\*" "\#"를 제외하고 숫자만 scoreTokens에 저장하도록 합니다.<br><br>
정수형 배열 scores를 생성할 때 원소로 첫번째는 0,<br><br>
나머지 3개는 scoreTokens의 nextToken을 호출하여 점수 문자열을 반환받은 값을 정수로 바꾼 값을 저장합니다.<br><br>
첫번째 원소를 굳이 0으로 두는 이유는 나중에 옵션에서 "\*"일 때 현재 다트 점수와 이전 다트 점수를 2배 곱해줘야 하는데<br><br>
만약에 첫번째 다트 점수에서 옵션이 "\*"인 경우에 indexOutofBoundsException이 발생하는데<br><br>
이를 막기 위해 선택문으로 예외처리를 해줘야하기 때문에 애초에 처음 배열원소를 0으로 해놓으면<br><br>
나중에 반복문에서 첫번째 원소에 2를 곱해도 그 값이 0이기 때문에 상관이 없어서 별도로 조건을 만들 필요가 없어집니다.<br><br>
두번째는 StringTokenizer의 객체 bonusTokens를 생성할 때 0 ~ 10사이 정수와 "\*", "\#"을 제외한 보너스를 저장하도록 합니다.<br><br>
문자열 배열 bonuses에도 반복문에서 scores와 배열첨자의 위치를 맞추기 위해 첫 배열원소는 ""을 저장하고,<br><br>
나머지는 bonusTokens의 nextToken을 호출하여 반환받은 문자열을 저장합니다.<br><br>
문자열 배열 options는 일단 4개의 배열원소를 모두 ""으로 초기화합니다.<br><br>
이유는 option의 경우 있을수도 있고, 없을 수도 있기 때문입니다.<br><br>
다음으로 i = 1부터 시작하여 options 배열의 길이보다 작은 동안 반복을 하면서 각 option의 값을 구합니다.<br><br>
indexOf을 이용하여 dartResult에서 bonuses의 i번째 배열요소의 위치를 찾아서<br><br>
그 위치에 +1한 위치부터 마지막문자까지 substring을 통해 dartResult를 자릅니다.<br><br>
자른 후에 dartResult가 공백이 아니고, 즉, 문자가 남아있고, 첫번째 문자가 "\*" 또는 "\#"인 경우<br><br>
options의 i번째 배열요소에 그 값을 저장합니다.<br><br>
반복이 끝나면 options의 각 배열요소에는 "" 또는 "\*" 또는 "\#"이 저장되어 있습니다.<br><br>
다시 i = 1부터 시작하여 scores의 length보다 작은동안 반복합니다.<br><br>
bonuses의 i번째 배열요소가 "S"인 경우는 고려할 필요가 없고<br><br>
"D"인 경우 scorese의 i번째 배열요소를 제곱해주고,<br><br>
"T"인 경우는 세제곱해줍니다.<br><br>
options의 i번째 배열요소가 "\*"인 경우 scores의 i - 1번째 배열요소의 값에 2를 곱해주고,<br><br>
i번째 배열요소의 값에도 2를 곱해줍니다.<br><br>
options의 i번째 배열요소가 "\#"인 경우 scores의 i번째 배열요소에 -1을 곱해줍니다.<br><br>
반복이 끝나면 scores[1]과 scores[2]와 scores[3]에는 보너스와 옵션을 고려한 점수가 저장되어 있으므로 이 3개의 원소를 더한 값을 반환합니다.
