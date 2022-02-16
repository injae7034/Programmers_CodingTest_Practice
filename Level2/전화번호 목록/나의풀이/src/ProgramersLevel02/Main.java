package ProgramersLevel02;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>(){
            @Override
            public int compare(String one, String other)
            {
                int ret;
                if(one.length() > other.length())
                {
                    ret = 1;
                }
                else if(one.length() == other.length())
                {
                    ret = 0;
                }
                else
                {
                    ret = -1;
                }
                return ret;
            }
        });
        for(int i = 0; i < phone_book.length - 1; i++)
        {
            for(int j = i + 1;  j < phone_book.length; j ++)
            {
                if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length())) == true)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean answer = solution(new String[]{"119", "97674223", "1195524421"});
        System.out.println(answer);
	    answer = solution(new String[]{"123","456","789"});
        System.out.println(answer);
        answer = solution(new String[]{"12","123","1235","567","88"});
        System.out.println(answer);
    }
}
