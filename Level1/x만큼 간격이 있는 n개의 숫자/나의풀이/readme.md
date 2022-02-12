# 내가 풀이한 코드

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][];
        for(int i = 0; i < arr1.length; i++)
        {
            answer[i] = new int[arr1[i].length];
            for(int j = 0; j < arr1[i].length; j++)
            {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

매개변수로 입력 받는 arr1과 arr2는 덧셈을 하기 위해서는 행과 열의 길이가 같아야 합니다.<br><br>
즉, arr1과 arr2 중 하나의 배열의 행과 열의 길이에 answer를 맞추면 된다는 말입니다.<br><br>
일단 먼저 answer의 행 성분을 생성하는데 arr1의 length만큼 힙에 할당합니다.<br><br>
다음으로 i = 0부터 arr1의 length보다 작은동안 반복합니다.<br><br>
이 반복문 내부에서 arr1의 i번째 배열요소의 길이만큼 answer의 열 성분을 생성하여 힙에 할당합니다.<br><br>
다시 반복문으로 j = 0부터 arr1의 i번째 배열요소의 길이보다 작은동안 반복합니다.<br><br>
answer의 i의 j번째 배열요소에 arr1과 arr2의 i의 j번째 배열요소를 더한 값을 저장합니다.<br><br>
