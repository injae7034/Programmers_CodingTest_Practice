# 다른 사람이 푼 코드

```java
class Solution {
  public long solution(long n) {
      if (Math.pow((int)Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
  }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

매개변수로 입력 받은 n에 Math의 정적메소드인 sqrt를 호출하여 제곱근을 구합니다.<br><br>
그리고 Math의 pow를 메소드를 호출하여 아까 구한 제곱근을 int로 형변환한 값과 2를 넣어준 값이 n과 같은지 확인합니다.<br><br>
Math.sqrt의 반환값은 double인데 int로 형변환을 하게 되면 뒤에 소수부분은 잘리게 됩니다.<br><br>
Math.sqrt의 반환값이 정수라면 뒤에 소수가 어차피 0이기 때문에 뒤에 소수부분이 잘려도 이 값을 제곱했을 때 n이 나올 것입니다.<br><br>
반대로 Math.sqrt의 반환값이 실수라면 뒤에 소수가 0이 아니기 때문에 뒤에 소수부분이 잘리면 이 값을 제곱했을 때 n이 나오지 않을 것입니다.<br><br>
이러한 방식으로 n의 제곱근이 정수인지 실수인지 판별하여 n의 제곱근이 정수이면 그 제곱근 값에 1을 더해주고 다시 제곱한 값을 반환하고,<br><br>
n의 제곱근이 실수이면 -1을 반환합니다.
