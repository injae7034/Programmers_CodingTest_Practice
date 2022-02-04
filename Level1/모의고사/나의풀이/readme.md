# 내가 푼 코드
```java
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int countOne = 0;
        int countTwo = 0;
        int countThree = 0;
        int[] one = new int[]{1, 2, 3, 4, 5};
        int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int i = 0;
        int j = 0;
        int k = 0;
        for(int l = 0; l < answers.length; l++)
        {
            if(i >= one.length)
            {
                i = 0;
            }
            if(answers[l] == one[i])
            {
                countOne++;
            }
            i++;
            if(j >= two.length)
            {
                j = 0;
            }
            if(answers[l] == two[j])
            {
                countTwo++;
            }
            j++;
            if(k >= three.length)
            {
                k = 0;
            }
            if(answers[l] == three[k])
            {
                countThree++;
            }
            k++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, countOne);
        map.put(2, countTwo);
        map.put(3, countThree);
        int max = 0;
        for(int m = 1; m < 4; m++)
        {
            if(max < map.get(m))
            {
                max = map.get(m);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int m = 1; m < 4; m++)
        {
            if(max == map.get(m))
            {
                list.add(m);
            }
        }
        int[] answer = new int[list.size()];
        for(int m = 0; m < answer.length; m++)
        {
            answer[m] = list.get(m);
        }
        return answer;
    }
}
```

# 내가 푼 코드 설명

countOne은 수포자1, countTwo는 수포자2, countThree는 수포자 3이 맞힌 문제 개수를 저장합니다.<br><br>
정수 배열 one은 수포자1의 찍는 패턴, two는 수포자2의 찍는 패턴, three는 수포자3의 찍는 패턴을 저장합니다.<br><br>
매개변수로 입력 받은 정수배열 answers의 length만큼 반복을 돌립니다.<br><br>
반복문 내부에서 one배열의 첨자로 사용될 i가 one의 length보다 크거나 같으면 0으로 초기화시켜줍니다.<br><br>
그 이유는 answers.length가 one.length보다 더 큰 경우 때문입니다.<br><br>
좀 더 구체적으로 설명하면 one의 경우 1, 2, 3, 4, 5 이렇게 5개의 배열원소만 있는데<br><br>
answers의 크기는 5보다 작을 수도 있고, 클 수도 있습니다.<br><br>
5보다 작다면 문제가 없지만 5보다 크다면 one.legnth를 벗어나는 indexOutOfBoundExeception이 발생합니다.<br><br>
또한 1, 2, 3, 4, 5의 패턴도 지킬 수 없기 때문에 제대로 된 정답을 도출할 수 없습니다.<br><br>
그래서 이를 방지하기 위해 one의 배열첨자로 사용되는 i가 one.lenght보다 커지는 경우 0으로 초기화시켜줍니다.<br><br>
다음으로 answers의 l번째 배열요소와 one의 i번째 배열요소가 같으면<br><br>
수포자1이 문제를 맞힌 개수인 countOne을 +1 증가시켜줍니다.<br><br>
이 후 two와 three도 one에서 설명한 것과 같은 원리입니다.<br><br>
이렇게 반복문이 끝나고 나면 수포자1, 2, 3이 문제를 맞힌 개수를 알 수 있습니다.<br><br>
이제 이를 바탕으로 Map의 객체를 생성하는데<br><br>
key값은 Integer인데 수포자 순서를 나타내는 1, 2, 3입니다.<br><br>
Value값도 Integer인데 수포자들이 맞힌 문제 개수입니다.<br><br>
put메소드를 통해 각각의 key값과 value값을 저장합니다.<br><br>
다음으로 가장 큰 값을 저장하는 max변수를 선언하고 0으로 초기화합니다.<br><br>
반복제어변수 m은 1부터 시작해서 4보다 작은 동안 반복을 합니다.<br><br>
map의 get메소드를 이용해 key값의 value를 구하고, 그 value값을 max와 비교합니다.<br><br>
max보다 value값이 더 크면 max의 값에 value값을 대입해줍니다.<br><br>
반복문이 끝나면 max값에는 수포자 1, 2, 3 중에서 가장 문제를 많이 맞힌 개수가 저장됩니다.<br><br>
다음으로 list를 ArrayList의 생성자를 이용해 생성하고, 자료형은 Integer로 설정합니다.<br><br>
다시 반복제어변수 m은 1부터 시작해서 4보다 작은 동안 반복을 합니다.<br><br>
map에 저장된 value값중에 max와 같은 key의 값(수포자 순서)을 list에 add합니다.<br><br>
반복이 끝나면 list에는 max와 같은 key의 값들이 저장되어 있습니다.<br><br>
정수형 배열 answer를 list의 size만큼 힙에 할당합니다.<br><br>
반복제어변수 m은 0부터 시작해서 answer.lenght보다 작은 동안 반복을 합니다.<br><br>
answer의 m번째 배열요소에 list에 저장한 m번째 배열요소인 map의 key값(수포자 순서)를 저장합니다.<br><br>
반복이 끝나고 나면 answer에는 문제를 제일 많이 맞힌 수포자의 순서가 저장되어 있고, 이를 반환합니다.
