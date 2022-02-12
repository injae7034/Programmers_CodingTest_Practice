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
