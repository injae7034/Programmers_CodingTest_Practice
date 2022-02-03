package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;

public class Main {

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
        for(String key : playerMap.keySet())
        {
            if(playerMap.get(key) != 0)
            {
                answer = key;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        System.out.println(solution(participant, completion));
    }
}
