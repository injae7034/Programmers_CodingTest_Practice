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
        int nIndex = 0;
        int mIndex = 0;
        int max = 0;
        boolean isDeleted = false;
        while(nIndex < nDivisors.size())
        {
            mIndex = 0;
            isDeleted = false;
            while(mIndex < mDivisors.size())
            {
                if(nDivisors.get(nIndex).equals(mDivisors.get(mIndex)) == true)
                {
                    max = nDivisors.get(nIndex);
                    nDivisors.remove(nIndex);
                    mDivisors.remove(mIndex);
                    isDeleted = true;
                    break;
                }
                else
                {
                    mIndex++;
                }
            }
            if(isDeleted == false)
            {
                nIndex++;
            }
        }
        int min = 0;
        int multiple = 2;
        int commonMultiple = 0;
        if(n < m)
        {
            commonMultiple = m;
            while(commonMultiple % n != 0)
            {
                commonMultiple = m * multiple;
                multiple++;
            }
        }
        else if(n > m)
        {
            commonMultiple = n;
            while(commonMultiple % m != 0)
            {
                commonMultiple = n * multiple;
                multiple++;
            }
        }
        else
        {
            commonMultiple = n;
        }
        min = commonMultiple;
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
nIndex는 0부터 시작해서 nDivisor의 size보다 작은동안 반복합니다.<br><br>
mIndex를 0으로 초기화해주고,<br><br>
nDivisors와 mDivisors에 원소를 지웠는지 여부를 저장할 isDeleted을 false로 초기화해줍니다.<br><br>
mIndex를 0부터 시작해서 mDivisors의 size보다 작은동안 반복합니다.<br><br>
**nDivisors의 nIndex번째 원소**와 **mDivisors의 mIndex번째 원소**를 **같은지 비교**하는데 이 때 **eqauls**를 사용합니다.<br><br>
원래 "=="을 사용하였으나 15번 예제가 틀렸다고 하여 질문하기에서 찾아보니<br><br>
 **"=="** 이 기호로 비교하면 **128부터는 안 되고** equals로 바꾸니 잘된다고 하여 equals로 바꿔보니 15번이 정답처리가 되었습니다.<br><br>
 아무튼 두 값이 같다면 max에 두 값중 한 값을 저장해줍니다.<br><br>
 그리고 두 원소들은 이제 다시 비교할 일이 없기 때문에 중복을 줄이기 위해서 nDivisors의 nIndex번째 원소를 remove하고,<br><br>
 지웠다는 표시를 위해 isDeleted을 true로 바꿔줍니다.<br><br>
 그리고 일치하는 것을 찾아 지웠기 때문에 더이상 mDivisors의 원소에서 반복을 할 필요가 없고<br><br>
 nDivisors의 다음 원소로 넘어가야 하기 때문에 반복문을 벗어나기 위해 break합니다.<br><br>
 만약에 nDivisors의 nIndex번째 원소와 mDivisors의 mIndex번째 원소가 같지 않다면<br><br>
 mDivisors의 다음 원소를 구해야 하기 때문에 mIndex를 증가시켜 줍니다.
 mDvisors의 원소를 이동시키는 반복문을 벗어났을 때 isDeleted 값이 true이면<br><br>
 nDivisors의 원소가 지워져서 nDivisors의 원소가 하나씩 앞으로 당겨지기 때문에<br><br>
 mIndex를 증가시켜줄 필요 없이 그대로 다시 사용하면 되고<br><br>
 지워지지 않았다면 mIndex 값을 +1 증가시켜줍니다.<br><br>
 이런식으로 반복을 하면 비교한 값은 계속 지우기 때문에 중복을 줄일 수 있습니다.<br><br>
 반복을 하면서 max값을 계속 갱신했기 때문에 max에는 이제 최대공약수 값이 저장되어 있습니다.<br><br>
 최소공약수를 구하기 n과 m을 대소비교합니다.<br><br>
 n과 m이 같다면 최소공배수는 n 또는 m이 됩니다.<br><br>
 n이 m보다 작다면 commonMultiple라는 변수에 m을 대입한다음<br><br>
 commonMultiple을 n으로 나눈 나머지가 0이 아닌동안 반복합니다.<br><br>
 0이라면 commonMultiple, 즉, 최소공배수는 m이 됩니다.<br><br>
 0이 아니라면 반복에 들어가서 commonMultiple에 m 곱하기 multiple(=2)를 해준 값을 저장하고<br><br>
 multiple값을 1증가시킨 다음 다시 반복 조건문으로 돌아가서 commonMultiple을 n으로 나눈 나머지가 0인지 확인합니다.<br><br>
 이 방법으로 n이 m보다 작거나 큰 경우 둘 다 최소공배수를 구할 수 있습니다.
 
 # 아쉬운 점
 
 지금와서 코드를 설명하다보니 최대공약수를 구할 때 굳이 nDivisors의 원소는 지울 필요가 없었는데 이를 지움으로써 오히려 시간이 더 소모되었습니다.<br><br>
 nDivisors의 경우 어차피 차례차례 하나씩 꺼내는데 꺼내는 값이 누적이 되기 때문에 중복이 일어날 일이 없고,<br><br>
 mDivisors의 경우 매번 0부터 다시 초기화하여 시작하기 때문에 중복이 발생할 수 있어서 mDivisors의 원소만 지우면 됩니다.<br><br>
 오히려 nDivisors의 원소를 지우기 때문에 지웠는지 안지웠는지 여부를 확인하는 flag를 만들고<br><br>
 이 flag를 확인하여 nIndex를 증가시킬지 말지 결정하기 때문에 굉장히 비효율적입니다.<br><br>
 또한 최소공배수를 구할 때 코드 중복이 있는데 이를 차라리 메소드화해서 코드중복을 최소화하는 방법도 생각해볼 수 있습니다.
