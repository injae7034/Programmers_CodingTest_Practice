package ProgramersLevel01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static int[] solution(int N, int[] stages)
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
    static class Stage implements Comparable<Stage>
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
/*
//level도 오름차순말고 내림차순으로 정렬하고 싶은 경우에 필요한 처리
        @Override
        public int compareTo(Stage one)
        {
            int ret = 0;
            if(this.failure < one.failure)
            {
                ret = 1;
            }
            else if(this.failure > one.failure)
            {
                ret = -1;
            }
            else
            {
                if(this.level < one.level)
                {
                    ret = 1;
                }
                else if(this.level > one.level)
                {
                    ret = -1;
                }
            }
            return ret;
        }
 */
    }
    public static void main(String[] args)
    {
        int[] answer = solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(answer));
    }
}
