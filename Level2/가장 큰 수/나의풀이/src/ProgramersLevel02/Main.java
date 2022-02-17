package ProgramersLevel02;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static String solution(int[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for(int number : numbers)
        {
            numberList.add(number);
        }
        Collections.sort(numberList, new Comparator<Integer>(){
            @Override
            public int compare(Integer one, Integer other)
            {
                List<Integer> oneList = new ArrayList<>();
                String oneString = String.valueOf(one);
                for(int i = 0; i < oneString.length(); i++)
                {
                    oneList.add(Integer.parseInt(String.valueOf(oneString.charAt(i))));
                }
                List<Integer> otherList = new ArrayList<>();
                String otherString = String.valueOf(other);
                for(int i = 0; i < otherString.length(); i++)
                {
                    otherList.add(Integer.parseInt(String.valueOf(otherString.charAt(i))));
                }

                while(oneList.size() > 1 || otherList.size() > 1)
                {
                    if(oneList.get(oneList.size() - 1) > otherList.get(otherList.size() - 1))
                    {
                        return 1;
                    }
                    else if(oneList.get(oneList.size() - 1) < otherList.get(otherList.size() - 1))
                    {
                        return -1;
                    }
                    else
                    {
                        if(oneList.size() > 1)
                        {
                            oneList.remove(oneList.size() - 1);
                        }
                        if(otherList.size() > 1)
                        {
                            otherList.remove(otherList.size() - 1);
                        }
                    }
                }
                if(oneList.get(oneList.size() - 1) > otherList.get(otherList.size() - 1))
                {
                    return 1;
                }
                else if(oneList.get(oneList.size() - 1) < otherList.get(otherList.size() - 1))
                {
                    return -1;
                }
                return 0;
            }
        });
        String answer = "";
        for(Integer number : numberList)
        {
            answer = String.valueOf(number) + answer;
        }
        return answer;
    }
    public static void main(String[] args) {
	    String answer = solution(new int[]{1, 10 ,100, 1000});
        System.out.println(answer);
    }
}
