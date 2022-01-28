# 내가 쓴 코드

```java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++)
        {
            if(signs[i] == true)
            {
                answer += absolutes[i];
            }
            else
            {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
```

# 내가 쓴 코드 설명

absolutes에 있는 숫자의 부호 위치가 signs에 있고,<br><br>
이들의 순서는 정확하게 같은 배열첨자위치를 가지고 있습니다.<br><br>
그래서 absolutes의 크기만큼 처음부터 끝까지 반복을 돌리면서<br><br>
signs의 값이 true이면 answer에 +값을 해주고,<br><br>
signs의 값이 false이면 answer에 -값을 해주면<br><br>
반복이 끝나고 나면 answer에는 음양을 더한 값이 누적되어 있습니다.
