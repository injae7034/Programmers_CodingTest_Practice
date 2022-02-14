package ProgramersLevel02;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.jar.Attributes;

public class Main {
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
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
    public static void main(String[] args) {
	    int[] answer = solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10});
        System.out.println(Arrays.toString(answer));
        answer = solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4});
        System.out.println(Arrays.toString(answer));
    }
}
