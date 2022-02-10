# 내가 풀이한 코드

```java
class Solution {
    public int solution(int[][] sizes) {
        //명함의 가로길이와 세로길이를 비교
        int temp = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            //명함의 세로 길이가 가로 길이보다 더크면
            if(sizes[i][0] < sizes[i][1])
            {
                //명함의 가로 길이와 세로 길이를 바꾼다.
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        //명함의 가로 길이와 세로 길이의 최대 길이 구하기
        int maxWidth = 0;
        int maxHeight = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            if(sizes[i][0] > maxWidth)
            {
                maxWidth = sizes[i][0];
            }
            if(sizes[i][1] > maxHeight)
            {
                maxHeight = sizes[i][1];
            }
        }
        return maxWidth * maxHeight;
    }
}
```

# 내가 풀이한 코드 설명하기

첫단계는 명함의 가로 길이와 세로 길이를 비교하여<br><br>
가로 길이가 더 크면 그대로 두고,<br><br>
세로 길이가 더 크면 가로 길이와 세로 길이의 값을 서로 바꾸는 단계입니다.<br><br>
교환을 위해 임시로 값을 저장할 temp변수를 선언하고,<br><br>
i = 0부터 sizes의 배열요소(1차원배열)의 개수보다 작은동안 반복합니다.<br><br>
반복문 내부에서 sizes의 배열요소인 1차원배열에 접근하여<br><br>
가로 길이와 세로 길이를 비교하여<br><br>
세로 길이가 가로 길이보다 더 크면<br><br>
가로 길이의 값과 세로 길이의 값을 temp를 이용하여 바꿉니다.<br><br>
값을 바꾸고 나면 전체 명함의 가로 길이에는<br><br>
각 명함의 가로와 세로 중 더 큰 길이가 저장되어 있을 것입니다.<br><br>
다시 i = 0부터 sizes의 길이보다 작은 동안 반복을 하면서<br><br>
가로 길이의 최대값을 구하고, 세로 길이의 최대값을 구합니다.<br><br>
다음으로 둘의 곱을 반환합니다.
