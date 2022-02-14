# 내가 풀이한 코드
```java
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(')
        {
            answer = false;
        }
        else
        {
            int index = 0;
            int count = 0;
            while(index < s.length() && count > -1)
            {
                 if(s.charAt(index) == '(')
                {
                    count++;
                }
                else
                {
                    count--;
                }
                index++;
            }
            if(count == 0)
            {
                answer = true;
            }
            else
            {
                answer = false;
            }
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

처음이 ')'이거나 마지막이 '('이면 무조건 틀렸기 때문에 false를 반환합니다.<br><br>
그게 아니면 이제 count를 통해 판별합니다.<br><br>
문자열 s의 처음부터 마지막까지 반복을 하면서 한 문자씩 '('인지 ')'인지 판별합니다.<br><br>
count는 0으로 초기화하고, '('일 경우 count에 +1을, ')'일 경우 -1을 해줍니다.<br><br>
여기서 **주의할 점은 count가 -1이되면 반복을 벗어나야 한다**는 것입니다.<br><br>
count가 -1이라는 의미는 열린 괄호보다 닫힌 괄호가 1개 더 많다는 뜻인데<br><br>
괄호가 열리기 전에 닫힌 괄호는 있으면 안되기 때문에<br><br>
비록 마지막에 count가 0이 된다고 하더라도 틀린 괄호가 됩니다<br><br>
반대로 열린 괄호는 얼마든지 열려도 뒤에서 다시 닫아주면 되기 때문에<br><br>
즉, 최종적으로는 count가 0이 되면 맞는 괄호입니다.
