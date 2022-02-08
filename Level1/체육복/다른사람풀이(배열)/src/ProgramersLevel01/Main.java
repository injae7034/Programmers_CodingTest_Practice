package ProgramersLevel01;

public class Main
{
    public int solution(int n, int[] lost, int[] reserve)
    {
        //student 배열 생성
        int[] student = new int[n + 2];
        int answer = 0;
        //reserve/lost 정보 반영
        for(int i : lost)
        {
            student[i]--;
        }
        for(int i : reserve)
        {
            student[i]++;
        }
        //여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for(int i = 1; i <= n; i++)
        {
            //해당학생이 여분이 있으면
            if(student[i] == 1)
            {
                //앞의 학생이 체육복이 없으면
                if(student[i - 1] == -1)
                {
                    student[i]--;
                    student[i - 1]++;
                }
                //뒤의 학생이 체육복이 없으면
                else if(student[i + 1] == -1)
                {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }
        //체육복을 가지고 있는 학생 수를 계산한다.
        for(int  i = 1; i <= n; i++)
        {
            if(student[i] > -1)
            {
                answer++;
            }
        }
        return answer;
    }
}
