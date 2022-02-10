package ProgramersLevel01;

public class Main {
    public static int solution(int[][] sizes) {
        //명함의 가로길이와 세로길이를 비교
        int temp = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            //명함의 세로 길이가 가로 길이보다 더크면
            if(sizes[i][0] < sizes[i][1])
            {
                //명함의 가로 길이와 세로 길이를 바꾼다.
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        //명함의 가로 길이와 세로 길이의 최대 길이 구하기
        int maxWidth = 0;
        int maxHeight = 0;
        for(int i = 0; i < sizes.length; i++)
        {
            if(sizes[i][0] > maxWidth)
            {
                maxWidth = sizes[i][0];
            }
            if(sizes[i][1] > maxHeight)
            {
                maxHeight = sizes[i][1];
            }
        }
        return maxWidth * maxHeight;
    }
    public static void main(String[] args) {
	    int answer = solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}});
        System.out.println(answer);
        answer = solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}});
        System.out.println(answer);
        answer = solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
        System.out.println(answer);
    }
}
