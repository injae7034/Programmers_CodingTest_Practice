# 내가 풀이한 코드

```java
import java.util.Scanner;

class Solution {
    public static void solution(int a, int b)
    {
        for(int i = 0; i < b; i++)
        {
            for(int j = 0; j < a; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        solution(a, b);
    }
}
```

# 내가 풀이한 코드 설명하기

외부로부터 입력받은 정수 a와 b를 매개변수로 하는 solution 메소드를 정의합니다.<br><br>
우선 i = 0부터 b보다 작은 동안 반복하고 다시 j = 0부터 a보다 작은동안 반복합니다.<br><br>
반복문내에서 줄바꿈을 하지않는 print를 이용하여 "\*"을 a번만큼 출력하고,<br><br>
줄바꿈을 위해 println()을 호출합니다.<br><br>
이렇게하면 a X b 만큼의 별을 콘솔창에 출력할 수 있습니다.
