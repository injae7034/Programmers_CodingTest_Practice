# 내가 풀이한 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for(int number : numbers)
        {
            numberList.add(number);
        }
        Collections.sort(numberList, new Comparator<Integer>(){
            @Override
            public int compare(Integer one, Integer other)
            {
                List<Integer> oneList = new ArrayList<>();
                String oneString = String.valueOf(one);
                for(int i = 0; i < oneString.length(); i++)
                {
                    oneList.add(Integer.parseInt(String.valueOf(oneString.charAt(i))));
                }
                List<Integer> otherList = new ArrayList<>();
                String otherString = String.valueOf(other);
                for(int i = 0; i < otherString.length(); i++)
                {
                    otherList.add(Integer.parseInt(String.valueOf(otherString.charAt(i))));
                }
               
                while(oneList.size() > 1 || otherList.size() > 1)
                {
                    if(oneList.get(oneList.size() - 1) > otherList.get(otherList.size() - 1))
                    {
                        return 1;
                    }
                    else if(oneList.get(oneList.size() - 1) < otherList.get(otherList.size() - 1))
                    {
                        return -1;
                    }
                    else
                    {
                        if(oneList.size() > 1)
                        {
                            oneList.remove(oneList.size() - 1);
                        }
                        if(otherList.size() > 1)
                        {
                            otherList.remove(otherList.size() - 1);
                        }
                    }
                }
                if(oneList.get(oneList.size() - 1) > otherList.get(otherList.size() - 1))
                {
                    return 1;
                }
                else if(oneList.get(oneList.size() - 1) < otherList.get(otherList.size() - 1))
                {
                    return -1;
                }
                return 0;
            }
        });
        String answer = "";
        for(Integer number : numberList)
        {
            answer = String.valueOf(number) + answer;
        }
        return answer;
    }
}
```
# 내가 풀이한 코드 설명

각 자리수를 뽑아서 비교하려고 했습니다.<br><br>
예를 들어 9와 30을 비교할 때는 9와 3을 비교해서 9가 더 크기 때문에 비교를 끝내고<br><br>
31과 32를 비교할 때는 3과 3은 같으니 다음으로 1과 2를 비교하도록 하였습니다.<br><br>
3과 30의 경우 3과 3을 비교하고 다음으로 3과 0을 비교하도록 설계했습니다.<br><br>
그러다 보니 코드가 굉장히 길어졌고, 어디서 틀렸는지는 모르겠지만 제대로 비교하지 못하는 부분이 발생했습니다.<br><br>
왜 항상 단순하게 1차원적으로 각 자리수만 구한다음 그 크기를 비교하려고 하는지 모르겠네요ㅠ<br><br>
이번에도 항상 느끼지만 많이 알아야 제대로 풀 수 있고, 뭔가 풀이가 너무 복잡해지만 지금 잘못하고 있다는 것을<br><br>
새로운 방법을 찾아야한다는 것을 다시 한번 깨닫게 됩니다.
