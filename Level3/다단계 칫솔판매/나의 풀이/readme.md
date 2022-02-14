# 내가 풀이한 코드

```java
import java.util.Map;
import java.util.LinkedHashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        //LinkedHashMap 생성 및 초기화
        Map<String, Integer> enrollMap = new LinkedHashMap<>();
        Map<String, String> referralMap = new LinkedHashMap<>();
        for(int i = 0; i < enroll.length; i++)
        {
            enrollMap.put(enroll[i], 0);
            referralMap.put(enroll[i], referral[i]);
        }
        //수익 계산
        String referName = "";
        int profit = 0;
        for(int i = 0; i < seller.length; i++)
        {
            profit = amount[i] * 100 / 10;
            enrollMap.put(seller[i], enrollMap.get(seller[i]) + amount[i] * 100 - profit);
            referName = referralMap.get(seller[i]);
            while(referName.compareTo("-") != 0 && profit > 0)
            {
                enrollMap.put(referName, enrollMap.get(referName) + profit - profit / 10);
                profit /= 10;
                referName = referralMap.get(referName);
            }
        }
        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++)
        {
            answer[i] = enrollMap.get(enroll[i]);
        }
        return answer;
    }
}
```

# 내가 풀이한 코드 설명

enroll에 적힌 이름(String)을 Key값으로 하고, 각자가 얻은 수익(Integer)을 Value로 하는 Map의 객체 enrollMap을 LinkedHashMap의 생성자로 생성합니다.<br><br>
지금와서 생각해보니 LinkedHashMap으로 할 필요가 없고, HashMap으로 생성해도 됩니다.<br><br>
나중에 put한 순서대로 answer에 넣으려고 했는데 어차피 answer의 각 원소에 저장할 때 enroll의 배열요소를 key값으로 하여 value값을 구하기 때문에<br><br>
(enroll의 배열요소와 answer의 배열요소가 서로 상응해야함)LinkedHashMap이 아니라도 순차적으로 answer의 각 배열요소에 저장할 수 있습니디.<br><br>
그리고 Key값을 enroll에 적힌 이름(String)으로 하고, Value값을 refferal에 적힌 추천인 이름(String)으로 하는 Map의 객체 referralMap을 LinkedHashMap의 생성자로 생성합니다.<br><br>
역시 HashMap으로 해도 아무 상관이 없습니다.<br><br>
생성한 Map의 객체들을 초기화해줘야 하는데 i = 0 부터 enroll의 length보다 작은 동안 반복합니다.<br><br>
enrollMap에는 key값으로 enroll의 i번째 배열요소(String)(이름), value값으로는 0(수익)을 매개변수로 하여 put합니다.<br><br>
refferalMap에는 key값으로 enroll의 i번째 배열요소(String)(이름), value값으로는 referral의 i번째 배열요소(String)(이름)을 put합니다.<br><br>
수익을 계산하기 위해 i = 0부터 seller의 length보다 작은동안 반복합니다.<br><br>
반복문 내부에서 판매 수량을 나타내는 amount의 i번째 배열요소에 가격 100원을 곱한 다음 10으로 나눈 값을 profit에 저장합니다.<br><br>
seller의 i번째 배열요소, 즉, i번째 판매자의 수익 중 이 profit만큼을 차감하여 자신이 수익을 가져가고,<br><br>
i번째 판매자의 추천인이 이 profit을 가져갑니다.<br><br>
그래서 아까 enrollMap에서 put을 하는데 key값으로 i번째 판매자, seller의 i번째 배열요소,<br><br>
value값은 eromall에서 seller의 i번째 배열요소의 value값을 get한 다음 그 value값에 누적하여<br><br>
amount의 i번째 배열요소에 100을 곱한 금액에 profit을 차감한 값을 더해줍니다.<br><br>
다음으로 refferalMap에서 key값이 seller의 i번째 배열요소(판매자)일 때<br><br>
get으로 value값(추천인)을 구해서 referName에 저장합니다.<br><br>
이 referName이 "-"이 아닌동안 즉, 제일 상위의 추천인(자신은 추천없이 가입한)이 아닌동안 반복합니다.<br><br>
이렇게 해도 정답은 나오지만 쓸데없는 반복을 많이 하게 되서 시간초과로 몇 개의 테스트에서는 오답이 발생합니다.<br><br>
그래서 이를 방지하기 위해 반복 조건문을 추가하는데 profit이 0보다 큰 동안 반복하는 조건을 추가하는 것입니다.<br><br>
이 조건이 있으면 상위의 추천인이 비록 아직 남아있더라도 profit이 0이 되면 어차피 상위 추천인들은 수익을 가져갈 수 없기 때문에<br><br>
불필요한 반복을 줄일 수 있습니다.<br><br>
반복문 내부에서 referName을 key값으로 하고, value는 enrollMap에서 referName을 key값으로 해서 구한 value값에<br><br>
profit을 더해주고 profit을 10으로 나눈 몫을 빼준 값을 누적시켜줍니다.<br><br>
다음으로 profit에는 profit을 10으로 나눈 몫을 저장해주고,<br><br>
refferalMap에서 현재 referName의 key값으로 value값(추천인)을 다시 구해서 referName에 저장해줍니다.<br><br>
이렇게 반복을 하다가 제일 상위추천인(추천인 id가 "-"인 경우)이 나오거나 profit이 0이 되는 경우 반복을 빠져나오게 됩니다.<br><br>
이런식으로 모든 seller들의 판매금액을 수익분배하고(반복이 끝나면)<br><br>
nrollMap에서 enroll배열의 배열요소를 key값으로 하여 value값을 구해서 answer배열의 배열요소에 차례대로 저장해줍니다.
