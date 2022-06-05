# 다른 사람이 푼 코드
```java
 class Solution {
        //키패드에 있는 숫자 번호를 2차원 배열로 표현 : 좌표(x,y)
        int[][] numpadPos = {
                {3, 1},//0
                {0, 0},//1
                {0, 1},//2
                {0, 2},//3
                {1, 0},//4
                {1, 1},//5
                {1, 2},//6
                {2, 0},//7
                {2, 1},//8
                {2, 2}//9
        };
        //엄지손가락 위치
        int[] leftThumbPos = {3, 0};
        int[] rightThumbPos = {3, 2};
        //왼손잡이인지 오른손잡이인지 정보 저장
        String hand;
        //키패드에서 일련의 번호를 입력할 때 어떤 엄지손가락을 사용했는지 그 기록을 출력
        public String solution(int[] numbers, String hand)
        {
            //매개변수로 입력받은 hand를 통해 왼손잡이인지 오른손잡이인지 결정하기
            this.hand = (hand.equals("right")) ? "R" : "L";
            //출력할 answer를 공백으로 초기화
            String answer = "";
            String thumb;//엄지손가락을 저장할 임시공간
            //입력받은 숫자를 처음부터 마지막까지 순차적으로 반복한다.
            for(int num : numbers)
            {
                //번호를 누를 엄지손가락을 정한다.
                thumb = chooseThumb(num);
                answer += thumb;
                //왼쪽 엄지로 번호를 눌렀으면
                if(thumb.equals("L") == true)
                {
                    //왼쪽 엄지의 현재 위치를 누른 번호 위치로 변경한다.
                    leftThumbPos = numpadPos[num];
                    //바로 반복문의 조건문으로 이동한다.
                    continue;
                }
                //오른쪽 엄지로 번호를 눌렀으면
                if(thumb.equals("R") == true)
                {
                    //오른쪽 엄지의 현재 위치를 누른 번호 위치로 변경한다.
                    rightThumbPos = numpadPos[num];
                    //바로 반복문의 조건문으로 이동한다.
                    continue;
                }
            }
            return answer;
        }
        //키패드에서 번호를 누를 때 어느 쪽 엄지손가락을 사용할 지 정하기
        private String chooseThumb(int number)
        {
            //누를 번호가 1또는 4또는 7이면
            if(number == 1 || number == 4 || number == 7)
            {
                //왼쪽 엄지손가락으로 누른다.
                return "L";
            }
            //누를 번호가 3또는 6또는 9이면
            if(number == 3 || number == 6 || number == 9)
            {
                //오른쪽 엄지손가락으로 누른다.
                return  "R";
            }
            //누를 번호가 2, 5, 8, 0이면
            //왼쪽 엄지가 오른쪽 엄지보다 누를 번호(2, 5, 8 ,0)에서 더 멀면
            if(getDistance(leftThumbPos, number) > getDistance(rightThumbPos, number))
            {
                //오른쪽 엄지손가락으로 누른다.
                return "R";
            }
            //왼쪽 엄지가 오른쪽 엄지보다 누를 번호(2, 5, 8, 0)에서 더 가까우면
            if(getDistance(leftThumbPos, number) < getDistance(rightThumbPos, number))
            {
                //왼쪽 엄지손가락으로 누른다.
                return "L";
            }
            //왼쪽 엄지와 오른쪽 엄지의 거리가 서로 같으면 자신의 손잡이에 해당하는 엄지손가락으로 누른다.
            return this.hand;
        }
        //엄지손가락의 위치와 누를 번호 위치 사이의 거리구하기
        private int getDistance(int[] thumbPos, int number)
        {
            //엄지손가락의 x좌표와 키패드의 번호 x좌표 차의 절대값과
            //엄지손가락의 y좌표와 키패드의 번호 y좌표 차의 절대값의
            //합을 반환한다.(절대값의 합이 거리가 됨.)
            return Math.abs(thumbPos[0] - numpadPos[number][0])
                    + Math.abs(thumbPos[1] - numpadPos[number][1]);
        }
    }
```

# 다른 사람이 푼 코드 해석하며 공부하기

## Solution클래스 멤버 설정
먼저 Solution 클래스에서 필요한 멤버를 설정합니다.<br><br>
처음에는 키패드에 있는 숫자 번호를 2차원 좌표(x, y) 배열로 표현하여 이를 멤버로 설정합니다.<br><br>
이 배열의 크기는 10인데 **배열요소가 int[]배열**인 2차원 배열입니다.<br><br>
이 2차원 배열의 배열요소인 1차원 배열(int[]배열)은 크기가 2인데 배열요소가 int인 기본자료형의 값을 가지고 있습니다.<br><br>
그래서 0부터 시작해서 9까지(2차원 배열의 배열요소 10개)의 키패드에서 좌표(1차원 배열의 배열요소 2개)를 각각 입력하여 초기화합니다.<br><br>
다음으로 왼손엄지와 오른손엄지의 위치를 저장할 1차원 배열(int[])을 멤버로 두고, 왼손엄지는 \*(3,0)과 오른손엄지는 \#(3,2)로 초기값을 설정합니다.<br><br>
그리고 왼손잡이인지 오른손잡이인지 정보를 저장할 문자열 멤버인 hand를 둡니다.<br><br>

## getDistance 메소드
이 문제를 풀기 위해 Solution클래스에서 solutino메소드외에 2개의 메소드를 추가로 정의하였습니다.<br><br>
먼저 엄지손가락의 현재 위치와 누를 번호 위치 사이의 거리를 구하는 getDistance메소드를 정의합니다.<br><br>
getDistance는 Solution 클래스의 다른 메소드 내부에서만 호출될 것이기 때문에 접근제어자는 private으로 설정합니다.<br><br>
반환값은 현재 엄지손가락과 누를 번호 사이의 거리를  반환할 것이기 때문에 int형으로 정합니다.<br><br>
현재 손가락의 위치 좌표를 나타내는 int[]배열과 누를 번호인 int를 매개변수로 입력 받습니다.<br><br>
입력받은 매개변수로 거리를 계산하는데 이 때 사용하는 클래스가 Math클래스입니다.<br><br>
Math클래스의 정적메소드인 abs를 사용하면 매개변수로 입력한 값의 절대값을 반환합니다.<br><br>
매개변수로 입력 받은 엄지손가락의 x좌표를 뜻하는 thumbPos[0]과 키패드에서 누를 숫자의 x좌표를 의미하는 numpadPos[number][0]간의 차를 구하여,<br><br>
그 값을 Math.abs의 매개변수로 입력하여, 그 절대값을 구합니다.<br><br>
또한 매개변수로 입력 받은 엄지손가락의 y좌표를 뜻하는 thumbPos[1]과 키패드에서 누를 숫자의 y좌표를 의미하는 numpadPos[number][1]간의 차를 구하여,<br><br>
그 값을 Math.abs의 매개변수로 입력하여, 그 절대값을 구합니다.<br><br>
이 절대값들의 합은 엄지손가락의 현재 위치에서 눌러야 할 번호위치 사이에 거리를 의미하는데 이를 반환하면서 메소드가 종료됩니다.<br><br>

## chooseThumb
키패드에서 눌러야 할 번호를 누를 때 어떤 쪽 엄지로 누를 지에 대한 값을 반환해주는 chooseThumb 메소드를 정의합니다.<br><br>
이 chooseThumb 메소드 역시 Solution 클래스의 다른 메소드 내부에서만 호출될 것이기 때문에 접근제어자는 private으로 설정합니다.<br><br>
번호를 누를 때 어떤 엄지를 사용할지를 반환하기 때문에 반환형은 String으로 정합니다.<br><br>
그리고 눌러야 할 번호인 int를 매개변수로 입력받습니다.<br><br>
즉, 이 메소드는 누를 번호를 매개변수로 입력해주면 어떤 쪽 엄지로 그 번호를 눌러야 하는지 알려준다고 할 수 있습니다.<br><br>
매개변수로 입력 받는 숫자가 1, 4, 7이면 규칙에 따라 반드시 왼쪽 엄지로 누르도록 되어 있기 때문에 "L"을 반환하고, 메소드를 종료시킵니다.<br><br>
반면에 매개변수로 입력 받는 숫자가 3, 6, 9이면 규칙에 따라 반드시 오른쪽 엄지로 누르도록 되어 있기 때문에 "R"을 반환하고 메소드를 종료시킵니다.<br><br>
매개변수로 입력 받은 숫자가 2, 5, 8, 0 왼손엄지와 오른손엄지 중에 거리가 더 가까운 엄지를 선택해야하는데 이 때 그 거리를 계산하는 메소드로 아까 위에서 정의한 getDistance메소드를 호출합니다.<br><br>
먼저 getDistance 메소드에 왼쪽 엄지의 위치를 나타내는 leftThumbPos(1차원 int[]배열)와 누르고자 하는 번호(int)를 매개변수로 입력합니다.<br><br>
다음으로 getDistance 메소드에 오른쪽 엄지의 위치를 나타내는 rightThumbPos와 누르고자 하는 번호를 매개변수로 입력합니다.<br><br>
이제 이 두 getDistacne 메소드를 호출한 반환값을 비교하여 left가 right보다 거리가 더 크면 "R"을 출력하고 메소드를 종료시키고, left가 right보다 거리가 더 작으면 "L"을 출력하고 메소드를 종료시킵니다.<br><br>
그리고 두 엄지와 번호간의 거리가 같으면 자기 손잡이를 뜻하는 this.hand를 출력하며 메소드를 종료합니다.<br><br>
this.hand는 아직 초기화가 안되어 있는데 Soultion 클래스의 solution메소드에서 이 값을 초기화한 뒤에 chooseThumb 메소드를 호출할 것이기 때문에 상관이 없습니다.<br><br>

## solution

마지막으로 드디어 문제를 해결하는 메소드인 solutin메소드를 정의합니다.<br><br>
매개변수로 누를 숫자들을 나타내는 숫자배열과 왼손잡이인지 오른손잡이인지를 나타내는 문자열인 hand를 입력받습니다.<br><br>
먼저 삼항연산자와 String 클래스에서 오버라이딩한 equals 메소드를 이용하여 매개변수로 입력 받은 hand과 right과 같으면 this.hand를 "R"로 초기화 시켜주고, right과 같지 않으면 "L"로 초기화시켜줍니다.<br><br>
그 다음에 for each 반복을 통하여 매개변수로 입력 받은 숫자배열로부터 배열요소를 하나씩 구하면서 처음부터 마지막까지 반복을 돌립니다.<br><br>
이 반복문 내부에서 아까 정의한 chooseThumb메소드를 호출하는데 매개변수로 숫자배열에서 구한 배열요소를 입력합니다.<br><br>
그리고 chooseThumb를 메소드를 통해 어떤 엄지를 사용할지 반환받은 값을 answer에 +연산(String메소드)을 하여 누적시켜 줍니다.<br><br>
그 다음 어떤 엄지로 번호를 눌렀는지에 따라서 엄지손가락의 위치를 변경시켜줘야 합니다.<br><br>
즉, 실제로 번호를 누를 때 사용한 엄지는 그 번호의 위치로 위치를 변경시켜줘야 하고, 사용하지 않은 엄지는 위치를 그대로 둬야 합니다.<br><br>
그래서 이를 처리해주기 위해 chooseThumb를 메소드를 통해 반환받은 값이 "L"이면 왼손 엄지의 위치(좌표)를 나타내는 leftThumbPos 1차원 배열에 2차원배열인 numpadPos에서 누를 번호의 위치(좌표)를 의미하는 배열요소인 1차원 배열 numpadPos[num]을 대입해줍니다.<br><br>
반환받은 값이 "R"이면 오른손 엄지의 위치(좌표)를 나타내는 rightThumbPos 1차원 배열에 2차원배열인 numpadPos에서 누를 번호의 위치(좌표)를 의미하는 배열요소인 1차원 배열 numpadPos[num]을 대입해줍니다.<br><br>
그리고 반복문의 조건문으로 바로 이동할 수 있도록 continue를 이용합니다.<br><br>
이런 식으로 answer에 오른손이나 왼손을 의미하는 문자열을 누적시켜서 저장하고, 저장한 손의 엄지손가락의 위치를 갱신하면서 반복합니다.<br><br>
반복문이 끝나면 answer를 반환하면 answer에는 왼손 또는 오른손의 기록이 저장되어 있습니다.
