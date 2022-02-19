package ProgramersLevel02;

public class Main {
    public static int solution(int[] arr) {
        int a;
        int b;
        int[] answer = new int[256];
        for(int i = 0; i <= 255; i++)
        {
            a = 0;
            b = 0;
            for(int j = 0; j < arr.length; j++)
            {
                if(i <= arr[j])
                {
                    a++;
                }
                else
                {
                    b++;
                }
            }
            answer[i] = Math.abs(a - b);
        }
        int min = answer[0];
        for(int i = 1; i < answer.length; i++)
        {
            min = Math.min(answer[i], min);
        }
        int index = 0;
        while(index < answer.length)
        {
            if(answer[index] == min)
            {
                break;
            }
            index++;
        }
        return index;
    }
    public static void main(String[] args) {
	    int answer = solution(new int[]{1,52,125,10,25,201,244,192,128,23,203,98,154,255});
        System.out.println(answer);
    }
}
