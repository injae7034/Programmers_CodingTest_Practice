import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        //1. 매개변수로 입력받은 participant와 completion 문자열 배열을 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);
        //2. completion의 사용량만큼 반복한다.
        int i = 0;
        while(i < completion.length)
        {
            //2.1 participant의 배열요소와 completion 배열요소가 같지 않으면
            //(정렬을 했기 때문에 불일치하는 순간이 완주하지 못한 선수임)
            if(participant[i].equals(completion[i]) == false)
            {
                //2.1.1 반복문을 빠져나온다.
                break;
            }
            i++;
        }
        //3. 완주하지 못한 선수를 출력한다.
        return participant[i];
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        Solution solution = new Solution();
        System.out.println(solution.solution(participant, completion));
        }
}