package ProgramersLevel01;

public class Main {
    public static int solution(int left, int right) {
        int answer = 0;
        int count = 0;
        for(int i = left; i <= right; i++)
        {
            count = 0;
            for(int j = 1; j <= i; j++)
            {
                if(i % j == 0)
                {
                    count++;
                }
            }
            if(count % 2 == 0)
            {
                answer += i;
            }
            else
            {
                answer -= i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
	    int answer = solution(13, 17);
        System.out.println(answer);
        answer = solution(24, 27);
        System.out.println(answer);
    }
}
