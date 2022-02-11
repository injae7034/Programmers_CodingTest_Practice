# 내가 풀이한 코드

```java
class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        for(int i = 0; i < seoul.length; i++)
        {
            if("Kim".compareTo(seoul[i]) == 0)
            {
                index = i;
                break;
            }
        }
        String answer = "김서방은 " + index + "에 있다";
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

문자열배열 seoul에서 처음 원소부터 마지막 원소까지 반복을 하면서 "Kim"을 찾습니다.<br><br>
"Kim"을 찾으면 배열첨자 위치를 저장하고, 반복문을 빠져나옵니다.<br><br>
문자열 연산을 통해 위치를 반영한 문자열을 생성하고 이를 반환합니다.

# 아쉬운 점

```java
int index = Arrays.asList(seoul).indexOf("Kim");
```
위와 같이 Arrays의 asList메소드를 통해 문자열 배열을<br><br>
ArrayList\<String\>으로 변환을 시킨 다음 indexOf메소드를 호출하여 "Kim"의 위치를 바로 알아 낼 수 있습니다.<br><br>
이 방식을 이용하면 반복문없이 한 줄로 "Kim"의 위치를 알아낼 수 있습니다.
