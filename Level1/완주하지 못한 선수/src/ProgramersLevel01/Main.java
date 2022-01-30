package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;

public class Main {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            List<String> participantList = new ArrayList<>();
            List<String> completionList = new ArrayList<>();
            for(String player : participant)
            {
                participantList.add(player);
            }
            for(String player : completion)
            {
                completionList.add(player);
            }
            boolean doesComplete = false;
            for(String player : participantList)
            {
                doesComplete = false;
                for(String completePlayer : completionList)
                {
                    if(player.compareTo(completePlayer) == 0)
                    {
                        doesComplete = true;
                        completionList.remove(completePlayer);
                        break;
                    }
                }
                if(doesComplete == false)
                {
                    answer = player;
                    break;
                }
            }
            return answer;
        }
    }
    
    public static void main(String[] args) {
	// write your code here
    }
}
