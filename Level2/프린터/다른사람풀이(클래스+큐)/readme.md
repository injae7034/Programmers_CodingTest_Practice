# 다른 사람이 푼 코드

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
   public int solution(int[] priorities, int location) {
        //1. List 생성해서 초기화시키기
        List<PrintJob> list = new ArrayList<>();
        for(int i = 0; i < priorities.length; i++)
        {
            list.add(new PrintJob(i, priorities[i]));
        }
        int answer = 0;
        while(!list.isEmpty())
        {
            //2. 인쇄대기 리스트에서 첫번째 작업을 꺼낸다.
            PrintJob job = list.remove(0);
            //3. 인쇄대기 리스트에서 첫번째 작업보다 중요한 우선순위를 가진 작업이 있으면
            if(list.stream().anyMatch(otherJob -> job.priority < otherJob.priority))
            {
                //4. 꺼낸 작업을 다시 뒤에 넣는다.
                list.add(job);
            }
            //5. 인쇄대기 리스트에서 첫번째 작업의 우선순위가 제일 높으면
            else
            {
                //6. 작업을 수행한다.
                answer++;
                //7. 해당 작업의 위치가 선택한 위치와 같으면
                if(location == job.location)
                {
                    //8. 반복을 중단한다.
                    break;
                }
            }
        }
        return answer;
    }
    
    class PrintJob
    {
        int location;
        int priority;
        
        public PrintJob(int location, int priority)
        {
            this.location = location;
            this.priority = priority;
        }
    }
}
```

# 다른 사람이 푼 코드 분석하며 공부하기

PrintJob이라는 클래스를 생성하여 멤버로 location과 priority를 둡니다.<br><br>
생성자를 정의하여 매개변수로 location과 priority를 입력받으면 이를 멤버에 저장시킵니다.<br><br>
PrintJob클래스를 정의하였으면 이제 solution 메소드를 정의할 차례인데<br><br>
먼저 List의 객체를 생성하여 매개변수로 입력 받은 priorites의 배열첨자와 배열요소들로<br><br>
PrintJob의 객체를 생성시킨다음 이를 list에 add시킵니다.<br><br>
list는 우선순위를 정하여 계속 실행을 할 것이고 결국에 마지막에는 size가 0이 될 것이기 때문에<br><br>
list가 비어있지 않은 동안 반복을 합니다.<br><br>
반복문 내부에서 첫번째 원소인 PrintJob의 객체를 remove를 통해서 꺼내어 job에 저장합니다.<br><br>
remove에 index를 넣으면 해당 index의 원소를 list에서 제거하고, 그 원소의 값을 반환해주기 때문에<br><br>
여기서 list 원소의 자료형은 PrintJob이기 때문에 job(자료형 PrintJob)로 list의 첫번째 원소를 제거한 뒤에 그 값을 반환받습니다.<br><br>
stream을 사용하고, stream의 anyMatch와 람다식을 사용하여<br><br>
list에서 PrintJob의 객체인 job의 멤버인 priority보다 더 큰 priority멤버를 가진 PrintJob의 객체인 otherPrintJob이 있는지 확인하여<br><br>
있다면 다시 끝에 넣어주고(add) 없다면 실행시켜주는 의미로 answer의 값을 1 증가시킵니다.<br><br>
이 때 PrintJob의 객체인 job의 멤버 location의 위치가 매개변수로 입력받은 location과 같다면<br><br>
우리가 선택한 작업이기 때문에 break를 통해 반복을 끝내고 누적된 answer값을 반환합니다.

# 느낀 점

클래스를 만들어서 location과 priority를 멤버로 두고 관리하면<br><br>
매개변수로 입력 받은 location의 값을 변경할 필요없이<br><br>
나중에 해당클래스의 객체의 멤버인 location이 매개변수로 입력받은 location과 같은지 비교하면 되서 굉장히 간단하게 처리할 수 있습니다.<br><br>
다음부터 이렇게 매개변수로 입력 받은 위치가 바뀌는데 그 위치가 언제인지 구분하기 까다로울 때<br><br>
클래스를 이용하도록 해야겠습니다.
