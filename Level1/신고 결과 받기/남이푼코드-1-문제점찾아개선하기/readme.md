# 남이 푼 코드

```java
package ProgramersLevel01;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        class Solution
        {
            public int[] solution(String[] id_list, String[] report, int k)
            {
                //answer배열을 id_list 배열크기만큼 힙에 할당한다.
                int[] answer = new int[id_list.length];
                //신고한 유저의 id(String)를 Key값으로 하고, 자신이 신고한 유저 id(String) 리스트를
                //Set으로 관리하는데 이 값이 Value인 Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Set<String>> reportingUsers = new HashMap<>();
                //신고당한 유저의 id(String)를 Key값으로 하고, 신고당한 횟수(Integer)를 Value로 하는
                //Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Integer> reportedUsers = new HashMap<>();
                //신고한 유저와 신고당한 유저의 Map객체들을 초기화시켜준다.
                //두 객체의 Key값은 id_list의 배열요소인 유저id로 같음.
                for(String usedId : id_list)
                {
                    //신고당한 유저들의 신고당한횟수를 0으로 초기화시킨다.
                    reportedUsers.put(usedId, 0);
                    //유저들이 신고한 유저 id 리스트를 관리할 Set을 생성한다.
                    reportingUsers.put(usedId, new HashSet<>());
                }
                StringTokenizer tokens = null;//문자열을 분리해서 저장할 임시 공간
                String reportingId;//신고한 회원 id를 저장할 임시 공간
                String reportedId;//신고당한 회원 id를 저장할 임시 공간
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //유저가 자신이 신고한 회원 id 기록에 신고당한 회원 id를 추가할 수 있으면
                    //(=유저가 자신이 신고한 회원의 기록에 똑같은 id 중복이 없으면)
                    if(reportingUsers.get(reportingId).add(reportedId) == true)
                    {
                        //신고당한 회원의 신고횟수 기록을 +1 증가시킨다.
                        reportedUsers.put(reportedId, reportedUsers.get(reportedId) + 1);
                    }
                }
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //신고당한 회원 id의 신고당한 횟수가 k보다 작으면
                    if(reportedUsers.get(reportedId) < k)
                    {
                        //유저가 신고한 회원리스트 중에서 신고당한 회원 id 기록을 지운다.
                        reportingUsers.get(reportingId).remove(reportedId);
                    }
                }
                //회원 아이디의 처음부터 마지막까지 반복한다.
                for(int i = 0; i < id_list.length; i++)
                {
                    //신고한 회원리스트에서 정지당한 회원의 수를 answer 각 배열요소에 저장한다.
                    answer[i] = reportingUsers.get(id_list[i]).size();
                }
                return answer;
            }
        }
    }
}
```

# 남이 푼 코드에서 문제점

처음 for each 반복에서 StringTokenizer 클래스를 이용하여 공백을 구분해<br><br>
신고한 회원id(reportingId)와 신고당한 회원id(reportedId)를 구하였습니다.<br><br>
그러나 두번째 for each 반복에서도 처음에 했던 것과 똑같이 또 StringTokenizer 클래스를 생성한 다음에<br><br>
공백을 구분해 문자열을 분리한 다음<br><br>
다시 신고한 회원id(reportingId)와 신고당한 회원id(reportedId)를 구하고 있습니다<br><br>
즉, **똑같은 행위를 반복**하고 있다는 것입니다.<br><br>
```java
                StringTokenizer tokens = null;//문자열을 분리해서 저장할 임시 공간
                String reportingId;//신고한 회원 id를 저장할 임시 공간
                String reportedId;//신고당한 회원 id를 저장할 임시 공간
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //유저가 자신이 신고한 회원 id 기록에 신고당한 회원 id를 추가할 수 있으면
                    //(=유저가 자신이 신고한 회원의 기록에 똑같은 id 중복이 없으면)
                    if(reportingUsers.get(reportingId).add(reportedId) == true)
                    {
                        //신고당한 회원의 신고횟수 기록을 +1 증가시킨다.
                        reportedUsers.put(reportedId, reportedUsers.get(reportedId) + 1);
                    }
                }
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //신고당한 회원 id의 신고당한 횟수가 k보다 작으면
                    if(reportedUsers.get(reportedId) < k)
                    {
                        //유저가 신고한 회원리스트 중에서 신고당한 회원 id 기록을 지운다.
                        reportingUsers.get(reportingId).remove(reportedId);
                    }
                }
```

# 해결책

**똑같은 행위를 반복하는 이유**는 처음에 공백을 구분하여 문자열을 분리한 다음에<br><br>
신고한 회원id와 신고당한 회원id를 구하였는데 이를 **저장하지 않았기 때문**입니다.<br><br>
**공백을 구분하여 문자열을 분리하는 이유**는<br><br>
결국에 **신고한 회원id와 신고당한 회원id**를 구하기 위해서 입니다.<br><br>
그래서 이 과정에서 **신고한 회원 id들**과 **신고당한 회원id들**을<br><br>
**ArrayList\<String\>에 저장**하면 다음에 다시 이 과정을 반복할 필요없이 **바로 접근**하여<br><br>
**신고한 회원id와 신고당한 회원id**를 구할 수 있습니다.<br><br>
개선한 코드를 한번 살펴보겠습니다.<br><br>
```java
package ProgramersLevel01;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        class Solution
        {
            public int[] solution(String[] id_list, String[] report, int k)
            {
                //answer배열을 id_list 배열크기만큼 힙에 할당한다.
                int[] answer = new int[id_list.length];
                //신고한 유저의 id(String)를 Key값으로 하고, 자신이 신고한 유저 id(String) 리스트를
                //Set으로 관리하는데 이 값이 Value인 Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Set<String>> reportingUsers = new HashMap<>();
                //신고당한 유저의 id(String)를 Key값으로 하고, 신고당한 횟수(Integer)를 Value로 하는
                //Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Integer> reportedUsers = new HashMap<>();
                //신고한 유저와 신고당한 유저의 Map객체들을 초기화시켜준다.
                //두 객체의 Key값은 id_list의 배열요소인 유저id로 같음.
                for(String usedId : id_list)
                {
                    //신고당한 유저들의 신고당한횟수를 0으로 초기화시킨다.
                    reportedUsers.put(usedId, 0);
                    //유저들이 신고한 유저 id 리스트를 관리할 Set을 생성한다.
                    reportingUsers.put(usedId, new HashSet<>());
                }
                StringTokenizer tokens = null;//문자열을 분리해서 저장할 임시 공간
                String[] reportingIds = new String[report.length]; //신고한 회원 id들을 저장할 배열
                String[] reportedIds = new String[report.length];//신고당한 회원 id들을 저장할 배열
                //신고한 회원과 신고당한 회원의 기록이 있는 report의 처음부터 마지막까지 반복한다.
                for(int i = 0; i < report.length; i++)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(report[i], " ");
                    //신고한 회원 id를 구하여 문자열 배열에 저장한다.
                    reportingIds[i] = tokens.nextToken();
                    //신고당한 회원 id를 구하여 문자열 배열에 저장한다.
                    reportedIds[i] = tokens.nextToken();
                    //유저가 자신이 신고한 회원 id 기록에 신고당한 회원 id를 추가할 수 있으면
                    //(=유저가 자신이 신고한 회원의 기록에 똑같은 id 중복이 없으면)
                    if(reportingUsers.get(reportingIds[i]).add(reportedIds[i]) == true)
                    {
                        //신고당한 회원의 신고횟수 기록을 +1 증가시킨다.
                        reportedUsers.put(reportedIds[i],
                                reportedUsers.get(reportedIds[i]) + 1);
                    }
                }
                //신고한 회원과 신고당한 회원의 기록이 있는 report의 처음부터 마지막까지 반복한다.
                for(int i = 0; i <  report.length; i++)
                {
                    //신고당한 회원 id의 신고당한 횟수가 k보다 작으면
                    if(reportedUsers.get(reportedIds[i]) < k)
                    {
                        //유저가 신고한 회원리스트 중에서 신고당한 회원 id 기록을 지운다.
                        reportingUsers.get(reportingIds[i]).remove(reportedIds[i]);
                    }
                }
                //회원 아이디의 처음부터 마지막까지 반복한다.
                for(int i = 0; i < id_list.length; i++)
                {
                    //신고한 회원리스트에서 정지당한 회원의 수를 answer 각 배열요소에 저장한다.
                    answer[i] = reportingUsers.get(id_list[i]).size();
                }
                return answer;
            }
        }
    }
}
```
위 코드에서 보시다시피 **String배열 report**에서 **신고한 회원 id들을 저장**할 **String배열**인 **reportingIds**와<br><br>
**신고당한 회원 id들을 저장**할 **reportedIds**를  **report의 크기만큼 힙에 할당**합니다.<br><br>
물론 크기를 유동적으로 관리할 수 있는 ArrayList를 사용할 수도 있지만<br><br>
지금처럼 크기가 고정적으로 정해진 경우에는 배열을 사용해도 됩니다.<br><br>
report의 처음부터 마지막 배열요소까지 반복을 돌리면서 순차적으로 reportingIds 배열요소에 신고한 회원id를,<br><br>
reportedIds 배열요소에는 신고당한 회원id를 저장합니다.<br><br>
반복문이 끝나고 나면 **reportingIds**에는 report에서 **신고한 회원id들이 순차적으로 저장**되어 있고,<br><br> 
**reportedIds**에는 **신고당한 회원id들이 순차적으로 저장**되어있습니다.<br><br>
그럼 다시 i = 0부터 report의 개수보다 작은 동안 반복을 할 때<br><br>
이미 저장되어 있는 값들(reportingIds와 reportedIds)에 바로 접근할 수 있기 때문에<br><br>
처음에 문제로 제기했던 중복코드 반복문제를 해결할 수 있습니다.<br><br>
나머지 코드는 모두 동일합니다.
