# 내가 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int m) {
        List<Integer> nDivisors = new ArrayList<>();
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                nDivisors.add(i);
            }
        }
        List<Integer> mDivisors = new ArrayList<>();
        for(int i = 1; i <= m; i++)
        {
            if(m % i == 0)
            {
                mDivisors.add(i);
            }
        }
        int mIndex = 0;
        int max = 0;
        for(int i = 0; i < nDivisors.size(); i++)
        {
            mIndex = 0;
            while(mIndex < mDivisors.size())
            {
                if(nDivisors.get(i).equals(mDivisors.get(mIndex)) == true)
                {
                    max = nDivisors.get(i);
                    mDivisors.remove(mIndex);
                    break;
                }
                else
                {
                    mIndex++;
                }
            }
        }
        int multiple = 2;
        int bigger = Math.max(m, n);
        int smaller = Math.min(m, n);
        int commonMultiple = bigger;
         while(commonMultiple % smaller != 0)
        {
            commonMultiple = bigger * multiple;
            multiple++;
        }
        int min = commonMultiple;
        int[] answer = new int[]{max, min};
        return answer;
    }
}
```

# 내가 푼 코드 설명하기

먼저 매개변수로 입력 받은 n과 m의 약수를 담을 List의 객체들 nDivisors와 mDivisors를 생성합니다.<br><br>
i는 1부터 시작하여 n보다 작거나 같은 동안 반복하면서 n을 i로 나눈 나머지가 0이면<br><br>
약수이기 때문에 i를 nDivisors에 add합니다.<br><br>
mDivisors도 같은 원리로 add합니다.<br><br>
i는 0부터 시작해서 nDivisor의 size보다 작은동안 반복합니다.<br><br>
mIndex를 0으로 초기화해주고,<br><br>
mIndex를 0부터 시작해서 mDivisors의 size보다 작은동안 반복합니다.<br><br>
nDivisors의 nIndex번째 원소와 mDivisors의 mIndex번째 원소가 같은지 비교하는데 이 때 eqauls를 사용합니다.<br><br>
두 값이 같다면 max에 두 값중 한 값을 저장해줍니다.<br><br>
그리고 nDivisors의 원소는 이제 다시 비교할 일이 없기 때문에<br><br>
중복을 줄이기 위해서 nDivisors의 nIndex번째 원소를 remove합니다.<br><br>
그리고 일치하는 것을 찾아 max에 그 값을 저장했고, 중복을 방지하기 위해 해당원소를 지웠기 때문에<br><br>
더이상 mDivisors의 원소에서 반복을 할 필요가 없고<br><br>
nDivisors의 다음 원소로 넘어가야 하기 때문에 반복문을 벗어나기 위해 break합니다.<br><br>
만약에 nDivisors의 nIndex번째 원소와 mDivisors의 mIndex번째 원소가 같지 않다면<br><br>
mDivisors의 다음 원소를 구해야 하기 때문에 mIndex를 증가시켜 줍니다.
이런식으로 반복을 하면 mDivisors에서 nDivisors의 원소와 비교하여 같은 값은 계속 지우기 때문에 중복을 줄일 수 있습니다.<br><br>
반복을 하면서 max값을 계속 갱신했기 때문에 max에는 이제 최대공약수 값이 저장되어 있습니다.<br><br>
최소공약수를 구하기 전에 Math의 max메소드를 이용하여 m과 n중에 더 큰 값을 bigger에 저장하고,<br><br>
Math의 min 메소드를 이용하여 더 작은 값은 smaller에 저장합니다.<br><br>
**Math의 max나 min 메소드 모두 매개변수로 입력 받은 두 값이 같을 경우 동일한 값을 반환**하기 때문에<br><br>
m과 n이 같은 수라도 상관없습니다.<br><br>
최소공약수를 뜻하는 commonMultiple에 bigger의 값을 저장합니다.<br><br>
commonMultiple을 smaller로 나눈 나머지가 0이 아닌 동안 반복합니다.<br><br>
반복문 내부에서 commonMultiple에 bigger 곱하기 multiple(=2)를 해준 값을 저장합니다.<br><br>
multiple값을 1증가시킨 다음 다시 반복 조건문으로 돌아가서 commonMultiple을 smaller로 나눈 나머지가 0인지 확인합니다.<br><br>
반복문이 끝나면 min에 commonMultiple을 저장합니다.<br><br>
max에는 최대공약수 값이 저장되고, min에는 최소공배수가 저장되어 있을 것입니다.<br><br>
이 값으로 answer 배열을 생성하여 반환합니다.
