# 내가 푼 코드를 개선한 코드

```java
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
```

# 개선한 코드 설명

lottos의 처음부터 마지막까지 반복하면서 배열요소에서 0의 값이 있으면 그 개수(zeroCount)를 세고,<br><br>
0이 아닌 값은 win_nums 배열요소의 처음부터 마지막까지 반복을 돌리면서 비교합니다.<br><br>
값이 같으면 그 개수(sameCount)를 세고, 중복이 없기 때문에<br><br>
win_nums 배열요소의 처음부터 마지막까지 반복하는 반복문을 빠져나와 lottos의 다음 배열요소로 이동하여 다음 반복을 시작합니다.<br><br>
이런식으로 반복문을 한번에 돌리고 끝이 나면 zeroCount와 sameCount에 유효한 값이 저장되어 있을 것입니다.<br><br>
zeroCount값이 6이면 최고순위가 1위가 될 수 있고, 최저순위가 6위가 될 수 있기 때문에 1, 6을 배열요소로 가지는 1차원배열을 반환합니다.<br><br>
그 이외에는 switch문을 통해 sameCount의 개수에 따라 최저순위(lowestRank)를 정하여 최저순위에서 0의 개수를 뺀값을 최고순위로 하고,<br><br>
최저순위(lowestRank)를 배열요소로 하는 1차원 배열을 반환합니다.<br><br>
최저순위에서 0의 개수에 따라 최고순위를 올릴 수 있기 때문에 최저순위에서 0의 개수를 뺀 값이 최고순위입니다.
