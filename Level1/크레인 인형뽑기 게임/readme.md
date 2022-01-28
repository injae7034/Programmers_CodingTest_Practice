# 내가 푼 코드
```java
import java.util.Stack;

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
```

# 내가 푼 코드 설명

문제 규칙에서 board의 배열요소는 1~100까지인데 각 숫자는 다른 인형을 의미하고,<br><br>
0은 인형이 없는 것을 의미합니다.<br><br>
그래서 int doll 변수를 만들어 0으로 초기화합니다.<br><br>
basket은 인형을 하나씩 아래부터 쌓기 때문에 Stack으로 자료구조를 정했습니다.<br><br>
moves는 크레인이 좌우로 움직이는 좌표를 나타내는데 배열요소 값은<br><br>
최소값 1부터 시작해서 board의 열의 길이가 최대값입니다.<br><br>
즉, 이 moves의 배열요소값에서 -1을 한 값이 board에서 열을 나타냅니다.<br><br>
-1을 하는 이유는 move는 1부터 시작하고, 배열은 0부터 시작하기 때문입니다.<br><br>
이 moves의 길이만큼 반복하면서 moves의 배열요소로부터 board 2차원 배열을 열을 구합니다.<br><br>
board는 1차원 배열을 배열요소로 가지는 2차원배열입니다.<br><br>
이 board의 2차원배열의 길이만큼 반복을 돌리는데,<br><br>
즉, board가 가지고 있는 1차원 배열의 개수만큼 반복을 돌립니다.<br><br>
board에서 추출하는 j는 board 2차원 배열에서 행을 의미하고,<br><br>
moves의 배열요소 moves[i]에서 1을 뺀값이 열을 의미합니다.<br><br>
이 값을 통해 board 2차원 배열의 배열요소의 값인 인형(doll)을 구합니다.<br><br>
doll값이 0이면 인형이 없다는 뜻이기 때문에 다음 행으로 이동합니다.<br><br>
규칙이 인형이 있을 때까지(doll값이 0이 아닌동안) 행으로 이동하면서 인형을 찾고<br><br>
행에 인형이 없으면 다음 moves의 배열요소값으로 움직일 열을 찾거나<br><br>
행에서 인형을 찾았으면 basket에 옮기는 작업을 하는 것입니다.<br><br>
그래서 먼저 해당 배열요소 위치에 인형이 있는지 확인을 합니다.<br><br>
doll이 0이 아니면 인형이 있다는 말이기 때문에 먼저 basket에 인형이 있는지 비어있는지 확인합니다.<br><br>
인형이 basket에 이미 있으면<br><br>
basket에서 제일 위에 있는 인형과 지금 basket에 옮기려고 하는 인형이 서로 같은 인형인지(=같은 숫자인지) 확인하여<br><br>
같은 인형이면 터뜨려줘야하는데<br><br>
이를 표현하기 위해 현재 basket에 있는 인형을 pop해주면<br><br>
현재 넣으려는 인형과 현재 basket에서 가장 위에 위치한 인형이 사라지기 때문에<br><br>
answer의 값을 +2를 시켜서 누적시켜주면 인형 2개를 터뜨린 표현이 됩니다.<br><br>
만약에 현재 넣으려는 인형과 basket에 가장 위에 있는 인형이 서로 다르면(=서로 다른 숫자이면)<br><br>
basket에 현재 넣으려는 인형을 push합니다.<br><br>
그리고 만약에 basket이 비어있다면 무조건 인형을 push합니다.<br><br>
그리고 현재 board에서 인형을 꺼냈기 때문에 해당 board 위치에 있는 인형을 꺼낸 표시,<br><br>
즉, 인형을 꺼내서 basket에 넣었기 때문에 더이상 인형이 없다는 표시로<br><br>
해당 board위치에 0을 대입해줘야 합니다.<br><br>
그리고 인형을 board에서 꺼냈기 때문에 더이상 열단위로 이동하며 인형을 찾을 필요 없고,<br><br>
크레인이 다음으로 움직이도록 해야하기 때문에 열의 반복문을 벗어나도록 break하여<br><br>
행의 이동을 나타내는 반복문으로 바로 이동을 시킵니다.<br><br>
이런식으로 moves의 마지막까지 반복을 마치고 나면 answer에는 터뜨린 인형 개수가 누적되어 있을 것입니다.<br><br>

# 문제를 풀면서 느낀 아쉬운 점 및 깨달은 점

처음에 문제를 잘못읽어서 행과 열을 헷갈렸는데 문제에서 제시한 예시를 직접 2차원배열을 그려보니 이해할 수 있었습니다.<br><br>
그리고 다음으로 0이 아닌 동안, 즉, 인형을 찾을 동안 열에서 반복을 돌리는데, 인형을 찾아서 basket에 넣었으면<br><br>
해당 열에서는 더이상 인형을 꺼내면 안되게 반복을 탈출하도록 break를 해야하는데 이를 미처 생각하지 못해서 원하는 결과를 얻지 못했습니다.<br><br>
그리고 나중에 디버깅하다가 이를 발견하여 break를 넣어줬는데 그래도 안되서 뭐가 문제지 계속 고민하다가<br><br>
깨달은 것이 board에서 인형을 꺼내서 basket에 넣었으면 board의 해당 위치에는 이제 인형이 없는 것인데 이 인형이 없다는 표시를 안해줘서<br><br>
다음에도 꺼낸 인형을 다시 꺼내는 문제가 발생하여 원하는 결과를 얻지 못했습니다.<br><br>
즉, board에서 인형을 꺼내서 basket에 넣었으면 board의 해당위치에 0을 대입함으로써 인형을 꺼냈다는 표시를 해야<br><br>
다음에 다시 이 행으로 왔을 때 다음에 안꺼낸 인형(숫자)를 꺼내서 정상적으로 인형을 터뜨릴수 있습니다.<br><br>
문제가 안풀리는데는 이유가 있는데 "왜 맞는데 틀리지?"라고 생각하지말고<br><br>
내가 어디서 생각하지 못한 지점이 있는지 좀 더 종합적으로 생각해보도록 노력해야겠습니다.
