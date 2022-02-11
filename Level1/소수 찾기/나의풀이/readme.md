# 내가 풀이한 코드

```java
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isPrimeNumber = true;
        for(int i = 2; i <= n; i++)
        {
            isPrimeNumber = true;
            for(int j = 2; j * j <= i; j++)
            {
                if(i % j == 0)
                {
                    isPrimeNumber = false;
                    break;
                }
            }
            if(isPrimeNumber == true)
            {
                answer++;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

입력 받은 정수형 매개변수 n이 소수인지 아닌지 판단하기 위한 boolean변수 isPrimeNumber를 true로 초기화합니다.<br><br>
i = 2부터 시작하여 n보다 작거나 같은 동안 반복합니다.<br><br>
반복문 내부에서 항상 isPrimeNumber를 true로 초기화해줍니다.<br><br>
다시 반복을 하여 j = 2부터 j 제곱이 i보다 작거나 같은 동안 반복합니다.<br><br>
j를 제곱하는 이유는 약수의 약수를 구하려는 수의 중간 약수값이 얼추 약수를 구하려는 수에 루트를 씌운 값과 비슷합니다.<br><br>
즉 약수의 중간까지만 조사하면 약수의 중간이후는 앞에서 조사한 약수와 쌍을 이루는 것이기에 더이상 조사할 필요가 없습니다.<br><br>
그래서 소수인지 판별하기 위해서는 약수의 중간위치까지만 검사하면 됩니다.<br><br>
근데 이 값이 약수를 구하려는 수에 루트를 씌운 값이기 때문에 j는 루트 i보다 작거나 같은동안 반복하면 됩니다.<br><br>
가독성을 위해 양변을 제곱하면 j는 제곱이 되고 루트 i는 i가 됩니다.<br><br>
이러한 방법으로 반복을 돌리면 필요없는 항목은 검사를 제외할 수 있기 때문에 속도가 향상됩니다.<br><br>
반복문 내부에서 i를 j로 나눈 나머지가 0인지 확인하고, 0이면 isPrimeNumber에 false를 저장하고 반복문을 벗어납니다.<br><br>
하나라도 약수가 있다면 더이상 소수가 아니기 때문에 나머지는 더 검사할 필요기 없기 때문에 break로 반복을 벗어납니다.<br><br>
나머지가 0이 아니라면 반복문에서 다음 수로 넘어가서 계속 검사합니다.<br><br>
j를 사용하는 반복문이 끝나면 isPrimeNumber가 true인지 확인하여 소수가 맞다면 answer를 증가시키고, i반복의 조건문으로 가고,,<br><br>
isPrimeNumber가 false이면 바로 i반복의 조건문으로 갑니다.
