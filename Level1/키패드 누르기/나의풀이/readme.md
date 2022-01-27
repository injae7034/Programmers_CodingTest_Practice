# 내가 푼 코드

```java
import java.util.Map;
import java.util.HashMap;

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
```

# 내가 푼 코드 설명

키패드의 경우 1~9까지는 순차적으로 증가하는 숫자이나 0은 위치상 아래에 있는데 순차적으로 증가하는 숫자가 아니고, \*과 \#은 숫자가 아닙니다.<br><br>
나중에 엄지손가락과 누를 번호간의 거리를 구할 때 엄지손가락이 위치한 숫자에서 덧셈 또는 뺄셈을 하면서 누를 번호로 이동하는데 그 때 횟수를 세어서 거리를 구합니다.<br><br>
그러나 이 때 0이나 처음 엄지손이 위치한 \*과 \#에서는 덧셈 또는 뺄셈을 해서 이동하기에 문제가 있습니다.<br><br>그래서 이를 숫자로 치환해주기 위해서 Map을 사용합니다.<br><br>
Key값으로는 String으로 정하고, Value값을 Integer로 설정합니다.<br><br> 
keypad라는 Map객체를 HashMap생성자를 이용해 생성합니다.<br><br>
1부터 시작해서 10보다 작은 동안 반복을 돌리면서 숫자를 차례로 Integer의 toString메소드를 이용해 문자열로 바꿔준다음에 이 값을 Map의 put메소드의 매개변수에 key값에 넣고, Value값에 숫자를 넣어서 해쉬맵에 원소를 추가합니다.<br><br>
반복구조를 나오면 "\*"을 Key값으로 하고, Value값은 10으로 설정합니다.<br><br>
"0"을 Key값으로 하고, Value값은 11로 설정합니다.<br><br>
"\#"을 Key값으로 하고, Value값은 12로 설정합니다.<br><br>
왼손엄지위치인 int leftThumbPos에 HashMap의 메소드인 get에 매개변수로 Key값인 \*을 전달하여 10을 반환받습니다.<br><br>
오른손엄지위치인 int rightTHumbPos에 HashMap의 메소드인 get에 매개변수로 Key값인 \#을 전달하여 12를 반환받습니다.<br><br>
그리고 leftThumbPos와 rightTHumbPos가 실제로 현재 위치한 엄지손가락 위치라면 눌러야 하는 번호와 엄지손가락 사이의 거리를 재기 위해 virtualLeftTHumbPos와 virtualRightTHumbPos를 임시 저장공간으로 이용합니다.<br><br>
엄지손가락이 움직여야 할 횟수(거리)를 나타내는 leftMoveCount와 rightMoveCount를 0으로 초기화시켜줍니다.<br><br>
그런 다음 매개변수로 입력 받은 숫자배열을 개수만큼 반복을 돌립니다.<br><br>
1, 4, 7일 경우 무조건 왼손엄지를 이용하고, 3, 6, 9일 경우 무조건 오른손엄지를 이용하기 때문에 간단합니다.<br><br>
0, 2, 5, 8일 경우 왼손엄지와 오른손엄지중에 더 가까운 거리에 있는 엄지를 이용해야 하는데 이 경우가 복잡합니다.<br><br>
거리를 구하는 원리는 다음과 같습니다.<br><br>
엄지의 위치(숫자)를 눌러야 하는 숫자와 일치시키기 위해 덧셈 또는 뺄셈을 하고, 그 과정에서 횟수를 세는데 그 횟수가 거리를 의미합니다.<br><br>
엄지가 아래로 이동하면 +3, 오른쪽으로 이동하면 +1입니다.<br><br>
위쪽으로 이동하면 -3, 왼쪽으로 이동하면 -1입니다.<br><br>
이 과정이 좀 복잡한데 왼손엄지위치(숫자)보다 눌러야 하는 번호가 더 크면 상대적으로 간단합니다.<br><br>
왼손엄지위치(숫자)가 눌러야 하는 번호와 같아질 때까지 반복하는데 눌러야 하는 번호에서 왼손엄지위치를 뺀 값이 3보다 크거나 같으면 왼손엄지위치(숫자)를 3 증가시켜주고 왼손엄지이동거리를 +1 해줍니다.<br><br>
눌러야 하는 번호에서 왼손엄지위치를 뺀 값이 3보다 작으면 왼손엄지위치(숫자)를 1 증가시켜주고 왼손엄지이동거리를 +1 해줍니다.<br><br>
왼손엄지위치(숫자)보다 눌러야 하는 번호보다 더 작으면 이제 상대적으로 조금 더 복잡해집니다.<br><br>
왼손엄지위치(숫자)가 눌러야 하는 번호와 같아질 때까지 반복을 합니다.<br><br>
왼손엄지위치(숫자)와 눌러야 하는 번호가 같은 라인에 있으면, 즉 엄지손가락이 위로만 이동하면 눌러야하는 번호에 닿을 수 있으면 왼손엄지위치(숫자)를 3 감소시켜주고, 왼손엄지이동거리를 +1 해줍니다.<br><br>
왼손엄지가 위와 오른쪽 둘다 이동을 시켜야하면 좀 복잡한 수식인데 virtualLeftThumbPos - keypadNumber + 2 가 3보다 크면 왼손엄지위치(숫자)를 3 감소시켜주고, 왼손엄지이동거리를 +1 해줍니다.<br><br>
virtualLeftThumbPos - keypadNumber + 2 가 3보다 작으면 왼손엄지위치(숫자)를 1증가시켜주고, 왼손엄지이동거리를 +1 해줍니다.<br><br>
virtualLeftThumbPos - keypadNumber에서 +2를 해주는 이유는 virtualLeftThumbPos - keypadNumber만 해주면 virtualLeftThumbPos에 -3이 한번 덜되어서(위로 이동이 한번 덜되어서) 오른쪽으로 이동(+1)하는 것이 여러번 되기 때문에 잘못된 결과가 나오는 것을 방지하기 위한 처리입니다.<br><br>
그래서 인위적으로 차에 +2를 해주면 정상적으로 위로 이동을 한 뒤에 오른쪽으로 한칸만 이동하면 정확하게 이동할 수 있습니다.<br><br>
오른손엄지위치이동 시 거리를 측정하는 방법도 왼손엄지와 동일합니다.<br><br>
이 후 이동거리에 따라서 왼손엄지로 이동할지 오른손엄자로 이동할지 결정합니다.<br><br>
이동거리가 같으면 매개변수로 입력받은 hand에 따라서 왼손잡이인지 오른손잡이인지에 따라 결정합니다.<br><br>
이 때 유의할 점이 실제엄지위치와 가상엄지위치를 구분하여야 한다는 점입니다.<br><br>
거리를 계산할 때 실제엄지위치로 하면 나중에 거리계산시 오류가 발생하기 때문에 가상엄지위치를 이용해 거리계산을 하고, 해당 엄지로 이동하는 것이 확정되었을 때 실제엄지위치에 가상엄지위치값을 저장하고, 이동하지 않는 경우 실제엄지위치는 그대로 있어야 합니다.

# 한계점
네 저도 압니다;; 너무 너무 복잡합니다ㅠ<br><br>
문제를 풀다 계속 막히고, 2차원 배열을 이용해서 한번해볼수 있지 않을까 고민하다가 거리 이동을 도저히 계산을 못해서 어떻게든 해결을 해야겠다 싶어서<br><br>
해쉬맵을 적용하였고, 위로 이동은 -3, 아래이동은 +3 왼쪽이동은 -1, 오른쪽이동은 +1 이런식으로 이동시키도록 규칙을 세웠습니다.<br><br>
그러다 보니 그 과정에서 너무 복잡해졌습니다.<br><br>
**왜 2차원 배열에서 좀 더 생각을 하지 못했을까?**<br><br>
그리고 **절대값을 사용하면 더 편하다는 것을 구현하면서 깨달았는데** 자바에서 절대법을 사용하는 방법을 몰라서 사용하지 않았는데 **왜 검색해서 알아볼 생각을 하지 않았을까?**<br><br>
여러모로 어떻게든 구현만 해야겠다는 생각이 앞서서 코드가 너무 복잡하고 길어졌습니다.<br><br>
그리고 다음부터는 **코드가 복잡하고, 길어질수록 메소드 하나로 문제를 해결하려고 하지 말고, 여러 메소드로 나누고, 멤버를 이용하여 분산해서 문제를 해결할 수 있도록 노력해야겠습니다.**
