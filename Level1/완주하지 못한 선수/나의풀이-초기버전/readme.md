# 내가 푼 코드
```java
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> completionList = new ArrayList<>();
        for(String player : completion)
        {
            completionList.add(player);
        }
        boolean doesComplete = false;
        for(String player : participant)
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
```
