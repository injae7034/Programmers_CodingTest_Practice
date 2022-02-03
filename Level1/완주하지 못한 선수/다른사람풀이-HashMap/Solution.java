import java.util.Map;
import java.util.HashMap;

public class Solution 
{
    public String solution(String[] participant, String[] completion)
    {
        String answer = "";
        //1. HashMap을 만든다.
        Map<String, Integer> playeMap = new HashMap<>();
        for(String player : participant)
        {
            playeMap.put(player, playeMap.getOrDefault(player, 0) + 1);
        }
        System.out.println(playeMap);
        return answer;
    }  
    public static void main(String[] args) 
    {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        Solution solution = new Solution();
        System.out.println(solution.solution(participant, completion));
    }
    
}
