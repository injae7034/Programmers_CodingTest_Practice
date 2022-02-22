package ProgramersLevel02;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static int solution(String[][] clothes) {
        //1. 옷을 종류별로 구분해서 개수 저장하기
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes)
        {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        //2. 입지 않는 경우를 추가하여 모든 경우의 수 계산하기
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;
        while(it.hasNext())
        {
            answer *= it.next().intValue() + 1;
        }
        //3. 아무 옷도 입지 않은 경우를 제외하고 반환하기
        return answer - 1;
    }
    public static void main(String[] args) {
	    int answer = solution(new String[][]{{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(answer);
        answer = solution(new String[][]{{"crowmask", "face"},
                {"bluesunglasses", "face"}, {"smoky_makeup", "face"}});
        System.out.println(answer);
    }
}
