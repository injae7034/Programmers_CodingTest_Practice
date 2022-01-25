package ProgramersLevel01;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        class Solution
        {
            public int[] solution(String[] id_list, String[] report, int k)
            {
                //answer배열을 id_list 배열크기만큼 힙에 할당한다.
                int[] answer = new int[id_list.length];
                //신고한 유저의 id(String)를 Key값으로 하고, 자신이 신고한 유저 id(String) 리스트를
                //Set으로 관리하는데 이 값이 Value인 Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Set<String>> reportingUsers = new HashMap<>();
                //신고당한 유저의 id(String)를 Key값으로 하고, 신고당한 횟수(Integer)를 Value로 하는
                //Map의 객체를 HashMap의 생성자로 생성한다.
                Map<String, Integer> reportedUsers = new HashMap<>();
                //신고한 유저와 신고당한 유저의 Map객체들을 초기화시켜준다.
                //두 객체의 Key값은 id_list의 배열요소인 유저id로 같음.
                for(String usedId : id_list)
                {
                    //신고당한 유저들의 신고당한횟수를 0으로 초기화시킨다.
                    reportedUsers.put(usedId, 0);
                    //유저들이 신고한 유저 id 리스트를 관리할 Set을 생성한다.
                    reportingUsers.put(usedId, new HashSet<>());
                }
                StringTokenizer tokens = null;//문자열을 분리해서 저장할 임시 공간
                String reportingId;//신고한 회원 id를 저장할 임시 공간
                String reportedId;//신고당한 회원 id를 저장할 임시 공간
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //유저가 자신이 신고한 회원 id 기록에 신고당한 회원 id를 추가할 수 있으면
                    //(=유저가 자신이 신고한 회원의 기록에 똑같은 id 중복이 없으면)
                    if(reportingUsers.get(reportingId).add(reportedId) == true)
                    {
                        //신고당한 회원의 신고횟수 기록을 +1 증가시킨다.
                        reportedUsers.put(reportedId, reportedUsers.get(reportedId) + 1);
                    }
                }
                //신고한 회원과 신고당한 회원의 기록(recording)이 있는 report의 처음부터 마지막까지 반복한다.
                for(String recording : report)
                {
                    //공백을 구분으로 문자열을 분리하는 StringTokenizer객체를 생성한다.
                    tokens = new StringTokenizer(recording, " ");
                    //신고한 회원 id를 구한다.
                    reportingId = tokens.nextToken();
                    //신고당한 회원 id를 구한다.
                    reportedId = tokens.nextToken();
                    //신고당한 회원 id의 신고당한 횟수가 k보다 작으면
                    if(reportedUsers.get(reportedId) < k)
                    {
                        //유저가 신고한 회원리스트 중에서 신고당한 회원 id 기록을 지운다.
                        reportingUsers.get(reportingId).remove(reportedId);
                    }
                }
                //회원 아이디의 처음부터 마지막까지 반복한다.
                for(int i = 0; i < id_list.length; i++)
                {
                    //신고한 회원리스트에서 정지당한 회원의 수를 answer 각 배열요소에 저장한다.
                    answer[i] = reportingUsers.get(id_list[i]).size();
                }
                return answer;
            }
        }
    }
}