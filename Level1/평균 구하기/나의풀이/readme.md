# 내가 풀이한 코드

```java
class Solution {
    public int solution(int num) {
        long number = num;
        int answer = 0;
        while(number > 1 && answer < 500)
        {
            if(number % 2 == 0)
            {
                number /= 2;
            }
            else
            {
                number = number * 3 + 1;
            }
            answer++;
        }
        if(number > 1)
        {
            answer = -1;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

처음 입력받은 수가 홀수인데 int의 마지막 범위에 있는 수라면<br><br>
곱하기 3을 했을 때 int의 범위를 벗어나기 때문에 제대로 된 결과를 얻을 수 없습니다.<br><br>
이를 방지하기 위해 num을 long 자료형인 number에 저장합니다.<br><br>
answer의 초기값은 0으로 설정하고, while반복을 하는데<br><br>
반복조건문은 number가 1보다 큰 동안 그리고 answer가 500보다 작은 동안 반복합니다.<br><br>
반복문 내부에서 number를 2로 나눈 나머지가 0이면 짝수이기 때문에 number를 2로 나눈 몫을 number에 저장하고<br><br>
나머지가 0이 아니면 홀수이기 때문에 number에 3을 곱한 값에 1을 더해준 값을 number에 저장합니다.<br><br>
그리고 1회시도 했기 때문에 answer의 값을 1 증가시켜줍니다.<br><br>
이렇게 500번을 반복하는데 도중에 number가 1이 되면 반복문을 빠져나와 선택문으로 갔을 때 number가 1이기 때문에<br><br>
누적됫 시도횟수 answer를 그대로 반환합니다.<br><br>
만약에 500번을 시도할 때까지 number가 1이 되지 않는다면<br><br>
answer는 500이기 때문에 while반복문을 벗어나고,<br><br>
number가 여전히 1보다 크기 때문에 선택문에서 answer에 -1을 저장해준 다음 이 값을 반환합니다.
