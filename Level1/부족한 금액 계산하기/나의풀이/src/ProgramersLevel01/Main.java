package ProgramersLevel01;

public class Main {
    public static long solution(int price, int money, int count) {
        long answer = 0;
        for(int i = 1; i <= count; i++)
        {
            answer += price * i;
        }
        answer -= money;
        if(answer < 0)
        {
            answer = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
	    long answer = solution(3, 20 ,4);
        System.out.println(answer);
    }
}
