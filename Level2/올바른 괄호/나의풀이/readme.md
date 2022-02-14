# 내가 풀이한 코드
```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            sum = 0;
            index = i + 1;
            while(index <= n && sum < n)
            {
                sum += index;
                index++;
            }
            if(sum == n)
            {
                answer++;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기
i = 0부터 시작해서 n보다 작은 동안 반복합니다.<br><br>
즉, n회 반복합니다.<br><br>
반복문 내부에서 sum과 index를 각각 0과 i + 1로 초기화해줍니다.<br><br>
연속되는 자연수의 합으로 표현이 되는지 확인하는 것이기 때문에<br><br>
index는 i + 1부터 시작하여 n보다 작거나 같은 동안 반복합니다.<br><br>
그리고 연속되는 자연수의 합이 n을 넘어버리면 의미가 없기 때문에 sum이 n보다 작은동안 반복해야 합니다.<br><br>
반복문아 끝났을 때 sum이 n과 같은지 물어보고 같다면 answer를 증가시키고<br><br>
같지 않다면 i를 1증가시켜 다음 연속하는 자연수의 합이 n과 같은지 구하러 갑니다.
