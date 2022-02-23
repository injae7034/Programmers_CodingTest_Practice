package ProgramersLevel02;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    static Set<Integer> numberSet = new HashSet<>();
    public static int solution(String numbers)
    {
        //1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        //2. 소수의 개수만 센다.
        int answer = 0;
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext())
        {
            if(isPrimeNumber(it.next()) == true)
            {
                answer++;
            }
        }
        //3. 소수의 개수를 반환한다.
        return answer;
    }
    //모든 조합의 숫자를 만들 재귀함수
    public static void recursive(String comb, String others)
    {
        //1. 현재 조합이 빈칸이 아니면 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
        {
            numberSet.add(Integer.valueOf(comb));
        }
        //2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for(int i = 0; i < others.length(); i++)
        {
            String one = others.substring(0, i);
            String other = others.substring(i + 1);
            recursive(comb + others.charAt(i), one + other);
        }
    }
    //해당 숫자가 소수인지 판별해줄 메소드
    public static boolean isPrimeNumber(int number)
    {
        //1. 0과 1이면
        if(number == 0 || number == 1)
        {
            //1.1 0과 1은 소수가 아니기 때문에 false를 반환한다.
            return false;
        }
        //2. 에라토스테네스 체의 limit 숫자를 구한다.
        int limit = (int)Math.sqrt(number);
        //3. limit 숫자까지 배수를 구한다.
        for(int i = 2; i <= limit; i++)
        {
            if(number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
	    //int answer = solution("17");
        //System.out.println(answer);
        int answer = solution("011");
        System.out.println(answer);
    }
}
