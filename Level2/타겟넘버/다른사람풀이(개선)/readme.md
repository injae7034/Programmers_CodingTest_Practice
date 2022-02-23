# 다른 사람이 푼 코드 개선한 코드

```java
class Solution {
    int answer = 0;
    int[] numbers;
    int target;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return this.answer;
    }
    public void dfs(int depth, int sum)
    {
        //탐색이 남았으면
        if(depth < this.numbers.length)
        {
            //해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(depth + 1, sum + this.numbers[depth]);
            //해당 노드의 값을 빼고 다음 깊이 탐색
            dfs(depth  + 1, sum - this.numbers[depth]);
        }
        //마지막까지 탐색이 끝났으면
        else
        {
            //타켓과 합이 일치하면
            if(this.target == sum)
            {
                //개수를 센다.
                this.answer++;
            }
           
        }
    }
}
```

# 개선 사항

다른 사람의 풀이에서 solution메소드에서 매개변수로 입력 받은 numbers와 target을<br><br>
매번 재귀함수 dfs에서 넣어주고 있습니다.<br><br>
이들의 값은 매개변수로 입력 받을 때부터 답을 도출할 때까지 바뀌지 않기 때문에<br><br>
굳이 매번 dfs에 번거롭게 매개변수로 넘겨 주는 것보다는<br><br>
Solution클래스에서 numbers와 target을 멤버로 설정하고<br><br>
solution메소드에서 이들 멤버값에 대입을 해줌으로써<br><br>
dfs에 메소드로 numbers와 target을 매개변수로 넣어 주지 않아도 됩니다.<br><br>
Solution메소드의 멤버로 numbers와 target의 값이 저장되어 있고<br><br>
dfs는 Solutuon클래스의 메소드이기 때문에 이들 멤버에 바로 접근하여 값을 구할 수 있습니다.<br><br>
이로써 dfs는 매개변수 4개에서 값이 바뀌지 않는 매개변수 2개를 줄여 2개만 적어도 되기 때문에 훨씬 더 간결합니다.<br><br>
또한 dfs에서 선택구조의 순서를 바꿨는데<br><br>
마지막 노드인 경우는 딱 한번 뿐이고 보통은 마지막 노드 전까지인 경우가 훨씬 더 많기 때문에<br><br>
매번 먼저 마지막 노드인지 확인하고 마지막 노드가 아닌 경우를 실행하는 것보다<br><br>
마지막 노드가 아닌지를 먼저 확인하여 실행하고 상대적으로 시행횟수가 적은 마지막인 경우를 else에 배치시켰습니다.
