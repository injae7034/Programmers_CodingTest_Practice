# 다른 사람이 푼 코드
```java
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //Set을 생성한다.
        Set<Integer> reserveSet = new HashSet<>();
        Set<Integer> lostSet = new HashSet<>();
        //Set을 초기화한다.
        for(int i : reserve)
        {
            reserveSet.add(i);
        }
        for(int i : lost)
        {
            if(reserveSet.contains(i))
            {
                reserveSet.remove(i);
            }
            else
            {
                lostSet.add(i);
            }
        }
        //여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for(int i : reserveSet)
        {
            if(lostSet.contains(i - 1))
            {
                lostSet.remove(i - 1);
            }
            else if(lostSet.contains(i + 1))
            {
                lostSet.remove(i + 1);
            }
        }
        //학생수에서 체육복이 없는 학생수를 뺀 결과를 반환한다.
        return n - lostSet.size();
    }
}
```

# 다른 사람이 푼 코드 해석하기

매개변수로 입력 받은 reserve배열과 lost배열을 담을<br><br>
Set객체인 reserveSet와 lostSet을 HashSet의 생성자를 이용해 생성합니다.<br><br>
reserveSet을 초기화하는데 reserve배열의 첫 배열요소부터 마지막 배열요소까지 반복을 하면서<br><br>
배열요소 하나씩 reserveSet에 add합니다.<br><br>
lostSet을 초기화할 때는 lost배열의 첫 배열요소부터 마지막 배열요소까지 반복을 하면서<br><br>
반복문 내부에서 reserveSet의 원소에 lost배열의 배열요소가 있는지 contains를 통해 확인합니다.<br><br>
lost배열의 배열요소가 reserveSet의 원소에 존재한다면<br><br>
reserveSet에서 해당 원소를 remove합니다.<br><br>
왜냐하면 해당 원소는 reserve에도 있고, lost에도 있기 때문에<br><br>
체육복 여벌이 있지 않고, 딱 본인이 사용할 체육복만 있다는 의미이기 때문에<br><br>
reserveSet에서 remove해줍니다.<br><br>
lost배열의 배열요소가 reserveSet의 원소에 존재하지 않는다면<br><br>
그 배열요소는 lostSet에 add해줍니다.<br><br>
이렇게 Set 객체들의 초기화 과정이 끝나고 나면<br><br>
reserveSet에는 체육복의 여벌이 있는 학생만 남게 되고,<br><br>
lostSet에는 채육복을 잃어버린 학생만 남게 됩니다.<br><br>
이제 여분의 체육복을 가진 학생을 기준으로 하는데<br><br>
reserveSet의 첫 원소부터 마지막 원소까지 반복을 합니다.<br><br>
reserveSet에서 구한 원소를 기준으로 -1한 값이<br><br>
lostSet에 있는지 여부를 contains메소드로 확인합니다.<br><br>
이는 체육복 여벌이 있는 학생을 기준으로 앞의 학생(-1)이<br><br>
체육복이 있는지 없는지 여부를 확인하는 과정입니다.<br><br>
앞의 학생이 체육복이 없으면<br><br>
여벌의 체육복을 가진 학생이 체육복을 빌려주면 되기 때문에<br><br>
lostSet에서 -1한 값을 remove해줍니다.<br><br>
앞의 학생이 체육복을 잃어버리지 않았으면 뒤의 학생(+1)이<br><br>
체육복이 있는지 확인하기 위하여 lostSet에서 contains메소드를 활용합니다.<br><br>
lostSet에 있다면 체육복이 없다는 뜻이기 때문에 뒤의 학생에게 체육복을 빌려 주고<br><br>
lostSet에서 +1한 값을 remove해줍니다.<br><br>
마지막으로 매개변수로 입력 받은 전체학생 수 n에서 lostSet의 size만큼 빼준 값을 반환합니다.

# 느낀점

제가 풀이한 코드에서는 hashMap을 사용하여 한번에 학생들의 번호와 체육복 여부를 관리하였습니다.<br><br>
애초에 Integer를 이용해 key값을 이용할 것이면 배열을 이용하여도 되고,<br><br>
잃어버린 학생과 여벌을 가진 학생들을 한번에 관리하고,<br><br>
이를 Iterator클래스까지 이용하다보니 과정이 많이 복잡했는데,<br><br>
HashSet을 2개 만들어서 이용하니 간단하게 해결됩니다.<br><br>
앞으로 뭐든지 한 번에 다 해결하려기 보다는 분할해서 처리하는 방법도 생각해봐야할 거 같습니다.
