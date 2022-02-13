# 내가 풀이한 코드
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;
        for(int i = 0; i < arr1.length; i++)
        {
            for(int j = 0; j < arr2[0].length; j++)
            {
                sum = 0;
                for(int k = 0; k < arr1[i].length; k++)
                {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기
행렬의 곱셈이 가능하려면 arr1배열은 모든 행의 길이가 같은 직사각형 형태의 2차원 정방 행렬 배열이어야 합니다.<br><br>
arr2 배열도 마찬가지입니다.<br><br>
또한 arr1의 열의 길이와 arr2의 행의 길이가 같아야 서로 곱셈이 가능합니다.<br><br>
곱한 결과의 행렬 크기는 arr1의 행과 arr2의 열을 곱한 크기와 같습니다.<br><br>
그래서 곱한 결과를 담을 2차원배열인 answer를 행의 길이를 arr1.length로 정하고,<br><br>
열의 길이를 arr2의 열의 길이인 arr2[0].length로 정하여 생성합니다.<br><br>
i = 0부터 arr1의 길이보다 작은 동안 반복합니다.<br><br>
즉, arr1의 행의 길이만큼 반복을 합니다.<br><br>
반복문 내에서 다시 반복을 하는데 반복조건은 j = 0부터 arr2배열의 열의 길이보다 작은동안입니다.<br><br>
즉, arr2의 열의 길이만큼 반복을 합니다.<br><br>
arr1의 행과 arr2의 열을 곱한 값을 저장할 sum을 0으로 초기화해줍니다.<br><br>
k = 0부터 시작해서 arr1의 열의 길이보다 작은동안 반복합니다.<br><br>
반복문 내부에서는 arr1의 i번째의 k번째 배열요소와 arr2의 k번째의 j번째 배열요소를 곱한 값을 sum에 더하여 그 값을 누적시킵니다.<br><br>
arr1의 k는 열의 첨자에 쓰이고 arr2의 k는 행의 첨자에 쓰이면 성공적으로 행렬의 곱셈을 표현할 수 있습니다.<br><br>
sum에 누적된 값을 answer의 i번째의 j번째 배열요소에 저장합니다.
