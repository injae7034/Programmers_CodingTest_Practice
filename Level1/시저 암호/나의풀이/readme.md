# 내가 풀이한 코드

```java
class Solution {
    public String solution(String s, int n) {
        StringBuilder stb = new StringBuilder();
        char temp;
        for(int i = 0; i < s.length(); i++)
        {
            temp = s.charAt(i);
            if(temp != ' ')
            {
                for(int j = 1; j <= n; j++)
                {
                    if(temp == 'z')
                    {
                        temp = 'a';
                    }
                    else if(temp == 'Z')
                    {
                        temp = 'A';
                    }
                    else
                    {
                        temp++;
                    }
                }
            }
            stb.append(temp);
        }
        return stb.toString();
    }
}
```

# 내가 풀이한 코드 설명

StringBuilder클래스의 객체인 stb를 생성합니다.<br><br>
문자를 저장할 임시변수인 temp도 선언합니다.<br><br>
매개변수로 입력 받은 s의 첫 문자부터 마지막문자까지 charAt메소드를 통해 구하는데<br><br>
구한 문자를 임시변수 temp에 저장합니다.<br><br>
temp가 공백이 아니면<br><br>
j = 1부터 n보다 작거나 같은 동안 반복을 합니다.<br><br>
반복문 내부에서 temp가 'z'이면 'a'로 바꿔주고,<br><br>
'Z'이면 'A'로 바꿔줍니다.<br><br>
둘다 아니면 +1을 증가시켜줍니다.<br><br>
char 자료형은 아스키코드이기 때문에 +연산이 가능하고,<br><br>
+1을 하면 다음 문자로 넘어갑니다.<br><br>
반복이 끝나면 시저암호화된 temp를 stb에 append합니다.<br><br>
이 후 반복이 끝나면 stb에는 시저암호화된 전체 문자열이 저장되어 있을 것이고<br><br>
toString을 통해 StringBuilder를 String으로 바꿔서 출력합니다.
