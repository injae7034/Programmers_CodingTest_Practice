package ProgramersLevel02;

import java.util.PriorityQueue;

public class Main {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++)
        {
            priorityQueue.offer(scoville[i]);
        }
        Integer first;
        Integer second;
        int answer = 0;
        while(priorityQueue.peek() < K && priorityQueue.size() > 1)
        {
            first = priorityQueue.poll();
            second = priorityQueue.poll();
            first += second * 2;
            priorityQueue.offer(first);
            answer++;
        }
        if(priorityQueue.size() == 1 && priorityQueue.peek() < K)
        {
            return -1;
        }
        return answer;
    }
    public static void main(String[] args) {
	    int answer = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(answer);
    }
}
