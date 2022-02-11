# 내가 풀이한 코드

```java
class Solution {
    public boolean solution(String s) {
        try{
            if(s.length() == 4 || s.length() == 6)
            {
                change(s);
            }
            else
            {
                return false;
            }
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
    public void change(String s) throws NumberFormatException
    {
        Integer.parseInt(s);
    }
}
```

# 내가 풀이한 코드 설명

길이가 4 또는 6이고 숫자로만 구성된 문자열이면 true이고 그 외 나머지는 모두 false입니다.<br><br>
이를 확인하기 위해 먼저 선택문으로 문자열의 길이가 4인지 6인지 확인하여 그게 아니면 false를 반환합니다.<br><br>
길이가 4 또는 6이면 change메소드를 호출하는데 change메소드는 문자열 s를 정수로 바꿔주는 역할을 합니다.<br><br>
여기서 문자열에 숫자말고 다른 문자열이 있다면 NumberFormatException이 발생하는데 이를 solution에 throws해주고<br><br>
solution에서 이를 catch하여 false를 반환합니다.<br><br>
만약 NumberFormatException이 발생하지 않는다면 문자열s에 숫자만 존재하는 것이기 때문에 true를 반환합니다.

# 아쉬운 점

```java
class Solution {
  public boolean solution(String s) {
      if(s.length() == 4 || s.length() == 6){
          try{
              int x = Integer.parseInt(s);
              return true;
          } catch(NumberFormatException e){
              return false;
          }
      }
      else return false;
  }
}
```
메소드를 별도로 만들어서 throws하지 말고 위와 같이 바로 예외를 catch하면 됩니다.<br><br>
그러면 코드가 훨씬 간결해집니다.<br><br>
또한 문제를 잘읽어야겠습니다.<br><br>
문제에서 길이가 4또는 6이고 문자열에 숫자만 있는 문자열이라고 조건을 제시했는데<br><br>
앞에 길이에 대한 조건을 전혀 고려하지 않고 로직을 짰는데 왜 틀렸는지 몰라서 헤맸습니다.<br><br>
문제를 정확하게 읽고 조건을 정확하게 고려하여 헤메는 일이 없도록 해야겠습니다.
