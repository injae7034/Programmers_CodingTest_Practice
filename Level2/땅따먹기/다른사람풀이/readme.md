# 다른 사람이 풀이한 코드
```java
import java.util.Arrays;

class Solution {  
   public int solution(int[][] land) {
       for(int i = 1; i < land.length; i++)
       {
           land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
           land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
           land[i][2] += Math.max(Math.max(land[i-1][1], land[i-1][0]), land[i-1][3]);
           land[i][3] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][0]);
       }
       int[] answer = land[land.length - 1];
       Arrays.sort(answer);
       return answer[answer.length - 1];
   }
}
```

# 다른 사람이 풀이한 코드 해석하며 공부하기

첫번째 행부터 최대값을 구해서 더해가면 문제에서 원하는 최대값을 구할 수 없습니다.<br><br>
2번째 행부터 시작해서 첫번째행에서 최대값을 구한 다음 더해줘서 누적시켜줘야 원하는 최대값을 구할 수 있습니다.<br><br>
왜냐하면 만약에 첫번째 행이 1, 2, 3, 4 이고 두번째 행이 4, 3, 2, 100이면 누가봐도 2번째 행의 100을 선택해야하지만<br><br>
첫번째 행에서 이미 최대값이 4를 선택했기 때문에 2번째 행에서 100을 선택할 수 없어서 문제에서 제시한 최대값을 구할 수 없습니다.<br><br>
그래서 두번째 행을 기준으로 자신이 취할 수 있는 첫번째 행의 최대값(4 또는 3)을 더해줘서 두번째 값에 누적시키면<br><br>
두번째 행은 8 = 4 + 4, 7 = 3 + 4, 6 = 2 + 4, 103 = 100 + 3 이 됩니다.<br><br>
세번째 행이 있다면 세번째 각 행의 열 값에 2번째 행에 누적된 열의 값 중 최대값을 구하여 더해주면 됩니다.<br><br>
예시를 통한 풀이를 해보갰습니다.<br><br>
1, 2, 3, 4<br>
4, 3, 2, 100<br>
9, 9, 8 ,7<br>
1, 1, 1, 1<br>
이렇게 2차원배열 land가 주어지면<br><br>
두번째 행의 1번째 열 4는 첫번째 행의 열 1을 제외하고 첫번째 행의 최대값인 4를 더해주면 됩니다.<br><br>
두번째 행의 2번째 열 3은 첫번째 행의 열 2을 제외하고 첫번째 행의 최대값인 4를 더해주면 됩니다.<br><br>
두번째 행의 3번째 열 2는 첫번째 행의 열 3를 제외하고 첫번째 행의 최대값인 4를 더해주면 됩니다.<br><br>
두번째 행의 4번째 열 100은 첫번째 행의 열 4를 제외하고 첫번째 행의 두번째 큰 값인 3을 더해주면 됩니다.<br><br>
1, 2, 3, 4<br>
8, 7, 6, 103<br>
9, 9, 8 ,7<br>
1, 1, 1, 1<br>
세번째 행의 1번째 열 9는 두번째 행의 열 1을 제외하고 두번째 행의 최대값인 103을 더해주면 됩니다.<br><br>
세번째 행의 2번째 열 9는 두번째 행의 열 2을 제외하고 두번째 행의 최대값인 103을 더해주면 됩니다.<br><br>
세번째 행의 3번째 열 8은 두번째 행의 열 3를 제외하고 두번째 행의 최대값인 103을 더해주면 됩니다.<br><br>
세번째 행의 4번째 열 7은 두번째 행의 열 4를 제외하고 두번째 행의 두번째 큰 값인 8을 더해주면 됩니다.<br><br>
1, 2, 3, 4<br>
8, 7, 6, 103<br>
112, 112, 111 ,15<br>
1, 1, 1, 1<br>
네번째 행의 1번째 열 112는 세번째 행의 열 1을 제외하고 세번째 행의 최대값인 112를 더해주면 됩니다.<br><br>
네번째 행의 2번째 열 112는 세번째 행의 열 2을 제외하고 세번째 행의 최대값인 112를 더해주면 됩니다.<br><br>
네번째 행의 3번째 열 111은 세번째 행의 열 3를 제외하고 세번째 행의 최대값인 112를 더해주면 됩니다.<br><br>
네번째 행의 4번째 열 15는 세번째 행의 열 4를 제외하고 세번째 행의 두번째 큰 값인 111을 더해주면 됩니다.<br><br>
1, 2, 3, 4<br>
8, 7, 6, 103<br>
112, 112, 111 ,15<br>
113, 113, 113, 1112<br>
따라서 최대값은 113이 됩니다.

# 느낀 점

n번째의 최대값을 구하기 위해 보통은 n-1번부터 선택하며 n번째로 가는데<br><br>
그러한 방식으로는 문제에서 정답을 찾을 수 없습니다.<br><br>
발상의 전환을 하여 **n번째에 n-1번째의 최대값을 더해서 누적시키는 방식**으로 하면 손쉽게 최대값을 구할 수 있습니다.<br><br>
또한 **land에 덧셈의 결과를 계속해서 누적**시켜 나가면 더 쉽게 답을 구할 수 있다는 생각을 전혀 하지 못했서<br><br>
따로 덧셈의 결과들을 저장할 배열을 만들 생각이었는데 이게 쉽지 않아서 문제를 해결하지 못했습니다.<br><br>
일단 떠오른 문제 풀이로 문제가 잘안풀릴때는 계속 어려운 방식을 고수하기보다는 다른 새로운 방식이 없는지 항상 고민해봐야겠습니다.<br><br>
그리고 **두 수 중 더큰수를 고를때만 Math.max를 이용하는 것이 아니라 수가 여러 개라도 위와 같은 표현으로 Math.max를 여러번 사용하면<br><br>
여러 수들 중에서도 최대값**을 구할 수 있습니다.<br><br>
그래서 최대값을 구하거나 최소값을 구할 때는 일단 최우선적으로 Math의 max나 min을 사용하도록 해봐야겠습니다.
