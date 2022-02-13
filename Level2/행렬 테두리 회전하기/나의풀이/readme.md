# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        //matrix 생성 및 초기화
        int[][] matrix = new int[rows][columns];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        //queries의 모든 값을 -1해주기(배열첨자와 동일하게 맞추기)
        for(int i = 0; i < queries.length; i++)
        {
            for(int j = 0; j < queries[i].length; j++)
            {
                queries[i][j]--;
            }
        }
        int[] answer = new int[queries.length];
        List<Integer> list = null;
        int index = 0;
        Integer last = null;
        for(int i = 0; i < queries.length; i++)
        {
            //회전시킬 수를 ArrayList에 담기
            list = new ArrayList<>();
            for(int j = queries[i][1]; j <= queries[i][3]; j++)
            {
                list.add(matrix[queries[i][0]][j]);
            }
            for(int j = queries[i][0] +1; j <= queries[i][2]; j++)
            {
                list.add(matrix[j][queries[i][3]]);
            }
            for(int j = queries[i][3] - 1; j >= queries[i][1]; j--)
            {
                list.add(matrix[queries[i][2]][j]);
            }
            for(int j = queries[i][2] - 1; j > queries[i][0]; j--)
            {
                list.add(matrix[j][queries[i][1]]);
            }
            //시계방향으로 한 칸씩 회전시키기
            last = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, last);
            index = 0;
            for(int j = queries[i][1]; j <= queries[i][3]; j++)
            {
                matrix[queries[i][0]][j] = list.get(index);
                index++;
            }
            for(int j = queries[i][0] +1; j <= queries[i][2]; j++)
            {
                matrix[j][queries[i][3]] = list.get(index);
                index++;
            }
            for(int j = queries[i][3] - 1; j >= queries[i][1]; j--)
            {
                matrix[queries[i][2]][j] = list.get(index);
                index++;
            }
            for(int j = queries[i][2] - 1; j > queries[i][0]; j--)
            {
                matrix[j][queries[i][1]] = list.get(index);
                index++;
            }
            //회전시킨 수 중에 최소값을 저장하기
            answer[i] = Collections.min(list);
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명하기

먼저 매개변수로 입력 받은 rows와 columns 크기에 맞게 행렬로 사용될 2차원 정수 배열 matrix를 생성합니다.<br><br>
행의 크기는 rows, 열의 크기는 columns에 맞게 생성합니다.<br><br>
다음으로 matrix의 각 배열요소에는 현재 0이 저장되어 있는데 문제에서 제시한대로<br><br>
행단위로 이동할때는 columns만큼 더해주고 열단위로 이동할 때는 +1을 해주는 방식으로 초기화해주기 위해서 반복을 이용합니다<br><br>
먼저 i = 0부터 matrix의 길이만큼 반복을 하고, 다시 j = 0부터 matrix의 i번째 배열요소(1차원배열)의 길이만큼 반복을 합니다.<br><br>
반복문 내부에서 matrix의 i번째 배열요소의 j번째 배열요소의 값을 i 곱하기 columns에 더하기 j 더하기 1을 해줍니다.<br><br>
이렇게 하면 문제에서 제시한대로 행렬을 초기화할 수 있습니다.<br><br>
매개변수로 입력 받은 querries도 2차원 정수 배열인데 여기에 저장된 값은 matrix행렬에서 회전시킬 행과 열의 위치를 저장하고 있습니다.<br><br>
그러나 배열은 0부터 시작인데 querries의 배열요소의 값들은 1부터 시작이라서 이 값을 맞춰주기 위해<br><br>
matrix의 값을 초기화할 때 처럼 2중반복을 하여 querries의 모든 원소들의 값을 -1시켜줍니다.(배열첨자처럼 0부터 시작하게 맞춰줌)<br><br>
이 후 정답을 저장할 1차원 정수 배열인 answer를 querries의 길이만큼 힙에 할당합니다.<br><br>
다음으로 i = 0부터 querries의 길이보다 작은 동안 반복을 합니다.<br><br>
반복문 내부에서 회전시킬 수들을  ArrayList의 객체 list를 생성합니다.<br><br>
시계방향으로 즉 처음에는 왼쪽에서 오른쪽으로, querries의 행은 회전을 시작하는 행 위치(queries[i][0])에 그대로 두고<br><br>
열의 값을 하나씩 증가시키면서(j = queries[i][1]부터  queries[i][3]보다 작거나 같은동안 반복하면서 1씩 증가시킴)<br><br>
이 querries의 값(matrix의 배열요소의 위치)을 바탕으로 matrix의 원소들을 ArrayList에 add합니다.<br><br>
j가  queries[i][3]보다 커지면 회전이 끝나는 열의 위치를 벗어난 것이기 때문에 더이상 열을 증가시키지 않고<br><br>
행을 변경시키기 위한 다음 반복으로 넘어갑니다.<br><br>
querries의 열의 위치는 queries[i][3]으로 고정시키고 행을 하나씩 증가시킵니다.<br><br>
j = queries[i][0] +1부터 시작해서 queries[i][2]보다 작거나 같은동안 반복하면서 j를 1씩 증가시킵니다.<br><br>
그러면서 반복문 내부에서 이 querries의 값(matrix의 배열요소의 위치)을 바탕으로 matrix의 원소들을 ArrayList에 add합니다.<br><br>
이렇게 이동하면 이제 회전하는 행과 열의 마지막으로 이동되었습니다.<br><br>
이제 행은 다시 queries[i][2]로 고정하고 열을 감소시킵니다.<br><br>
j = queries[i][3] - 1부터 시작해서 j가  queries[i][1]보다 크거나 같은 동안 반복을 하면서 j를 1씩 감소시킵니다.<br><br>
반복문 내부에서는 계속해서 matrix값들을 list에 add합니다.<br><br>
이제 열은 다시 시작위치로 왔고 마지막으로 행을 다시 시작위치로 돌리면 회전이 마무리 됩니다.<br><br>
열은 queries[i][1]로 고정시키고, j = queries[i][2] - 1부터 시작해서 queries[i][0]보다 큰 동안 반복을 하면서 j를 -1씩 감소시켜줍니다.<br><br>
이렇게 회전이 끝나고 나면 ArrayList의 객체 list에는 matrix의 원소들 중에서 회전해야할 원소들의 값이 저장되어 있습니다.<br><br>
시계방향으로 한 칸씩 이동하면 되기 때문에 list에서 제일 마지막 원소의 값을 get하여 저장합니다.<br><br>
그리고 list에서 제일 마지막에 위치한 원소를 remove합니다.<br><br>
그리고 아까 저장한 제일 마지막 원소의 값을 list의 제일 처음 위치에 다시 add해줍니다.<br><br>
그 후 아까 회전하는 방식과 동일한 반복구조 방식으로 반복을 돌리면서 list의 원소들을 matrix의 배열요소에 저장합니다.<br><br>
반복이 끝나면 matrix의 원소들은 성공적으로 시계 방향으로 한 칸씩 이동되어 있습니다.<br><br>
여기서 이동한 수들 중에 최소값을 구하기 위해 Collections의 min메소드에 list를 매개변수로 주어 최소값을 answer의 i번째 배열요소에 저장합니다.<br><br>
모든 반복이 끝나면 answer에는 회전한 횟수만큼 최소값들이 저장되어 있습니다.
