# 내가 풀이한 코드

```java
import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int i = 0;
        while(i < d.length && budget >= 0)
        {
            budget -= d[i];
            answer++;    
            i++;            
        }
        if(budget < 0)
        {
            answer--;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

먼저 Arrays클래스의 정적메소드인 sort를 통해 매개변수로 입력 받은 정수형 배열 d를 오름차순으로 정렬해줍니다.<br><br>
오름차순으로 정렬하면 예산이 작은 부서부터 시작하여 마지막에는 예산이 가장 큰 부서가 위치하게 될 것입니다.<br><br>
주어진 budget에는 제한이 있고, 최대한 많은 부서에 지원을 해주는 것이 목표이기 때문에<br><br>
예산이 작은 부서부터 차례대로 지원을 해주면 최대한 많은 부서에 지원해줄 수 있고<br><br>
이것이 문제에서 원하는 최대값입니다.<br><br>
while반복문을 이용하여 i = 0부터 시작하여 배열 d의 길이보다 작은동안<br><br>
그리고 budget이 0보다 크거나 같은 동안 반복을 합니다.<br><br>
반복문 내부에서 budget을 d의 i번째 배열요소로 빼준 값을 누적시킵니다.<br><br>
그리고 answer의 값은 0부터 시작하는데 +1한 값을 누적시켜줍니다.<br><br>
그리고 배열첨자 i를 +1해줍니다.<br><br>
반복문이 끝나고 나서 budget이 음수인지 확인합니다.<br><br>
budget이 양수 또는 0이라면 budget으로 배열 d의 모든 예산을 지원했다는 뜻이고,<br><br>
별도의 처리는 필요없습니다.<br><br>
그러나 budget이 음수라면 budget으로 배열 d의 모든 예산을 지원하지 못했다는 뜻이고,<br><br>
budget이 음수일 때 증가시켰던 answer를 다시 -1 감소시켜줍니다.<br><br>
이 후 answer에는 예산을 지원할 수 있는 최대값이 저장되어 있고 이를 반환하면 됩니다.
