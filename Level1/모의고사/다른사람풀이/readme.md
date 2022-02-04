# 다른 사람이 푼 코드

```java
public class Solution
{
    public static int[] solution(int[] answers)
    {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] hitCounts = new int[3];
        for(int i = 0; i < hitCounts.length; i++)
        {
            for(int j = 0; j < answers.length; j++)
            {
                if(patterns[i][j % patterns[i].length] == answers[j])
                {
                    hitCounts[i]++;
                }
            }
        }
        int max = Math.max(hitCounts[0], Math.max(hitCounts[1], hitCounts[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hitCounts.length; i++)
        {
            if(max == hitCounts[i])
            {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for(int number : list)
        {
            answer[index++] = number;
        }
        return  answer;
    }
}
```

# 다른 사람이 푼 코드 해석하며 공부하기

먼저 2차원 배열 patterns를 생성하는데<br><br>
수포자1, 수포자2, 수포자3의 문제 찍는 패턴을 배열요소로 초기화시켜줍니다.<br><br>
1차원 정수배열인 hitCounts를 생성하는데 크기는 3으로 하고,<br><br>
각 배열요소는 수포자1, 2, 3이 문제를 맞힌 개수입니다.<br><br>
i = 0부터 hitCounts의 length만큼 반복을 하고,<br><br>
반복문 내부에서 다시 j = 0부터 매개변수로 입력 받은 answers 배열의 length만큼 반복을 합니다.<br><br>
patterns의 i번째 배열요소(1차원배열)에서 반복제어변수 j를<br><br>
patterns의 i번째 배열요소인 1차원 배열의 길이만큼 나눈 값의 나머지번째 배열요소와<br><br>
answers의 j번째 배열요소와 값을 비교하여 그 값이 같으면<br><br>
hitCounts의 i번째 배열요소를 증가시켜줍니다.<br><br>
patterns의 i번째 배열요소(1차원배열)에서 반복제어변수 j를<br><br>
patterns의 i번째 배열요소인 1차원 배열의 길이만큼 나눈 값의 나머지를 구하면<br><br>
answers의 length가 patterns의 배열요소인 1차원 배열의 길이보다 길어도<br><br>
patterns의 배열요소인 1차원 배열의 첨자로 이용되는 j값을 초기화하지 않아도 됩니다.<br><br>
예를 들어, patterns의 0번째 배열요소는 {1, 2, 3, 4, 5}이고,<br><br>
answers의 배열요소가 {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}일 때<br><br>
위의 코드대로 하면 반복문 내부에서 최초에는 i와 j가 0이고,<br><br>
j를 patterns의 0번째 배열요소의 길이인 5로 나눈 값의 나머지는 0입니다.<br><br>
그래서 patterns의 0번째 배열요소의 0번째 배열요소인 1의 값을 얻을 수 있고,<br><br>
이를 answers의 0번째 배열요소인 0과 값이 같기 때문에 hitCounts의 0번째 배열요소 값을 증가시킵니다.<br><br>
i는 그대로 0이고 j는 1이 되었을 때 나머지값은 1이 되기 때문에<br><br>
patterns의 0번째 배열요소의 1번째 배열요소인 2의 값을 얻을 수 있고,<br><br>
이를 answers의 1번째 배열요소인 2와 값이 같기 때문에 hitCounts의 0번째 배열요소 값을 증가시킵니다.<br><br>
이런식으로 순차적으로 j값을 증가시키면 배열첨자가 순차적으로 증가하듯이 나머지가 순차적으로 증가하게 됩니다.<br><br>
이 때 j가 patterns의 0번째 배열요소의 length를 넘어서도 여전히 나머지를 활용하기 때문에<br><br>
j는 다시 patterns의 0번째 배열요소의 처음 배열첨자로 돌아갑니다.<br><br>
아무튼 이렇게 나머지를 활용하면 간단하게 한 줄로 수포자의 패턴과 answers를 비교하여 맞힌 개수를 셀 수 있습니다.<br><br>
다음으로 max값을 구하는데 이 때는 Math클래스의 정적메소드인 math를 이용합니다.<br><br>
매개변수로 입력한 2개의 값 중에 더 큰 값을 반환합니다.<br><br>
이를 활용하여 hitCounts배열에서 최대값(max)을 구합니다.<br><br>
다음으로 list를 ArrayList의 생성자를 이용해 생성하고, 자료형은 Integer로 설정합니다.<br><br>
i는 0부터 시작해서 hitCounts의 length만큼 반복을 돌리면서 hitCounts의 배열요소와 max를 비교합니다.<br><br>
max와 hitCounts의 배열요소의 값이 같으면 그 배열첨자에 +1을 한 값을 list에 add합니다.<br><br>
list에는 최대 문제를 맞힌 수포자들의 순서대로 저장되어 있습니다.<br><br>
이를 활용하여 list의 size만큼 answer배열을 힙에 할당합니다.<br><br>
list에 저장된 원소를 구하기 위해 for each 반복을 합니다.<br><br>
반복문 내부에서 순차적으로 list에 저장된 값을 answer의 배열요소에 저장하고,<br><br>
반복문이 끝나면 answer배열을 반환합니다.

# 느낀점

저는 나머지를 활용하는 방법을 생각하지 못해서 수포자의 length와 배열첨자를 비교하여<br><br>
배열첨자가 더 커지는 경우 배열첨자를 다시 초기화시켜줬는데 이를 활용하다 보니 코드가 길어지고<br><br>
매번 선택구조로 이를 확인해야 했기 때문에 효율성도 떨어졌습니다.<br><br>
원리는 비슷했기 때문에 조금만 더 생각을 했다면 도출해낼 수 있었는데, 못한 점이 아쉽고,<br><br>
나머지 변수들도 2차원배열이나 1차원 배열을 활용하지 않고, 각각 변수로 둬서 변수 개수가 많아진 것도 아쉽습니다.<br><br>
마지막으로 최대값을 구할 때, Math의 max메소드 존재자체를 몰라서 직접 로직을 짜서 구하다보니 코드가 길어졌습니다.<br><br>
다음에는 최대값을 구할 상황이 생기면 Math의 max메소드를 활용하도록 해야겠습니다.
