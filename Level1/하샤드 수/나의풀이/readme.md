# 내가 풀이한 코드

```java
class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        int number = x;
        while(number > 0)
        {
            sum += number % 10;
            number /= 10;
        }
        if(x % sum == 0)
        {
            answer = true;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

answer의 디폴트값을 false로 초기화합니다.<br><br>
sum의 디폴트값을 0으로, number의 디폴트값은 매개변수로 입력 받은 x로 초기화합니다.<br><br>
number가 0보다 큰 동안 반복합니다.<br><br>
sum에 number를 10으로 나눈 나머지값을 더해줍니다.<br><br>
number를 10으로 나눈 몫을 number에 저장합니다.<br><br>
이렇게 반복을 하면 sum에는 number의 각 자리수의 합이 저장됩니디.<br><br>
이제 x를 sum으로 나눈 몫이 0이면 answer를 true로 바꿔준 다음 answer를 반환하고<br><br>
그게 아니면 answer에 그대로 false를 담은 채로 반환합니다.
