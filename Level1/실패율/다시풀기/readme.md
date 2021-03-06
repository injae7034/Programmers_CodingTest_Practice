# <어떻게 문제를 풀 것인가?>
# 1. 문제에 대한 이해
## 1.1우리가 풀어야 할 문제는 무엇인가?
실패율이 높은 스테이지부터 차례대로 스테이지의 번호가 담겨있는 1차원 배열을 구하라
## 1.2주어진 자료는 무엇인가?
전체 스테이지의 개수와 사용자가 실패해서 현재 멈춰있는 스테이지 번호가 담긴 1차원 배열
## 1.3조건은 무엇인가?
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
클리어하지 못한 플레이어의 수는 현재 스테이지에 있는 플레이어의 수다
현재 스테이지에 있는 사람 + 현재 스테이지보다 위에 있는 사람 수

단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.  

만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.  

스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.  

# 2. 계획
## 2.1 이 문제를 푸는데 있어서 유용하게 쓸 수 있는 지식은 무엇인가?

## 2.3 비슷한 문제를 풀어본 적이 있다면 그 것을 활용할 수 있는가?
## 2.4 만약 문제를 풀 수 없다면 문제를 더 단순하게 하기 위해서 주어진 조건을 버려보아라
## 2.5 주어진 자료로부터 유용한 것을 이끌어 낼 수 있는가?
## 2.6 자료는 모두 사용했는가?
## 2.7 조건을 모두 사용했는가?
## 2.8 문제에 포함된 핵심적인 개념은 모두 고려했는가?

맵을 만들어서 각 스테이지를 키로 하고 밸류값을 그 스테이지에 머문 사람의 수로 정함.  

이를 바탕으로 다시 맵을 만들어서 각 스테이지 실패율을 구한다.  

실패율을 바탕으로 다시 정렬한다.  

정렬하는 로직을 커스터마이징한 메소드를 만든다.  

(실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 와야하기 때문에)  




# 3. 실행
## 3.1 풀이 계획을 실행하고, 각 단계가 올바른지 점검하라.
# 4. 반성
## 4.1 문제를 다른 방식으로 해결할 수 있는가?
## 4.2 결과나 방법을 어떤 다른 문제에 활용할 수 있는가?
## 4.3 어떻게 하면 더 효율적으로 문제를 해결할 수 있는가?
## 4.4 어떻게 하면 더 효과적으로 문제를 해결할 수 있는가?
