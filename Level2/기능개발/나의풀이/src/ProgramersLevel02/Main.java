package ProgramersLevel02;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progressesList = new ArrayList<>();
        List<Integer> speedsList = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++)
        {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }
        int count;
        List<Integer> countList = new ArrayList<>();
        while(progressesList.size() > 0)
        {
            count = 0;
            for(int i = 0; i < progressesList.size(); i++)
            {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
            while(progressesList.size() > 0 && progressesList.get(0) >= 100)
            {
                count++;
                progressesList.remove(0);
                speedsList.remove(0);
            }
            if(count > 0)
            {
                countList.add(count);
            }
        }
        int[] answer = new int[countList.size()];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = countList.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] answer = solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(answer));
    }
}
