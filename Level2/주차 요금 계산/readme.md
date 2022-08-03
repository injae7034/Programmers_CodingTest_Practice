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
