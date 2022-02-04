# 다른 사람 풀이 - HashMap

```java
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class Solution
{
    public static String solution(String[] participant, String[] completion)
    {
        String answer = "";
        //1. HashMap을 생성한다.
        Map<String, Integer> playerMap = new HashMap<>();
        //2. HashMap을 participant로 초기화시킨다.
        for(String player : participant)
        {
            playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);
        }
        //3. HashMap에서 completion을 참고하여 뺀다.
        for(String player : completion)
        {
            playerMap.put(player, playerMap.get(player) - 1);
        }
        //4. value가 0이 아닌 완주하지 못한 선수를 찾는다.
        /*
        //keySet 이용
        for(String key : playerMap.keySet())
        {
            if(playerMap.get(key) != 0)
            {
                answer = key;
                break;
            }
        }
         */
        //Iterator, Entry 이용
        Iterator<Map.Entry<String, Integer>> iterator = playerMap.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() != 0)
            {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }
}
```

# 다른 사람 풀이 해석하며 공부하기

  Map을 HashMap생성자로 생성하면서 Key 값은 String, Value 값은 Integer로 설정합니다.<br><br>
  Key값의 자료형은 String인데 참가 선수 이름입니다.<br><br>
  Value값인 Integer는 참가 선수 이름의 개수입니다.<br><br>
  Map을 생성한 후에 매개변수로 입력 받은 participant 배열로 초기화시키기 위해<br><br>
  for each 반복을 사용해 배열요소를 하나씩 구합니다.<br><br>
  participant의 배열요소는 문자열로 선수이름을 나타냅니다.<br><br>
  선수이름을 key값으로 하고, 선수이름의 누적 개수를 value값으로 하여,<br><br>
  Map에 Entry(Key + Value)를 put합니다.<br><br>
  Map의 put메소드에 key값으로는 player(선수이름)을 넣어 주면 되고,<br><br>
  value값으로는 Map의 getOrDefault메소드를 이용합니다.<br><br>
  getOrDefault메소드의 매개변수로 player(선수이름)와 0을 입력해줍니다.<br><br>
  그러면 key값이 player인 Entry의 value값을 구해서 반환해줍니다.<br><br>
  만약에 아직 player(key)에 값(value)이 설정되어 있지 않다면<br><br>
  매개변수로 입력한 0(default값)을 반환한 값에 1을 더하여<br><br>
  최종적으로 player(key)에 1(value)이 저장되도록 put합니다.<br><br>
  반면에 participant에 동명이인이 있어서 이미 값(value)이 설정되어 있으면<br><br>
  그 값을 반환하여 +1을 해준 값을 value로 저장하도록 put합니다.<br><br>
  for eahc 반복구조가 끝나고 나면 참가선수 중에 동명이인이 있으면<br><br>
  동명이인을 포함한 선수 이름의 개수가 누적되어 저장될 것이고,<br><br>
  동명이인이 없으면 1이 저장될 것입니다.<br><br>
  다음으로는 매개변수로 입력 받은 completion을 이용해 for each 반복을 합니다.<br><br>
  for each 반복에서 completion의 배열요소인 문자열(완주한 선수)를 하나씩 구한 다음<br><br>
  이를 Map의 key값으로 하여 put의 매개변수에 활용합니다.<br><br>
  value는 Map의 get메소드를 활용하여 key값을 매개변수로 전달하여<br><br>
  해당 key값의 value값에 -1을 해준 값을 value로 설정하여 put해줍니다.<br><br>
  for each 반복문이 끝나고 나면 참여한 선수 중에 동명이인이 없을 경우<br><br>
  완주하지 못한 선수만 value값이 1일 것이고,<br><br>
  완주한 선수들은 value값이 모두 0일 것입니다.<br><br>
  동명이인이 있다면 participant에서 for each반복을 할 때<br><br>
  Map에 참여한 동명이인의 수가 누적이 되어 있습니다.<br><br>
  그리고 completion에서 for each 반복을 할 때<br><br>
  완주한 동명이인의 수만큼 Map에서 value값을 빼주기 때문에<br><br>
  만약에 completion의 배열요소에 모든 동명이인이 다 있다면 0이 저장될 것이고,<br><br>
  completion의 배열요소에 1명이 모자라면 빼기가 덜되서 1이 저장될 것입니다.<br><br>
  completion의 for each 반복이 끝나고 나면 Map에서 value가 0이 아닌 값을 찾는 과정입니다.<br><br>
  두가지 방법이 있는데 첫번째 방법은 keySet을 이용하는 방법이고,<br><br>
  두번째 방법은 entrySet과 Iterator를 이용하는 방법이 있습니다.<br><br>
  
  ## keySet 이용
  Map의 keySet메소드를 이용하면 반환값으로 key값들의 Set\<String\>이 반환됩니다.<br><br>
  이 Set에서 for each 반복을 통하여 하나씩 key값들을 구한 다음<br><br>
  이 key값을 이용해 Map에서 get메소드에 key값을 전달합니다.<br><br>
  그러면 value값이 반환되는데 이 때 이 value값이 0이 아니면<br><br>
  completion에 없었다는 뜻이고, 완주하지 못한 선수를 의미합니다.<br><br>
  그래서 value값이 0이 아닌 key값(선수이름)을 answer에 저장하고,<br><br>
  원하는 바(완주하지 못한 선수찾기)를 이뤘기 때문에<br><br>
  더이상 반복을 하지 않고, 반복을 종료시키기 위해 break를 사용합니다.<br><br>
  그다음 완주하지 못한 선수의 이름을 저장한 answer를 반환합니다.<br><br>
  
  ## entrySet 이용
  반복구조를 사용할 때 keySet보다 entrySet을 이용하는 것이 효율성(시간)이 더 좋다고 합니다.<br><br>
  그래서 entrySet을 사용하기 위해 우선 Iterator의 객체를 생성합니다.<br><br>
  Iterator는 반복을 도와주는 클래스입니다.<br><br>
  자료형을 Map.Entry\<String, Integer\>로 설정합니다.<br><br>
  Map의 entrySet메소드를 호출하면 반환값으로 Set\<String, Integer\>를 반환하는데,<br><br>
  이 Set에서 다시 iterator메소드를 호출하면 Iterator클래스의 객체를 생성하여 반환합니다.<br><br>
  Iterator클래스의 객체참조값을 반환받은 다음에 이를 활용하여 while반복구조를 돌립니다.<br><br>
  while반복문의 조건문으로 Iterator클래스의 hasNext메소드를 호출합니다.<br><br>
  다음이 있으면 true를 반환하고, 다음이 없으면 false를 반환합니다.<br><br>
  즉, Iterator객체가 마지막에 위치하고 있으면 다음이 없기 때문에 false를 반환하고,<br><br>
  그전에는 다음이 있기 때문에 true를 반환합니다.<br><br>
  반복문 내부에서 Iterator클래스의 next메소드를 통해 Map.Entry\<String, Integer\>를 반환받습니다.<br><br>
  이 Entry의 getValue 메소드를 통해 value(Integer)값을 구하는데<br><br>
  그 값이 0이면 getKey 메소드를 호출하여 반환받은 key값을 answer에 저장한 다음<br><br>
  break를 통해 반복문을 벗어나고, answer를 반환합니다.<br><br>
  
  # 깨달은 점
  해쉬를 사용하려고 했으니 동명이인이 있기 때문에 선수이름을 key값으로 사용하지 못할 것이라는 착각을 하였습니다.<br><br>
  value값을 Boolean을 생각한 것도 잘못입니다.<br><br>
  Key값인 선수이름에 value값을 Boolean(완주여부를 true/false)을 저장하였기 때문에<br><br>
  동명이인이 있을 경우 선수이름을 key값으로 사용할 수 없습니다.<br><br>
  그러나 Value값을 Integer로 설정하면 이야기가 달라집니다.<br><br>
  Integer를 이용하여 선수이름의 개수를 value값으로 설정하면<br><br>
  동명이인이 있더라도 그 동명이인의 개수를 value값으로 저장하고,<br><br>
  선수가 한명이면 1을 value값으로 저장하면 됩니다.<br><br>
  즉, 해쉬맵 설계를 Boolean으로 하느냐 Integer로 하느냐에 따라서<br><br>
  해쉬맵을 쓸 수 있는지 없는지가 정해집니다.<br><br>
  다음부터는 해쉬맵을 사용할 때 Key값으로 사용하려는 값에<br><br>
  중복이 있는 경우에는 value값으로 그 중복 개수를 나타내기 위해<br><br>
  Integer를 사용하는 방법도 고려하도록 기억하자.
