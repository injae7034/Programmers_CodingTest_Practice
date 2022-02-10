package ProgramersLevel01;

import java.util.StringTokenizer;

public class Main {
    public static int solution(String dartResult) {
        StringTokenizer scoreTokens = new StringTokenizer(dartResult, "SDT*#");
        int[] scores = new int[]{0, Integer.parseInt(scoreTokens.nextToken()),
                Integer.parseInt(scoreTokens.nextToken()),
                Integer.parseInt(scoreTokens.nextToken())};
        StringTokenizer bonusTokens = new StringTokenizer(dartResult, "012345678910*#");
        String[] bonuses = new String[]{"", bonusTokens.nextToken(), bonusTokens.nextToken(),
                bonusTokens.nextToken()};
        String[] options = new String[]{"", "", "", ""};
        for(int i = 1; i < options.length; i++)
        {
            dartResult = dartResult.substring(dartResult.indexOf(bonuses[i]) + 1);
            if(dartResult.compareTo("") != 0 &&
                    (dartResult.charAt(0) == '*' || dartResult.charAt(0) == '#'))
            {
                options[i] = String.valueOf(dartResult.charAt(0));
            }
        }
        for(int i = 1; i < scores.length; i++)
        {
            if(bonuses[i].compareTo("D") == 0)
            {
                scores[i] *= scores[i];
            }
            else if(bonuses[i].compareTo("T") == 0)
            {
                scores[i] = scores[i] * scores[i] * scores[i];
            }
            if(options[i].compareTo("*") == 0)
            {
                scores[i - 1] *= 2;
                scores[i] *= 2;
            }
            else if(options[i].compareTo("#") == 0)
            {
                scores[i] *= -1;
            }
        }
        return scores[1] + scores[2] + scores[3];
    }
    public static void main(String[] args) {
	    int answer = solution("1S2D*3T");
        System.out.println(answer);
        answer = solution("1D2S#10S");
        System.out.println(answer);
        answer = solution("1D2S0T");
        System.out.println(answer);
        answer = solution("1S*2T*3S");
        System.out.println(answer);
        answer = solution("1D#2S*3S");
        System.out.println(answer);
        answer = solution("1T2D3D#");
        System.out.println(answer);
        answer = solution("1D2S3T*");
        System.out.println(answer);
    }
}
