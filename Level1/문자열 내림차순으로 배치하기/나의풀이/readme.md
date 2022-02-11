# 내가 풀이한 코드

```java
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCount = 0;
        int yCount = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if("p".equalsIgnoreCase(String.valueOf(s.charAt(i))) == true)
            {
                pCount++;
            }
            else if("y".equalsIgnoreCase(String.valueOf(s.charAt(i))) == true)
            {
                yCount++;
            }
        }
        if(pCount != yCount)
        {
            answer = false;
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

반복을 돌면서 문자열s의 첫 문자부터 마지막 문자까지 반복합니다.<br><br>
equalsIgnoreCase를 통해 대소문자를 구분하지 않고 문자열 "p"와 같으면 pCount를 세고,<br><br>
"y"와 같으면 yCount를 셉니다.<br><br>
반복문이 끝나고 p와 y의 개수가 다르면 answer에 false를 저장한 뒤에 반환하고,<br><br>
개수가 같으면 디폴트값 true가 저장된 answer를 반환합니다.

# 아쉬운 점

대소문자를 구분하지 않는다고 했기 때문에 굳이 equalsIgnoreCase를 쓰기보다는<br><br>
toUpperCase나 toLowerCase로 대소문자를 통일하여 사용하는 것이 더 편함.
