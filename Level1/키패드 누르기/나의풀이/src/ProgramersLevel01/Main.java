package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;

public class Main {

    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            Map<String, Integer> keypad = new HashMap<>();
            for(int i = 0; i < 10; i++)
            {
                keypad.put(Integer.toString(i), i);
            }
            keypad.put("*", 10);
            keypad.put("0", 11);
            keypad.put("#", 12);
            int leftThumbPos = keypad.get("*");
            int virtualLeftThumbPos = 0;
            int rightThumbPos = keypad.get("#");
            int virtualRightThumbPos = 0;
            int leftMoveCount = 0;
            int rightMoveCount = 0;
            int keypadNumber = 0;
            for(int i = 0; i < numbers.length; i++)
            {
                leftMoveCount = 0;
                rightMoveCount =0;
                if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
                {
                    answer += "L";
                    leftThumbPos = numbers[i];
                }
                else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
                {
                    answer += "R";
                    rightThumbPos = numbers[i];
                }
                //numbers[i]가 2, 5, 8, 0인 경우
                else
                {
                    //왼손 거리 계산
                    keypadNumber = keypad.get(Integer.toString(numbers[i]));
                    virtualLeftThumbPos = leftThumbPos;
                    if(keypadNumber > virtualLeftThumbPos)
                    {
                        while(keypadNumber != virtualLeftThumbPos)
                        {
                            if(keypadNumber - virtualLeftThumbPos >= 3)
                            {
                                virtualLeftThumbPos += 3;
                                leftMoveCount++;
                            }
                            else
                            {
                                virtualLeftThumbPos++;
                                leftMoveCount++;
                            }
                        }
                    }
                    else if(keypadNumber < virtualLeftThumbPos)
                    {
                        while(keypadNumber != virtualLeftThumbPos)
                        {
                            if((virtualLeftThumbPos - keypadNumber)%3 == 0)
                            {
                                virtualLeftThumbPos -= 3;
                                leftMoveCount++;
                            }
                            else
                            {
                                if(virtualLeftThumbPos - keypadNumber + 2 > 3)
                                {
                                    virtualLeftThumbPos -= 3;
                                    leftMoveCount++;
                                }
                                else
                                {
                                    virtualLeftThumbPos++;
                                    leftMoveCount++;
                                }
                            }
                        }
                    }
                    //오른손거리계산
                    keypadNumber = keypad.get(Integer.toString(numbers[i]));
                    virtualRightThumbPos = rightThumbPos;
                    if(keypadNumber > virtualRightThumbPos)
                    {
                        while(keypadNumber != virtualRightThumbPos)
                        {
                            if((keypadNumber - virtualRightThumbPos)%3 == 0)
                            {
                                virtualRightThumbPos += 3;
                                rightMoveCount++;
                            }
                            else
                            {
                                if(keypadNumber - virtualRightThumbPos + 2 > 3)
                                {
                                    virtualRightThumbPos += 3;
                                    rightMoveCount++;
                                }
                                else
                                {
                                    virtualRightThumbPos--;
                                    rightMoveCount++;
                                }
                            }
                        }
                    }
                    else if(keypadNumber < virtualRightThumbPos)
                    {
                        while(keypadNumber != virtualRightThumbPos)
                        {
                            if(virtualRightThumbPos - keypadNumber >= 3)
                            {
                                virtualRightThumbPos -= 3;
                                rightMoveCount++;
                            }
                            else
                            {
                                virtualRightThumbPos--;
                                rightMoveCount++;
                            }
                        }
                    }
                    if(leftMoveCount > rightMoveCount)
                    {
                        answer += "R";
                        rightThumbPos = virtualRightThumbPos;
                    }
                    else if(leftMoveCount < rightMoveCount)
                    {
                        answer += "L";
                        leftThumbPos = virtualLeftThumbPos;
                    }
                    else
                    {
                        if(hand.compareTo("left") == 0)
                        {
                            answer += "L";
                            leftThumbPos = virtualLeftThumbPos;
                        }
                        else
                        {
                            answer += "R";
                            rightThumbPos = virtualRightThumbPos;
                        }
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
