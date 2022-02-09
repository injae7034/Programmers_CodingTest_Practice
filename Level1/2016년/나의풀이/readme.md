# 내가 푼 코드

```java
import java.time.Month;
import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public String solution(int a, int b) {
        DayOfWeek dayOfWeek = LocalDate.of(2016, Month.of(a), b).getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }
}
```

# 내가 푼 코드 설명
먼저 Java에서 제공하는 월(Month)을 사용하기 위해 java.time.Month을 import해줍니다.<br><br>
또한 Java에서 제공하는 요일(DayOfWeek)을 사용하기 위해 java.time.DayOfWeek도 import해줍니다.<br><br>
매개변수로 입력 받은 a(월), b(날짜)로 2016년의 요일(DayOfWeek)을 구하기 위해<br><br>
java.time.LocalDate를 import해줍니다.<br><br>
LocalDate클래스의 정적메소드인 of을 이용하여 년의 매개변수로 2016을 전달합니다.<br><br>
달의 매개변수는 Month클래스의 정적메소드인 of에 월을 나타내는 a를 매개변수로 전달하여 Month클래스의 객체를 반환받고,<br><br>
이를 LocalDate클래스의 정적메소드인 of의 Month매개변수로 홯용합니다.<br><br>
나머지 일짜 매개변수는 b를 그대로 넣어줍니다.<br><br>
즉, LocalDate클래스의 정적메소드인 of에 년, 월, 일을 매개변수로 넣어주면 해당일자의 LocalDate클래스의 객체가 생성되는데<br><br>
이 객체를 통해 getDayOfWeek메소드를 호출하면 해당 년, 월, 일의 요일을 반환합니다.<br><br>
이 요일을 toString을 통해 문자열로 바꿔주고, 처음부터 시작해서 3글자를 출력해야하기 때문에<br><br>
subString(0, 3)을 호출하면 요일의 스펠링 3글자만 성공적으로 출력됩니다.
