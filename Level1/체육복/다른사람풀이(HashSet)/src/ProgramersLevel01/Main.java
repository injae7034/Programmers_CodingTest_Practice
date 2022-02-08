package ProgramersLevel01;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //Set을 생성한다.
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        //Set을 초기화한다.
        for(int i : reserve)
        {
            reserveSet.add(i);
        }
        for(int i : lost)
        {
            if(reserveSet.contains(i))
            {
                reserveSet.remove(i);
            }
            else
            {
                lostSet.add(i);
            }
        }
        //여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for(int i : reserveSet)
        {
            if(lostSet.contains(i - 1))
            {
                lostSet.remove(i - 1);
            }
            else if(lostSet.contains(i + 1))
            {
                lostSet.remove(i + 1);
            }
        }
        //학생수에서 체육복이 없는 학생수를 뺀 결과를 반환한다.
        return n - lostSet.size();
    }
}