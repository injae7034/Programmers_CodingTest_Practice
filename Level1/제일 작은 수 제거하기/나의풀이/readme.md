# 내가 풀이한 코드

```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> arrangedList = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            arrangedList.add(arr[i]);
            arrList.add(arr[i]);
        }
        Collections.sort(arrangedList);
        
        while(arrList.remove(arrangedList.get(0)) == true)
        {
            
        }
        int[] answer = null;
        if(arrList.size() > 0)
        {
            answer = new int[arrList.size()];
            for(int i = 0; i < answer.length; i++)
            {
                answer[i] = arrList.get(i);
            }
        }
        else
        {
            answer = new int[]{-1};
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

매개변수로 입력 받은 정수배열 arr을 담을 ArrayList를 2개 생성합니다.<br><br>
하나는 오름차순 정렬용으로 쓰이고, 하나는 arr과 똑같은 순서로 저장할 용도입니다.<br><br>
반복을 돌면서 arr의 배열원소를 하나씩 ArrayList의 객체들에 add합니다.<br><br>
이 후 ArrayList의 객체 중 arrangedList를 Collections의 sort를 이용해 오름차순으로 정렬시킵니다.<br><br>
정렬이 끝나면 arrangedList의 첫번째 원소는 제일 작은 수가 위치할 것입니다.<br><br>
arr배열과 똑같은 순서로 저장된 arrList에서 이 첫번째 원소를 매개변수로 넣은 remove를 호출하여<br><br>
이 값이 false인 동안 반복을 하면서 arrangedList의 첫번째 원소값과 동일한 값을 arrList에서 제거합니다.<br><br>
제거 후에 arrList의 size가 0보다 크면<br><br>
answer배열을 arrList의 size만큼 힙에 할당하여 arrList의 원소를 answer배열에 차례차례 담습니다.<br><br>
arrList의 size가 0이면 answer는 크기 1인 배열에 -1을 원소로 담습니다.<br><br>
이 후 answer배열을 반환합니다.


# 아쉬운 점
Collections에서 sort말고도 min과 max라는 메소드가 있는데, 이 경우에 min을 이용했으면<br><br>
굳이 arrayList를 2개 만들 필요도 없고, 하나를 오름차순으로 정렬시킬 필요도 없습니다.<br><br>
그랬으면 코드가 훨씬 줄고 깔끔해졌을 것입니다.
