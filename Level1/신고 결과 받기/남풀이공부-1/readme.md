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
                //Set으로 관리하는데 이 값이 Value인 Map의 객체를 LinkedHashMap의 생성자로 생성한다.
                Map<String, Set<String>> reportingUsers = new LinkedHashMap<>();
                //신고당한 유저의 id(String)를 Key값으로 하고, 신고당한 횟수(Integer)를 Value로 하는
                //Map의 객체를 LinkedHashMap의 생성자로 생성한다.
                Map<String, Integer> reportedUsers = new LinkedHashMap<>();
                //신고한 유저와 신고당한 유저의 Map객체들을 초기화시켜준다.
                //두 객체의 Key값은 id_list의 배열요소인 유저id로 같음.
                for(String usedId : id_list)
                {
                    //신고당한 유저들의 신고당한횟수를 0으로 초기화시킨다.
                    reportedUsers.put(usedId, 0);
                    //유저들이 신고한 유저 id 리스트를 관리할 Set을 생성한다.
                    reportingUsers.put(usedId, new LinkedHashSet<>());
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
# 코드 해석
먼저 answer배열을 힙에 할당하는데 크기는 id_list의 length와 동일하게 할당합니다.<br><br>
그 이유는 answer의 각 배열요소에는 id_list의 각 배열요소(유저id)가 정지시킨 회원 id 수가 저장되기 때문입니다.<br><br>
그래서 answer의 크기는 id_list의 개수와 같아야 하고, 그 순서도 같아야 합니다.<br><br>
즉, answer의 배열요소는 id_list에서 각 배열요소(유저id)가 정지시킨 회원 id 수를 의미합니다.<br><br>
Map의 객체를 자신의 자식인 LinkedHashMap의 생성자를 이용해 생성합니다.<br><br>
왜냐하면 Map은 추상클래스이기 때문에 자신의 자식의 생성자를 이용해서만 생성할 수 있습니다.<br><br>
Map의 객체인 **reportingUsers**는 **신고한 회원id**와 **자신이 신고한 회원id 집합**으로 구성되는데, **Key값이 신고한 유저의 id(String)** 이고, **Value값이 자신이 신고한 유저 id(String) 집합인 Set**입니다.<br><br>
또다른 Map의 객체인 **reportedUsers**는 **신고당한 회원id**와 **신고당한 횟수**로 구성되는데, **Key값이 신고당한 유저의 id(String)** 이고, **Value값이 신고당한 횟수(Integer)** 입니다.<br><br>
Map의 객체들을 생성했으면 이제 이 객체들을 초기화시켜줄 차례입니다.<br><br>
**reportingUsers**와 **reportedUsers**는 동일한 Key(String)값인 회원id를 가지고 있습니다.<br><br>
다만 차이는 신고했느냐 신고당했느냐 차이이지만 Key값을 동일하게 회원id입니다.<br><br>
즉, 동일한 key값을 가지고 있기 때문에 size도 서로 같고, 결론적으로 말하면 id_list의 length와 같습니다.<br><br>
그래서 이 동일한 key값을 이용하여 동시에 초기화시켜 줄 수 있습니다.<br><br>
회원id를 문자열 배열(String[])로 저장하고 있는 id_list의 문자열(회원id)을 처음부터 끝까지 반복하는데 이 때 for each 반복문을 통해 회원id를 하나씩 구하는데 그 참조변수값을 **userId**로 설정합니다.<br><br>
**reportedUsers**는 **userId**(Key값)와 0을(Value값이 Integer이기 때문에) 매개변수로 하는 put 메소드를 호출합니다.<br><br>
**reportingUsers**는 **userId**(Key값)와 new LinkedHashSet\<String\>의 생성자(Value값이 String을 집합으로 하는 Set이기 때문에)를 매개변수로 하는 put 메소드를 호출합니다.<br><br>
이런식으로 id_list에 저장된 userId를 처음부터 끝까지 매개변수로 하여 **reportedUsers**와 **reportingUsers**를 처음부터 마지막까지 초기화시켜줍니다.<br><br>
그 다음으로는 신고한 회원이 어떤 회원을 신고했는지에 대한 기록 정보가 담긴 report문자열 배열을 살펴 볼 차례입니다.<br><br>
report의 각 배열요소는 신고한 회원id와 신고당한 회원id를 가지고 있는데 공백으로 이 둘을 구분하고 있습니다.<br><br>
그래서 이 **신고한 회원id와 신고당한 회원id을 공백으로 나눠주기 위해 사용하는 클래스**가 바로 **StringTokenizer**입니다.<br><br>
방법은 StringTokenizer객체를 생성할 때 매개변수로 분리할 문자열과 분리할 기준을 매개변수로 입력하면 됩니다.<br><br>
여기서는 매개변수로 **report의 각 배열요소가 분리할 문자열 매개변수**가 되고, **공백(" ")이 분리할 기준 매개변수**가 됩니다.<br><br>
다만 일회성으로 그치면 안되고, report의 수만큼 반복해야하기 때문에 아까처럼 for each 반복을 통해서 report에서 각 배열요소(String recording)를 하나씩 추출하여 StringTokenizer의 생성자의 매개변수로 입력하여 StringTokenizer의 객체를 생성합니다.<br><br>
StringTokenizer의 객체인 tokens에는 처음에는 신고한 회원id가 저장되어 있을 것이고, 두번째로는 신고당한 회원id가 저장되어 있을 것입니다.<br><br>
이 정보를 가져오기 위해 StringTokenizer의 인스턴스메소드인 **nextToken**메소드를 이용합니다.<br><br>
**처음 nextToken메소드를 호출**하여 그 **반환값**은 **신고한 회원id를 저장할 String 객체인 reportingId에 저장**합니다.<br><br>
**두번째 nextToken메소드를 호출**하여 그 **반환값**은 **신고당한 회원id를 저장할 String 객체인 reportedId에 저장**합니다.<br><br>
이제 여기서 Map\<String, Set\<String\>\>의 객체인 **reportingUsers**에서 **Value**값인 **Set\<String\>**에 **reportedId**를 저장할 때 Set에 이미 **reportedId**와 **똑같은 문자열이 있는지 없는지 확인하는 것이 중요**합니다.<br><br>
왜냐하면 문제의 규칙 중에 한명의 회원은 똑같은 회원을 여러번 신고하더라도 그 count는 1회만 유효하다는 규칙이 있기 때문입니다.<br><br>
예를 들어, 한 회원이 똑같은 회원을 4번 신고하여도 그 count는 1회밖에 처리되지 않습니다.<br><br>
그래서 이런 중복처리를 해주기 위해서 Set에 신고당한 회원 id를 저장할 때 중복이 있는지 없는지 확인하는 것이 중요합니다.<br><br>
다행히도 Set은 중복을 허용하지 않기 때문에 이미 Set에 존재하는 똑같은 값을 매개변수로 하는 add를 호출하면 그 값을 Set에 추가하지 않고, 반환값으로 false를 반환합니다.<br><br>
(여기서 Set대신에 **List였다면 List의 처음부터 끝까지 반복하면서 일일이 각 배열요소를 구하여 중복되는 값이 있는지 없는지를 확인해줘야 합니다;;**)
그래서 여기서는 Set을 써야 손쉽게 중복되는 정보를 저장하지 않을 수 있습니다.<br><br>
즉,  **reportingUsers**의 **get**메소드에 **Key값인 reportingId**를 매개변수로 넣어서 **Value값인 Set\<String\>** 을 구합니다. <br><br>
그리고 **Set의 add**메소드에 **reportedId**를 매개변수로 전달합니다.<br><br>
Set에 **reportedId**의 **중복이 없으면 Set에 reportedId가 추가되고, 반환값은 true**입니다.<br><br>
Set에 **reportedId**의 **중복이 있으면 Set에 reportedId가 추가되지 않고, 반환값은 false**입니다.<br><br>
이 과정을 **선택구조로 활용**하여 Set에 메소드를 추가시키면서 그 반환값으로 중복이 됬는지 아닌지를 체크하여 중복이 없으면(=반환값이 true이면) 선택구조에 들어가서 Map<String, Integer>의 객체인 **reportedUsers**의 Key값인 **reportedId**에 Value값인 Integer를 1 증가시켜줍니다.(초기값은 0임)<br><br>
즉, 유저가 해당 회원id를 처음으로 신고하는 경우(여러번 신고하지 않고)만 그 count를 +1시켜준다는 말입니다.<br><br>
이렇게 for each 반복이 끝나고 나면 **reportingUsers**에는 Key값인 신고한 회원id에 자신이 신고한 회원 id집합이 Value로 매칭되어 있을 것입니다.<br><br>
**reportedUsers**에는 key값인 신고당한 회원id에 신고당한 횟수가 Value로 매칭되어 있을 것입니다.<br><br>
이제 특정횟수(k)를 넘는 경우에만 회원 id가 정지되고, 이 정지된 회원 id를 신고한 회원에게 알림이 날라가는데 이 알림 횟수를 처리해야 합니다.<br><br>
