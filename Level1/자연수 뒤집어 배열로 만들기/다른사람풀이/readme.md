# 다른 사람이 푼 코드
```java
class Solution {
  public int[] solution(long n) {
      String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;

        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            cnt++;
        }
      return answer;
  }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기
먼저 String객체 a를 생성하면서 공백에 a를 더해주면 a는 n을 문자열로 바꾼 값을 저장하게 됩니다.<br><br>
정수형 배열을 만들 때 a의 길이를 이용하여 그 크기만큼 힙에 할당합니다.<br><br>
cnt를 0으로 초기화하고<br><br>
n이 0보다 큰 동안 반복합니다.<br><br>
answer의 cnt번째 배열요소에 n을 10으로 나눈 나머지를 int로 형변환하여 저장합니다.<br><br>
n을 10으로 나눈 몫을 n에 저장합니다.<br><br>
배열첨자 cnt를 증가시켜줍니다.<br><br>
반복이 끝나면 원하는 결과가 answer에 저장되므로 이를 반환합니다.
