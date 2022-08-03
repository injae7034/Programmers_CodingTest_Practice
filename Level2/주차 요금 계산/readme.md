# 프로그래머스 2022 KAKAO BLIND RECRUITMENT에서 나온 level2 문제입니다.
### 문제의 링크는 아래에 있습니다.
<a href="https://school.programmers.co.kr/learn/courses/30/lessons/92341" target="_blank">프로그래머스 - 주차 요금 계산</a>

```java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class ParkingFeeCalculation {

    public int[] solution(int[] fees, String[] records) {

        String[] times = new String[records.length];
        String[] carNumbers = new String[records.length];
        String[] inAndOutRecords = new String[records.length];

        StringTokenizer tokenizer;
        for (int i = 0; i < records.length; i++) {
            tokenizer = new StringTokenizer(records[i], " ");
            times[i] = tokenizer.nextToken();
            carNumbers[i] = tokenizer.nextToken();
            inAndOutRecords[i] = tokenizer.nextToken();
        }

        Set<String> carSets = new HashSet<>();
        for (String carNumber : carNumbers) {
            carSets.add(carNumber);
        }

        Map<String, List<String>> carNumbersAndTimesMap = new HashMap<>();
        for (String carNumber : carSets) {
            carNumbersAndTimesMap.put(carNumber, new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            carNumbersAndTimesMap.get(carNumbers[i]).add(times[i]);
        }

        List<String> hours;
        List<String> minutes;
        List<Integer> totalTimes;
        int totalTime = 0;
        Map<String, Integer> carParkingTimes = new HashMap<>();
        for (String carNumber : carSets) {

            hours = new ArrayList<>();
            minutes = new ArrayList<>();
            for (int i = 0; i < carNumbersAndTimesMap.get(carNumber).size(); i++) {
                tokenizer = new StringTokenizer(carNumbersAndTimesMap.get(carNumber).get(i), ":");
                hours.add(tokenizer.nextToken());
                minutes.add(tokenizer.nextToken());
            }

            totalTimes = new ArrayList<>();
            for (int i = 0; i < hours.size(); i++) {
                totalTimes.add(Integer.valueOf(hours.get(i)) * 60 + Integer.valueOf(minutes.get(i)));
            }

            totalTime = 0;
            for (int i = 0; i < totalTimes.size(); i++) {
                totalTime += Math.pow(-1, i + 1) * totalTimes.get(i);
            }
            if (totalTimes.size() % 2 != 0) {
                totalTime += 23 * 60 + 59;
            }

            carParkingTimes.put(carNumber, totalTime);
        }

        Map<String, Integer> carParkingFees = new HashMap<>();
        for (String carNumber : carSets) {
            if (carParkingTimes.get(carNumber) <= fees[0]) {
                carParkingFees.put(carNumber, fees[1]);
            } else {
                carParkingFees.put(carNumber,
                        fees[1] + (int) Math.ceil((double) (carParkingTimes.get(carNumber) - fees[0])
                                / fees[2]) * fees[3]);
            }
        }

        String[] carNumberArray = new String[carSets.size()];
        int i = 0;
        for (String carNumber : carSets) {
            carNumberArray[i] = carNumber;
            i++;
        }

        Arrays.sort(carNumberArray);

        int[] answer = new int[carNumberArray.length];
        for (int j = 0; j < carNumberArray.length; j++) {
            answer[j] = carParkingFees.get(carNumberArray[j]);
        }

        return answer;
    }

}

```

첫 째, 시간을 저장할 문자열 배열과 차량번호를 저장할 문자열 배열을 입력 받는 records 배열의 길이만큼 생성합니다.  

둘 째, records 배열을 처음부터 끝까지 반복을 돌리면서 StringTokenizer를 통해 공백을 구분으로 하여 시간을 저장하는 배열에 시간을 저장하고, 차량번호를 저장하는 배열에 차량번호를 저장합니다.  

셋째, 차량번호를 저장하는 배열에 각 차량번호가 중복되어 여러개 저장되어 있을텐데 이 때 중복과 상관없이 하나의 자동차번호만 저장하기 위해 Set을 이용해 차량번호를 저장합니다.  

넷째, 각 차량번호가 자신이 입차하고 출차한 시간을 List로 가지는 carNumbersAndTimesMap을 생성하는데 key값이 차량번호 value값이 각 차량의 출입차 시간을 저장한 List입니다.  

다섯째, 이제 시간을 저장하는 배열만큼 반복을 돌리면서 carNumbersAndTimesMap에 key값인 차량번호를 저장하는 배열의 원소를 통해 각 차량의 입출차시간을 저장한 List를 get하여 시간을 저장하는 배열을 원소를 차례대로 add 해줍니다.  

이제 carNumbersAndTimesMap에는 각 차량번호(key)마다 입출차시간이 List(value)로 저장되어 있습니다.  

여섯째, 이를 바탕으로 각 차량번호의 전체 주차시간을 구합니다.  

carParkingTimes이라는 Map을 생성하여 key값으로 차량번호, value값으로 총 주차시간으로 정합니다.  

아까 Set에 저장한 중복없는 차량번호를 반복해서 하나씩 얻습니다.  

차량번호를 key값으로 하여 carNumbersAndTimesMap에서 List를 구한 다음 그 List의 size만큼  반복을 돌립니다.  

반복문 내에서 다시 StringTokenizer를 이용해 :을 구분하여 시간은 시간배열에 저장하고, 분은 분배열에 저장합니다.  

반복문이 끝나면 totalTimes라는 ArrayList를 생성합니다.  

시간배열의 개수만큼 반복을 돌리면서 시간배열의 원소에 60을 곱해주고, 분배열의 원소를 더한 값을 차례대로 totalTimes에 하나씩 add합니다.  

그렇게되면 totalTimes에는 각 입출차시간이 분으로 환산되어 표시됩니다.  

totalTimes의 개수만큼 반복을 돌리면서 배열의 첨자가 짝수일때는 totalTimes의 원소 더해주고, 홀수일때는 totalTimes의 원소를 더해준 누적값을 구합니다.  

그리고 totalTimes의 개수가 홀수이면 마지막으로 23 * 60 + 59을 해준값을 더해줍니다.  

carParkingTimes 맵에 key값은 차량번호 이렇게 누적된 값을 value로 하여 저장합니다.  

이렇게 하면 carParkingTimes에는 각 차량번호마다 분으로 환산된 시간이 저장됩니다.  

이제 carParkingFees라는 Map을 생성하는데 각 차량번호가 key값, 주차요금이 value값입니다.  

다시 carSet에서 차량번호를 하나씩 얻으면서 반복을 돌립니다.    

반복문 내에서 얻은 차량번호를 key값으로 하여 carParkingTimes맵에서 분으로 환산된 주차시간을 구합니다.  

이 주차시간이 기본시간보다 작거나 같으면 carParkingFees 맵에 현재차량번호의 요금(value)은 기본요금으로 저장합니다.  

그게 아니면 기본요금 + (총 주차시간 - 기본시간) / 단위 시간 X 단위 요금 을 현재차량번호의 요금(value)으로 저장합니다.  

이제 carParkingFees라는 맵에는 각차량번호마다 주차요금이 저장되어 있습니다.  

마지막으로 carNumberArray라는 문자열 배열을 만들어 carSet을 이용해 중복없는 차량번호를 저장합니다.  

이 후 carNumberArray를 오름차순으로 정렬합니다.  

carNumberArray의 첫번째항부터 마지막항까지 반복을 하면서 carParkingFees 맵에서 value값을 얻어 순차적으로 정수배열 answer에 저장합니다.  

정수배열 answer에는 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 저장되어있습니다.  

이를 반환하면 정답입니다.  
