package ProgramersLevel01;

public class Main {

    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int zeroCount = 0;//lottos에서 0의 개수
            int sameCount = 0;//lottos와 win_nums에서 일치하는 번호 개수
            for(int i = 0; i < lottos.length; i++)
            {
                if(lottos[i] == 0)
                {
                    zeroCount++;
                }
                else
                {
                    for(int j = 0; j < win_nums.length; j++)
                    {
                        if(lottos[i] == win_nums[j])
                        {
                            sameCount++;
                            break;
                        }
                    }
                }
            }
            if(zeroCount == 6)
            {
                return new int[]{1,6};
            }
            else
            {
                int lowestRank = 0;
                switch(sameCount)
                {
                    case 0: case 1:
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
                return new int[]{lowestRank - zeroCount, lowestRank};
            }
        }
    }
    public static void main(String[] args) {
	// write your code here
    }
}
