# 내가 풀이한 코드

```java
class Solution {
    public String solution(String phone_number) {
        int backNumber = phone_number.length() - 4;
        String answer = phone_number.substring(backNumber);
        for(int i = 0; i < backNumber; i++)
        {
            answer = "*" + answer;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

매개변수로 입력 받는 phone_number의 뒤의 숫자4자리의 시작 위치를 구하는데<br><br>
phone_number의 개수에 -4를 해주면 됩니다.<br><br>
이 값을 backNumber 변수에 저장하고<br><br>
phone_number의 substring 메소드를 호출하고 매개변수로 backNumber를 입력한 뒤에<br><br>
answer에 그 반환값을 저장합니다.<br><br>
answer에 뒤의 번호 4자리가 저장되면 앞에 "\*"를 붙일 차례인데<br><br>
i = 0부터 backNumber보다 작은동안 반복을 합니다.<br><br>
반복문 내부에서 answer의 앞에 "\*"을 더해줍니다.<br><br>
반복문이 끝나면 answer에는 뒤의 4자리 번호만 표시되고<br><br>
나머지 번호는 모두 "\*"처리됩니다.<br><br>
다른 사람의 풀이를 보니 substring대신 toCharArray를 이용해 문자배열을 생성한 뒤에<br><br>
뒤에 4자리를 제외하고 모든 배열요소에 "\*"를 저장하는 방법도 있습니다.
