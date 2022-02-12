# 내가 풀이한 코드

```java
class Solution {
    public long solution(long n) {
        double root = Math.sqrt(n);
        long answer = 0;
        if(root - (int)root == 0)
        {
            answer = (long)root + 1;
            answer *= answer;
        }
        else
        {
            answer = -1;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 n에 Math의 정적메소드인 sqrt를 호출하여 제곱근을 구합니다.<br><br>
제곱근이 정수라면 double자료형인 root를 int로 형변환한 값을 자기자신에게 빼줬을 때<br><br>
0이 나와야 하는데 0이면 정수라는 뜻이기 때문에 root + 1한 값을 제곱한 값을 answer에 저장합니다.<br><br>
0이 아니라면 제곱근이 정수가 아니라는 뜻이기 때문에 answer에 -1을 저장해줍니다.
