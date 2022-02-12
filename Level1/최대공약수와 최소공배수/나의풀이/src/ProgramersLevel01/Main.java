package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int[] solution(int n, int m) {
        List<Integer> nDivisors = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                nDivisors.add(i);
            }
        }
        List<Integer> mDivisors = new ArrayList<>();
        for(int i = 1; i <= m; i++)
        {
            if(m % i == 0)
            {
                mDivisors.add(i);
            }
        }
        int nIndex = 0;
        int mIndex = 0;
        int max = 0;
        boolean isDeleted = false;
        while(nIndex < nDivisors.size())
        {
            mIndex = 0;
            isDeleted = false;
            while(mIndex < mDivisors.size())
            {
                if(nDivisors.get(nIndex).equals(mDivisors.get(mIndex)) == true)
                {
                    max = nDivisors.get(nIndex);
                    nDivisors.remove(nIndex);
                    mDivisors.remove(mIndex);
                    isDeleted = true;
                    break;
                }
                else
                {
                    mIndex++;
                }
            }
            if(isDeleted == false)
            {
                nIndex++;
            }
        }
        int min = 0;
        int multiple = 2;
        int commonMultiple = 0;
        if(n < m)
        {
            commonMultiple = m;
            while(commonMultiple % n != 0)
            {
                commonMultiple = m * multiple;
                multiple++;
            }
        }
        else if(n > m)
        {
            commonMultiple = n;
            while(commonMultiple % m != 0)
            {
                commonMultiple = n * multiple;
                multiple++;
            }
        }
        else
        {
            commonMultiple = n;
        }
        min = commonMultiple;
        int[] answer = new int[]{max, min};
        return answer;
    }
    public static void main(String[] args) {
	    int[] answer = solution(13, 12);
        System.out.println(Arrays.toString(answer));
        answer = solution(2, 5);
        System.out.println(Arrays.toString(answer));
    }
}
