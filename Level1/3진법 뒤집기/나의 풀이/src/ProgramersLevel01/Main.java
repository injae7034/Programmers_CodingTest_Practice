package ProgramersLevel01;

public class Main {
    public static int solution(int n) {
        String sum = "";
        while(n > 0)
        {
            sum += (n % 3);
            n /= 3;
        }
        return Integer.parseInt(sum, 3);
    }
    public static void main(String[] args) {
	    int answer =  solution(45);
        System.out.println(answer);
    }
}
