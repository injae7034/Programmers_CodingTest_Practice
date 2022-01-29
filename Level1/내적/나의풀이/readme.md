# 내가 푼 코드
```java
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++)
        {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명
매개변수로 입력받는 1차원 정수배열인 a와 b의 길이는 같고,<br><br>
두 배열요소들을 순차적으로 구하여 그 합을 누적시키면 내적을 구할 수 있습니다.<br><br>
그래서 for 반복문을 통해 a와 b의 첫 배열요소부터 마지막 배열요소까지 순차적으로 곱하면서<br><br>
그 값을 누적시키면 반복문이 끝나고 나서 내적을 구할 수 있습니다.
