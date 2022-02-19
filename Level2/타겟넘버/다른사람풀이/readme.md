# 다른 사람이 풀이한 코드
```java
class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return this.answer;
    }
    public void dfs(int[] numbers, int depth, int target, int sum)
    {
        //마지막 노드까지 탐색한 경우
        if(depth == numbers.length)
        {
            if(target == sum)
            {
                answer++;
            }
        }
        //마지막 노드까지 탐색이 남은 경우
        else
        {
            //해당 노드의 값을 더하고 다음 깊이 탐색
            dfs(numbers, depth + 1, target, sum + numbers[depth]);
            //해당 노드의 값을 빼고 다음 깊이 탐색
            dfs(numbers, depth  + 1, target, sum - numbers[depth]);
        }
    }
}
```

# 다른 사람이 풀이한 코드 해석하며 공부하기

깊이 우선 탐색 알고리즘을 사용하였는데 dfs함수를 정의하는데<br><br>
dfs함수를 재귀함수로 이용합니다.<br><br>
매개변수로는 깊이 탐색 알고리즘을 실행할 대상인 numbers,<br><br>
노드의 깊이를 나타내는 depths,<br><br>
목표로 하는 타켓 넘버를 가지고 있는 target<br><br>
이전 노드까지의 결과값을 나타내는 sum이 있습니다.<br><br>
dfs 메소드내에서 depth의 길이와 numbers배열의 길이가 같은 경우<br><br>
즉, 마지막 노드까지 다 탐색했을 경우에는 목표로 하는 target의 값과<br><br>
모든 노드의 값을 더한 sum이 같으면 answer를 증가시킵니다.<br><br>
일치하지 않는 경우 반환형이 void이기 때문에 함수가 그냥 종료됩니다.<br><br>
마지막 노드까지 탐색을 하지 못한 경우, 즉, depth가 아직 numbers 배열의 길이보다 작은 경우<br><br>
해당 노드의 값을 더하고 다음 깊이를 탐색하고(depth의 값을 1 증가시키고)<br><br>
해당 노드의 값을 빼고 다음 깊이를 탐색합니다(depth의 값을 1증가시킵니다.)<br><br>
이렇게 계속 재귀적으로 반복하다가 마지막에 depth와 numbers의 length가 같아진 경우<br><br>
sum과 target이 같으면 answer를 증가시키고 아니면 그냥 함수를 종료시킵니다.

# 느낀 점
깊이 우선 탐색 알고리즘을 어떻게 하면 반복문으로 구현할 수 있을까 혼자서 엄청 고민하다가 결국에 못하고 검색했는데<br><br>
재귀함수를 사용하니까 이렇게 간단하게 해결할 수 있다는 점에서 놀랍기도 하고<br><br>
재귀함수는 알고 있는데 잘 이용하지 못한다는 점에서 안타깝기도 합니다.<br><br>
다음에 또 이런 문제가 나왔을 때 재귀함수를 사용하도록 해야겠습니다.
