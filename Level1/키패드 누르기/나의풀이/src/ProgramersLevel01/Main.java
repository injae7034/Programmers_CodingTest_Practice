package ProgramersLevel01;

import java.util.Map;
import java.util.HashMap;

public class Main {

    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            //키패드 번호 숫자로 치환해주기
            Map<String, Integer> keypad = new HashMap<>();
            for(int i = 0; i < 10; i++)
            {
                keypad.put(Integer.toString(i), i);
            }
            keypad.put("*", 10);
            keypad.put("0", 11);
            keypad.put("#", 12);
            //왼손엄지위치를 초기화시켜준다.
            int leftThumbPos = keypad.get("*");
            //가상의 왼손엄지 위치를 초기화시켜준다.(실제로 이동X, 이동거리 잴 때 사용)
            int virtualLeftThumbPos = 0;
            //오른손엄지위치를 초기화시켜준다.
            int rightThumbPos = keypad.get("#");
            //가상의 오른손엄지 위치를 초기화시켜준다.(실제로 이동X, 이동거리 잴 때 사용)
            int virtualRightThumbPos = 0;
            //왼손엄지 움직인 횟수(거리)
            int leftMoveCount = 0;
            //오른손엄지 움직인 횟수(거리)
            int rightMoveCount = 0;
            //키패드에서 눌러야할 번호위치
            int keypadNumber = 0;
            //매개변수로 입력받은 숫자배열의 처음부터 마지막까지 반복한다.
            for(int i = 0; i < numbers.length; i++)
            {
                //왼손엄지와 오른손엄지의 이동거리를 초기화시켜준다.
                leftMoveCount = 0;
                rightMoveCount =0;
                //눌러야 하는 숫자가 1 또는 4 또는 7이면
                if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7)
                {
                    //왼손엄지로 누른다.
                    answer += "L";
                    //왼손엄지 위치를 눌러야 하는 숫자 위치로 이동시킨다.
                    leftThumbPos = numbers[i];
                }
                //눌러야 하는 숫자가 3 또는 6 또는 9이면
                else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9)
                {
                    //오른손엄지로 누른다.
                    answer += "R";
                    //오른손엄지 위치를 눌러야 하는 숫자 위치로 이동시킨다.
                    rightThumbPos = numbers[i];
                }
                //눌러야 하는 숫자가 2, 5, 8, 0인 경우
                else
                {
                    //왼손엄지와 눌러야 하는 숫자간의 거리구하기
                    //눌러야 하는 숫자를 구한다.
                    keypadNumber = keypad.get(Integer.toString(numbers[i]));
                    //가상의 왼손 엄지 위치에 현재 진짜 왼손엄지가 있는 위치를 대입한다.
                    virtualLeftThumbPos = leftThumbPos;
                    //눌러야하는 숫자가 가상의 왼손 엄지 위치보다 아래에 있으면
                    if(keypadNumber > virtualLeftThumbPos)
                    {
                        //눌러야 하는 숫자와 가상의 왼손 엄지 위치가 다를 동안 반복한다.
                        while(keypadNumber != virtualLeftThumbPos)
                        {
                            //가상의 왼손 엄지를 아래로 이동시켜야 하면
                            if(keypadNumber - virtualLeftThumbPos >= 3)
                            {
                                //가상의 왼손엄지를 아래로 이동시킨다.
                                virtualLeftThumbPos += 3;
                                //왼손엄지가 이동한 거리를 증가시킨다.
                                leftMoveCount++;
                            }
                            //가상의 왼손 엄지를 오른쪽으로 이동시켜야 하면
                            else
                            {
                                //가상의 왼손엄지를 오른쪽으로 이동시킨다.
                                virtualLeftThumbPos++;
                                //왼손엄지가 이동한 거리를 증가시킨다.
                                leftMoveCount++;
                            }
                        }
                    }
                    //눌러야 하는 숫자가 가상의 왼손 엄지 위치보다 위에 있으면
                    else if(keypadNumber < virtualLeftThumbPos)
                    {
                        //눌러야 하는 숫자와 가상의 왼손 엄지가 다를 동안 반복한다.
                        while(keypadNumber != virtualLeftThumbPos)
                        {
                            //가상의 왼손 엄지를 위로만 이동시켜도 눌러야 하는 숫자에 도달할 수 있으면
                            if((virtualLeftThumbPos - keypadNumber)%3 == 0)
                            {
                                //가상의 왼손 엄지를 위로 이동시킨다.
                                virtualLeftThumbPos -= 3;
                                //왼손엄지가 이동한 거리를 증가시킨다.
                                leftMoveCount++;
                            }
                            //가상의 왼손 엄지를 위와 오른쪽 둘다 이동시켜야만 눌러야 하는 숫자에 도달할 수 있으면
                            else
                            {
                                //가상의 왼손 엄지를 위로 이동해야하면
                                if(virtualLeftThumbPos - keypadNumber + 2 > 3)
                                {
                                    //가상의 왼손 엄지를 위로 이동시킨다.
                                    virtualLeftThumbPos -= 3;
                                    //왼손엄지가 이동한 거리를 증가시킨다.
                                    leftMoveCount++;
                                }
                                //가상의 왼손엄지를 오른쪽으로 이동시켜야 하면
                                else
                                {
                                    //가상의 왼손 엄지를 오른쪽으로 이동시킨다.
                                    virtualLeftThumbPos++;
                                    //왼손엄지가 이동한 거리를 증가시킨다.
                                    leftMoveCount++;
                                }
                            }
                        }
                    }
                    //오른손엄지와 눌러야 하는 숫자간의 거리구하기
                    //눌러야 하는 숫자를 구한다.
                    keypadNumber = keypad.get(Integer.toString(numbers[i]));
                    //가상의 오른손 엄지 위치에 현재 진짜 오른손엄지가 있는 위치를 대입한다.
                    virtualRightThumbPos = rightThumbPos;
                    //눌러야 하는 숫자 위치가 가상의 오른손엄지보다 아래에 있으면
                    if(keypadNumber > virtualRightThumbPos)
                    {
                        //눌러야 하는 숫자 위치와 가상의 오른손엄지 위치가 다를 동안 반복한다.
                        while(keypadNumber != virtualRightThumbPos)
                        {
                            //가상의 오른손 엄지를 아래로만 이동시켜도 눌러야 하는 숫자에 도달할 수 있으면
                            if((keypadNumber - virtualRightThumbPos)%3 == 0)
                            {
                                //가상의 오른손 엄지를 아래로 이동시킨다.
                                virtualRightThumbPos += 3;
                                //오른손 엄지가 이동한 거리를 증가시킨다.
                                rightMoveCount++;
                            }
                            //가상의 오른손 엄지를 아래와 왼쪽 둘다 이동시켜야 눌러야 하는 숫자에 도달할 수 있으면
                            else
                            {
                                //가상의 오른손 엄지를 아래로 이동시켜야 하면
                                if(keypadNumber - virtualRightThumbPos + 2 > 3)
                                {
                                    //가상의 오른손 엄지를 아래로 이동시켜야 한다.
                                    virtualRightThumbPos += 3;
                                    //오른손 엄지가 이동한 거리를 증가시킨다.
                                    rightMoveCount++;
                                }
                                //가상의 오른손 엄지를 왼쪽으로 이동시켜야 하면
                                else
                                {
                                    //가상의 오른손 엄지를 왼쪽으로 이동시켜야 한다.
                                    virtualRightThumbPos--;
                                    //오른손 엄지가 이동한 거리를 증가시킨다.
                                    rightMoveCount++;
                                }
                            }
                        }
                    }
                    //눌러야 하는 숫자 위치가 가상의 오른손엄지보다 위에 있으면
                    else if(keypadNumber < virtualRightThumbPos)
                    {
                        //눌러야 하는 숫자 위치가 가상의 오른손엄지 위치와 다른동안 반복한다.
                        while(keypadNumber != virtualRightThumbPos)
                        {
                            //가상의 오른손엄지를 위로 이동시켜야 하면
                            if(virtualRightThumbPos - keypadNumber >= 3)
                            {
                                //가상의 오른손엄지를 위로 이동시킨다.
                                virtualRightThumbPos -= 3;
                                //오른손 엄지가 이동한 거리를 증가시킨다.
                                rightMoveCount++;
                            }
                            //가상의 오른손엄지를 왼쪽으로 이동시켜야 하면
                            else
                            {
                                //가상의 오른손엄지를 왼쪽으로 이동시킨다.
                                virtualRightThumbPos--;
                                //오른손 엄지가 이동한 거리를 증가시킨다.
                                rightMoveCount++;
                            }
                        }
                    }
                    //왼손엄지가 이동한 거리가 오른손 엄지가 이동한 거리보다 크면
                    if(leftMoveCount > rightMoveCount)
                    {
                        //오른손엄지를 이동시켜 번호를 누른다.
                        answer += "R";
                        //현재 오른손 엄지를 가상의 오른손엄지 위치로 이동시킨다.
                        rightThumbPos = virtualRightThumbPos;
                    }
                    //왼손엄지가 이동한 거리가 오른손 엄지가 이동한 거리보다 작으면
                    else if(leftMoveCount < rightMoveCount)
                    {
                        //왼손엄지를 이동시켜 번호를 누른다.
                        answer += "L";
                        //현재 왼손 엄지를 가상의 왼손엄지 위치로 이동시킨다.
                        leftThumbPos = virtualLeftThumbPos;
                    }
                    //왼손엄지와 오른손 엄지가 이동한 거리가 같으면
                    else
                    {
                        //왼손잡이이면
                        if(hand.compareTo("left") == 0)
                        {
                            //왼손엄지를 이동시켜 번호를 누른다.
                            answer += "L";
                            //현재 왼손 엄지를 가상의 왼손엄지 위치로 이동시킨다.
                            leftThumbPos = virtualLeftThumbPos;
                        }
                        //오른손잡이이면
                        else
                        {
                            //오른손엄지를 이동시켜 번호를 누른다.
                            answer += "R";
                            //현재 오른손 엄지를 가상의 오른손엄지 위치로 이동시킨다.
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
