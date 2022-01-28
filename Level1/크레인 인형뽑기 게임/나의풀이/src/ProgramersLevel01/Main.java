package ProgramersLevel01;

import java.util.Stack;

public class Main {

    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int doll = 0;
            Stack<Integer> basket = new Stack<>();
            for(int i = 0; i < moves.length; i++)
            {
                for(int j = 0; j < board.length; j++)
                {
                    doll = board[j][moves[i] - 1];
                    if(doll != 0)
                    {
                        if(basket.empty() == false)
                        {
                            if(doll == basket.peek())
                            {
                                basket.pop();
                                answer += 2;
                            }
                            else
                            {
                                basket.push(doll);
                            }
                        }
                        else
                        {
                            basket.push(doll);
                        }
                        board[j][moves[i] - 1] = 0;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
