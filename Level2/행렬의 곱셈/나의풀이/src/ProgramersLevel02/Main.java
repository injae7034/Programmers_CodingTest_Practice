package ProgramersLevel02;

public class Main {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;
        for(int i = 0; i < arr1.length; i++)
        {
            for(int j = 0; j < arr2[0].length; j++)
            {
                for(int k = 0; k < arr1[i].length; k++)
                {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
	    int[][] answer = solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}});
    }
}
