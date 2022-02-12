# 내가 풀이한 코드

```java
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int i = 0; i < arr.length; i++)
        {
            answer += arr[i];
        }
        answer /= arr.length;
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

answer에 arr의 모든 원소의 값을 더하여 누적시킵니다.<br><br>
이 값을 arr의 배열의 길이로 나눠주면 평균값을 구할 수 있습니다.
