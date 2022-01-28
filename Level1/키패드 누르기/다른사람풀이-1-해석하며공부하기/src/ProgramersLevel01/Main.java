package ProgramersLevel01;

public class Main {
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
    public static void main(String[] args) {
	// write your code here
    }
}
