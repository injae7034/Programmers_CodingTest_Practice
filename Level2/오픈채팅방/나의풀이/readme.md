# 내가 풀이한 코드
```java
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer tokens;
        String command;
        Map<String, String> id_nickName_Map = new HashMap<>();
        for(int i = 0; i < record.length; i++)
        {
            tokens = new StringTokenizer(record[i], " ");
            command = tokens.nextToken(); 
            if(command.compareTo("Leave") != 0)
            {
                id_nickName_Map.put(tokens.nextToken(), tokens.nextToken());
            }
        }
        StringBuilder stb;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < record.length; i++)
        {
            tokens = new StringTokenizer(record[i], " ");
            command = tokens.nextToken();
            stb = new StringBuilder(id_nickName_Map.get(tokens.nextToken()));
            if(command.compareTo("Enter") == 0)
            {   
                stb.append("님이 들어왔습니다.");
            }
            else if(command.compareTo("Leave") == 0)
            {
                stb.append("님이 나갔습니다.");
            }
            else
            {
                continue;
            }
            result.add(stb.toString());
        }
        String[] answer = new String[result.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명하기

map의 객체 id_nickName_Map을 HashMap의 생성자로 생성하는데<br><br>
key값은 id(String), value값은 nickname(String)으로 설정합니다.<br><br>
i = 0부터 매개변수로 주어지는 문자열배열 record의 길이보다 작은동안 반복합니다.<br><br>
반복문 내부에서 StringTokenizer의 객체 tokens를 record의 i번째 원소와 공백을 매개변수로 넣어 생성합니다.<br><br>
즉, record의 i번째 원소를 공백을 기준으로 분리시킵니다.<br><br>
StringTokenizer의 tokens의 경우 nextToken을 호출하면 저장하고 있는 원소를 소모하기 때문에<br><br>
이 값으로 문자열 비교를 하기 위해서는 이를 저장해줘야 하기 때문에 command라는 문자열 객체에 nextToken의 반환값을 저장합니다.<br><br>
command에 저장된 문자열이 "Leave"가 아니라면<br><br>
(Leave는 id의 nickname을 변경시키지 않기 때문에)<br><br>
즉, command에 저장된 문자열이 "Enter"나 "Change"라면<br><br>
2번째 nextToken에는 id가 반환될 것이고 세번째 nextToken에는 nickname이 반환될 것입니다.<br><br>
그래서 두번째 nextToken의 반환값을 key값으로 세번째 nextToken의 반환값을 value값으로 하여<br><br>
map의 객체 id_nickName_Map의 put 메소드의 매개변수에 넣어줍니다.<br><br>
이렇게 반복이 끝나고 나면 결국에 id(key)에는 마지막으로 변경된 nickname(value)이 저장되어 있을 것입니다.<br><br>
결과 문자열을 저장할 List객체 result를 ArrayList의 생성자로 생성해줍니다.<br><br>
반복문 내부에서 다시 StringTokenizer의 객체 tokens를 record의 i번째 원소와 공백을 매개변수로 넣어 생성합니다.<br><br>
StringTokenizer의 tokens의 경우 nextToken을 호출하면 저장하고 있는 원소를 소모하기 때문에<br><br>
이 값으로 문자열 비교를 하기 위해서는 이를 저장해줘야 하기 때문에 command라는 문자열 객체에 nextToken의 반환값을 저장합니다.<br><br>
2번째 nextToken을 호출하면 id값이 반환되는데 이를 key값으로 id_nickName_Map의 get메소드를 호출하여 value값을 반환받습니다.<br><br>
반환받은 value값은 가장 최신에 갱신된 nickname을 의미하는데 이를 매개변수로 하여 StringBuilder의 객체 stb를 생성합니다.<br><br>
command에 저장된 문자열이 "Enter"이면 stb에 "님이 들어왔습니다." 문자열을 append해주고<br><br>
command에 저장된 문자열이 "Leave"이면 stb에 "님이 나갔습니다." 문자열을 append해줍니다.<br><br>
그리고 stb를 String으로 바꿔서 result에 add해줍니다.<br><br>
command에 저장된 문자열이 "Change"이면 continue를 호출하여 바로 반복문의 조건문으로 이동합니다.<br><br>
change의 경우 result에 기록이 안되기 때문에 continue를 통해 바로 넘어가고 result에 add하지 않습니다.<br><br>
반복문이 끝나면 result에는 모든 기록에 대한 결과가 최신 닉네임 정보로 반영되어 저장되어 있을 것이고<br><br>
이를 문자열 배열에 옮겨 반환합니다.
