# 다른 사람이 풀이한 코드
```java
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int row = board.length;
        int column = board[0].length;
        int[][] map = new int[row + 1][column + 1];
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < column; j++)
            {
                map[i + 1][j + 1] = board[i][j];
            }
        }
        for(int i = 1; i <= row; i++)
        {
            for(int j =1; j <= column; j++)
            {
                if(map[i][j] == 1)
                {
                    map[i][j] = Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1])) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        return answer * answer;
    }
}
```

# 다른 사람이 풀이한 코드 해석하며 공부하기

위 문제를 해결하기 위한 방법은 0행 0열부터 시작하는 것이 아니라 1행 1열부터 시작하는 것입니다.<br><br>
즉, i는 1부터 시작하여 board의 length길이(board의 행의 길이)보다 작거나 같은 동안 반복하고<br><br>
j도 1부터 시작하여 board의 0번째 행의 length 길이(board의 열의 길이)보다 작거나 같은 동안 반복을 합니다.<br><br>
i와 j에 위치한 값이 0이 아니면, 즉, 1이라는 전제조건이 필요합니다.<br><br>
즉, 예를 들어, 1행 1열이 0이면 0행 1열이나 0행 0열, 1행 0열의 값과 상관없이 정사각형을 만들 수 없습니다.<br><br>
그래서 i행 j열에 위치한 값이 1이면 왼쪽(i행 j-1열), 위쪽(i-1행 j열), 왼쪽대각선(i-1행 j-1열) 중에서 최소값에 1을 더한 값을 저장해줍니다.<br><br>
이러한 방식으로 채워나가면 정사각형의 한 변의 길이를 구할 수 있고, 이를 제곱하면 정사각형의 넓이를 구할 수 있습니다.<br><br>
다시 처음부터 코드를 설명하면<br><br>
먼저 정답을 저장할 answer는 0으로 초기화하고,<br><br>
row에는 board의 length길이(board의 행의 길이)를 저장하고, column에는 board의 0번째 행의 length 길이(board의 열의 길이)를 저장합니다.<br><br>
2차원 정수배열 map의 행의 길이를 row + 1 열의 길이를 column + 1로 하여 생성하는데 각 행과 열에 board의 행과 열의 길이보다 +1을 해주는 이유는<br><br>
만약에 map의 행과 열의 길이가 board의 행과 열의 길이와 같다면 board의 행의 길이가 1이거나 열의 길이가 1인 극단적인 경우에는<br><br>
1행 1열부터 접근하는 방법이 불가능하기 때문입니다.<br><br>
그래서 처음부터 board의 행과 열의 길이보다 각각 +1 크게 설정하면 위와 같은 극단적인 경우에도 1행 1열에 접근하여 계산할 수 있습니다.<br><br>
map의 1행 1열부터 시작하여 board의 모든 원소를 그대로 옮깁니다.<br><br>
map의 1행 1열부터 시작하여 아까 말한것처럼 최소값을 구하고,<br><br>
그 최소값에 1을 더한 값을 map의 i행 j열에 저장합니다.<br><br>
Math.max를 통해 answer와 map의 i행 j열 중에 더 큰 값을 answer에 갱신해줍니다.<br><br>
이렇게 answer에 max값을 갱신해놓으면 길이가 9인 정사각형을 먼저 구하고 나중에 길이가 4인 정사각형을 구하더라도<br><br>
answer에는 최대값이 9가 저장되어 있고 나중에 계산된 4는 skip하게 됩니다.<br><br>
그렇게 처음부터 마지막까지 정사각형 길이를 다 비교하여<br><br>
반복이 끝나면 answer에는 최대정사각형의 길이가 저장되기 떄문에 이를 제곱하여 반환하면 됩니다.

# 느낀 점

항상 처음(0행 0열)부터 시작해야 한다는 생각을 버리고 다음(1행 1열)부터 시작하여<br><br>
0행 0열로 돌아가서 계산을 할 수도 있다는 유연한 생각을 가져야겠습니다.<br><br>
또한 예외케이스를 생각해서 그것을 조건문으로 처리하기보다는 차라리 크기를 1을 늘려서 새로 만들면<br><br>
예외처리를 해줄 필요가 없다는 것도 명심해야겠습니다.<br><br>
그리고 다시 한번 최대값과 최소값을 구할 때는 Math의 max와 min을 최우선적으로 생각하고,<br><br>
여러 수일 때도 Math의 max와 min을 사용해 최대값과 최소값을 구할 수 있다는 것을 명심해야겠습니다.
