# 내가 푼 코드
```java
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
```

# 내가 푼 코드 설명

나의 로또 숫자가 저장된 크기가 6인 배열 lottos에서 값이 0인 배열요소의 위치를 저장할 indexesOfZero를 ArrayList\<Integer\>를 이용해 생성합니다.<br><br>
lottos에서 0이외의 값을 지닌 배열요소의 위치를 저장할 indexesOfOther를 ArrayList\<Integer\>를 이용해 생성합니다.<br><br>
lottos의 크기만큼 반복을 돌리면서 lottos에서 값이 0인 배열요소의 위치는 indexesOfZero에 저장하고, 그 이외의 값을 가진 배열요소는 indexesOfOther에 저장합니다.<br><br>
반복문을 빠져나와서 선택구조로 indexesOfZero의 size가 6인지 물어보고, size가 6이라면 lottos의 6개의 배열요소가 모두 0이라는 의미이기 때문에 최고순위는 1위, 최저순위는 6위를 가지는 배열을 출력하면서 메소드를 종료시킵니다.<br><br>
그 이외의 경우에는 else에서 처리해줍니다.<br><br>
먼저 indexesOfOther의 개수만큼 반복을 돌리면서 indexesOfOther에 저장된 배열요소(=lottos의 배열요소의 위치를 저장하고 있음)를 활용해 lottos에서 값이 0이 아닌 배열요소들을 하나하나씩 차례로 구합니다.<br><br>
그리고 다시 당첨번호를 저장하고 있는 win_nums배열의 크기만큼 반복을 돌리면서 lottos에서 0이 아닌 숫자와 win_nums의 숫자를 비교하여 그 값이 같으면 count를 세줍니다.<br><br>
indexesOfOther의 배열요소를 활용해 lottos에서 0이 아닌 배열요소를 구하고 그 값이 win_nums의 배열요소와 같다면 바로 break로 win_mums배열크기만큼 반복하는 반복문을 빠져나가서 indexesOfOther 크기만큼 반복하는 반복문으로 이동하여 indexesOfOther의 다음 원소를 구합니다.<br><br>
그 이유는 win_nums에서는 중복되는 숫자가 없고, lottos에서도 0을 제외한 숫자에서는 중복이 없기 때문에 서로 같은 숫자를 찾았다면 더이상 win_nums의 다른 원소와 비교할 필요가 없기 때문입니다.<br><br>
이렇게 이중반복구조를 통해 lottos에서 0을 제외한 숫자중에 win_nums와 같은 숫자의 count를 구합니다.<br><br>
이 후 swith 문을 통해 count가 0 또는 1이면 최저순위를 뜻하는 lowestRank 변수에 6을 입력하고, count가 2이면 5, count가 3이면 4, count가 4이면 3, count가 5이면 2, count가 6이면 1을 대입합니다.<br><br>
이 후 정답을 반환할 때 최저순위에는 lowestRank를 그대로 반영해서 반환하고, 최고순위에는 최저순위인 lowestRank에서 lottos에서 0의 값을 가진 배열요소의 개수를 뺀 값을 출력합니다.<br><br>
그 이유는 최저순위는 바꿀 수 없지만 0의 개수에 따라 최고 순위는 바꿀 수 있기 때문입니다.<br><br>
물론 0의 개수가 0이면 최고 순위도 바뀌지 않지만, 0의 개수가 많을수록 최저순위와 최고순위의 격차도 커집니다.

# 한계점

처음 lottos의 원소를 0과 0이 아닌 값으로 나눠서 위치를 저장할 때 win_nums와도 비교했으면 나중에 굳이 다시 반복문을 돌릴 필요가 없는데 그렇게 안해서 나중에 다시 이중반복문을 통해 win_num와 비교하고 있습니다.<br><br>
또한 swith에서 case를 사용할 때 사용법을 잘몰라서 case : 0과 case : 1을 별도로 구분해서 쓰고 있는데 이를 같이 써주면 불필요한 코드를 줄일 수 있습니다.

    
