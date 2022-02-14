# 다른 사람이 푼 코드

```java
class Solution {
    public int solution(int n) {
        //자연수 n을 2진수로 바꿨을 때 1의 개수를 센다.
        int oneCount = Integer.bitCount(n);
        //n보다 다음 큰 숫자를 2진수로 바꿨을 때 1의 개수가 같지 않은 동안 반복한다.
        n++;
        while(Integer.bitCount(n) != oneCount)
        {
            n++;
        }
        return n;
    }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

먼저 Integer클래스이 정적메소드인 bitCount를 이용하여 자연수 n을 이진수로 바꿨을 때<br><br>
1의 개수를 반환받아서 oneCount에 저장합니다.<br><br>
그런 다음 n에서 +1을 증가시킨 값을 저장하고<br><br>
n을 2진수로 변경했을 때 1의 개수를 구한 값이 oneCount와 같은 동안 반복을 합니다.<br><br>
반복문 내부에서 n의 값을 1 증가시켜 줍니다.<br><br>
반복문이 끝나면 n은 문제에서 제시한 다음 큰 수가 되어 있고, 이를 반환합니다.<br><br>

# 느낀 점

기존에 주어진 수에서 문제의 기준에 맞게 변경을 하려다 보니 굉장히 까다로웠는데<br><br>
이럴 때는 발상의 전환을 통해 변경보다는 새로 만드는게 더 쉬울 수도 있다는 것을 명심해야겠습니다.
