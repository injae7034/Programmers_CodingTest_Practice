# 다른 사람이 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        //1. List 생성해서 priorites 담기
        List<Integer> list = new ArrayList<>();
        for(int priority : priorities)
        {
            list.add(priority);
        }
        int answer = 0;
        while(!list.isEmpty())
        {
            //2. 0번을 꺼내서 maxPriority인지 확인하기
            Integer priority = list.remove(0);
            if(list.stream().anyMatch(otherPriority -> priority < otherPriority))
            {
                //3. maxPriority가 아니면 다시 끝에 넣기
                list.add(priority);
            }
            else
            {
                //4. maxPriority면 실행시키기
                answer++;
                //5. 실행시키는 작업이 내가 선택한 location이 맞는지 확인하기
                if(location == 0)
                {
                    break;
                }
            }
            location--;
            if(location < 0)
            {
                location = list.size() - 1;
            }
        }
        return answer;
    }
}
```

# 다른 사람이 푼 코드 분석하며 공부하기

List의 객체를 생성하여 매개변수로 입력 받은 priorites 배열요소들을 add시킵니다.<br><br>
list는 우선순위를 정하여 계속 실행을 할 것이기 때문에 결국에 마지막에는 size가 0이 될 것이기 때문에<br><br>
list가 비어있지 않은 동안 반복을 합니다.<br><br>
반복문 내부에서 첫번째 원소 값을 remove를 통해서 꺼냅니다.<br><br>
remove에 index를 넣으면 해당 index의 원소를 list에서 제거하고, 그 원소의 값을 반환해주기 때문에<br><br>
여기서 list 원소의 자료형은 Integer이기 때문에 priority(자료형 Integer)로 list의 첫번째 원소를 제거한 뒤에 그 값을 반환받습니다.<br><br>
stream을 사용하고, stream의 anymatch와 람다식을 사용하여<br><br>
list에서 priority보다 더 큰 원소가 있는지 확인한 뒤에 있다면 다시 끝에 넣어주고 없다면 실행시켜주는 의미로 answer의 값을 1 증가시킵니다.<br><br>
이 때 현재 location의 위치가 0이라면 우리가 선택한 작업이기 때문에 break를 통해 반복을 끝내고 누적된 answer값을 반환합니다.<br><br>
반복을 돌 때 마다 location의 위치를 감소시키는데 location이 0보다 작아지면 제일 마지막으로 이동했다는 의미이기 때문에<br><br>
list의 size에서 -1한 값을 대입해줍니다.<br><br>
이런식으로 반복을 하면 answer를 구할 수 있습니다.

# 느낀 점

list의 remove를 통해 해당위치의 값을 제거하고 그 값을 반환받으면 꺼낸 효과를 볼 수 있습니다.<br><br>
그리고 어차피 첫번째 원소는 무조건 꺼내서 실행을 시키거나 다시 뒤로 넣거나 둘 중에 하나기 때문에 get을 할 필요없이<br><br>
처음부터 무조건 remove하여 코드중복을 줄입니다.<br><br>
또한 location의 위치를 감소시킬 때 저 같은 경우는 두군데에서 이 처리를 하다보니 코드가 중복되고 복잡해졌는데<br><br>
이 위치를 적절한 곳에 둔다면 한 번만 이 처리를 해도 되어 코드중복이 줄고 깔끔해집니다.<br><br>
또한 stream의 anyMatch를 이용하면 반복문을 한 번 줄일 수 있고,<br><br>
여기에 람다식까지 사용해주면 코드를  코드가 훨씬 더 깔끔하게 줄일 수 있습니다.
