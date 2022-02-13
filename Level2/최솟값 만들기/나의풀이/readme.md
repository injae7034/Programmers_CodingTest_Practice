# 내가 풀이한 코드
```java
import java.util.Arrays;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        for(int i  = 0; i < A.length; i++)
        {
            answer += A[i] * B[A.length - 1 - i];
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기
매개변수로 주어진 A와 B의 길이는 같고 각 원소들의 곱한 값을 더했을 때 최솟값을 구하는 방법은<br><br>
A의 원소중 최대값과 B의 원소중 최솟값을 곱하는 방법입니다.<br><br>
이를 위해 A와 B를 Arrays의 sort메소드를 이용해 오름차순으로 정렬합니다.<br><br>
그리고 i = 0부터 시작하여 A의 length보다 작은동안 반복을 합니다.<br><br>
A는 원래 순서대로 배열요소를 구하고, B는 거꾸로 마지막부터 원소를 구하면 내림차순으로 구하는 것과 같습니다.<br><br>
즉, 이렇게 하면 A의 최솟값과 B의 최대값을 곱하게 됩니다.<br><br>
그 결과 A와 B의 원소들의 곱을 더한 최솟값을 구할 수 있습니다.
