# 다른 사람이 푼 코드

```java
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        //1. 재귀함수를 이용해 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        //2. 소수의 개수만 센다.
        int answer = 0;
        Iterator<Integer> it = this.numberSet.iterator();
        while(it.hasNext())
        {
            if(isPrimeNumber(it.next()))
            {
                answer++;
            }   
        }
        //3. 소수의 개수를 반환한다.
        return answer;
    }
    //모든 조합의 숫자를 만들 재귀함수
    public void recursive(String comb, String others)
    {
        //1. 현재 조합이 빈 칸이 아니면
        if(!comb.equals(""))
        {
            //1.1 현재 조합을 set에 추가한다.
            this.numberSet.add(Integer.valueOf(comb));
        }
        //2. 남은 숫자 중에 한 개를 더해 새로운 조합을 만든다.
        for(int i = 0; i < others.length(); i++)
        {
            recursive(comb + others.charAt(i),
                      others.substring(0, i) + others.substring(i + 1));
        }
    }
    //입력받은 수가 소수인지 아닌지 판별하는 함수
    public boolean isPrimeNumber(int number)
    {
        //1. 입력받은 수가 0 또는 1이면
        if(number == 0 || number == 1)
        {
            //1.1 소수가 아니므로 false를 반환한다.
            return false;
        }
        //2. 에라토스테네스 체의 limit숫자를 구한다.
        int limit = (int)Math.sqrt(number);
        //3. 2부터 limit숫자까지 반복하며 소수인지 판별한다.
        for(int i = 2; i <= limit; i++)
        {
            if(number % i == 0)
            {
                return false;           
            }
        }
        return true;
    }
}
```

# 다른 사람이 푼 코드 분석하며 공부하기

Set과 재귀함수를 이용해 모든 경우의 수를 구합니다.<br><br>
이 때 Set은 Integer로 저장하기 때문에 문자열 "011"을 정수로 바꿔 저장하면 문젱에서 제시한대로 11로 인식하게 됩니다.<br><br>
또한 Set은 중복을 알아서 걸러주기 때문에 모든 경우의 수를 다 넣으면 조합 순서와 상관없이 중복되는 숫자는 제거해주고<br><br>
단일의 숫자 조합들만 저장되게 됩니다.<br><br>
recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));처럼 재귀함수에서 매개변수로<br><br>
comb에 조합한 수를 첫번째 매개변수에 넣어주고,<br><br>
substring을 이용해 조합에 이용한 수는 빼주고 더해서 나머지 수를 정해주고 이를 두번째 매개변수에 넣어줍니다.<br><br>
이렇게 되면 조합에 사용한 수와 사용하지 않은 수를 나눠서 다시 조합하기 때문에 모든 경우의 수를 중복없이 구할 수 있습니다.<br><br>
이 모든 경우의 수를 바탕으로 소수인지 판별하여 그 개수를 반환하면 됩니다.
