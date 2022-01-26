package ProgramersLevel01;

import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> indexesOfZero = new ArrayList<>();
        List<Integer> indexesOfOther = new ArrayList<>();
        for(int i = 0; i < lottos.length; i++)
        {
            if(lottos[i] == 0)
            {
                indexesOfZero.add(i);
            }
            else
            {
                indexesOfOther.add(i);
            }
        }
        int count = 0;
        if(indexesOfZero.size() == 6)
        {
            return new int[]{1,6};
        }
        else
        {
            for(int i = 0; i < indexesOfOther.size(); i++)
            {
                for(int j = 0; j < win_nums.length; j++)
                {
                    if(lottos[indexesOfOther.get(i)] == win_nums[j])
                    {
                        count++;
                        break;
                    }
                }
            }
            int lowestRank = 0;
            switch(count)
            {
                case 0:
                    lowestRank = 6;
                    break;
                case 1:
                    lowestRank = 6;
                    break;
                case 2:
                    lowestRank = 5;
                    break;
                case 3:
                    lowestRank = 4;
                    break;
                case 4:
                    lowestRank = 3;
                    break;
                case 5:
                    lowestRank = 2;
                    break;
                case 6:
                    lowestRank = 1;
                    break;
            }
            return new int[]{lowestRank - indexesOfZero.size(), lowestRank};
        }
    }
}