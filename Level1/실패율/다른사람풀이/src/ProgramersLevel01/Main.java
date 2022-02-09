package ProgramersLevel01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public int[] solution(int N, int[] stages)
    {
        int playerCount = stages.length;
        int[] stagePlayers = new int[N + 2];
        for(int stage : stages)
        {
            stagePlayers[stage] += 1;
        }
        int remainingPlayerCount = playerCount;
        List<Stage> stageList = new ArrayList<>();
        double failure = 0.0;
        for(int level = 1; level <= N; level++)
        {
            failure = (double) stagePlayers[level] / remainingPlayerCount;
            remainingPlayerCount -= stagePlayers[level];

            Stage s = new Stage(level, failure);
            stageList.add(s);
        }
        Collections.sort(stageList, Collections.reverseOrder());
        int[] answer = new int[N];
        for(int i = 0; i < N; i++)
        {
            answer[i] = stageList.get(i).level;
        }
        return answer;
    }
    class Stage implements Comparable<Stage>
    {
        public int level;
        public double failure;

        public Stage(int level, double failure)
        {
            this.level = level;
            this.failure = failure;
        }

        @Override
        public int compareTo(Stage one)
        {
            if(this.failure < one.failure)
            {
                return  -1;
            }
            else if(this.failure > one.failure)
            {
                return 1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
	// write your code here
    }
}
