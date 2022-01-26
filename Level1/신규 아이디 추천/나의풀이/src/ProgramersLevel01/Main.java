package ProgramersLevel01;

class Main {
    public String solution(String new_id) {
        String answer = "";
        //1단계
        answer = new_id.toLowerCase();
        //2단계
        String[] answers = answer.split("\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&" +
                "|\\*|\\(|\\)|\\=|\\+|\\[|\\]|\\{|\\}|\\:|\\?|,|\\<|\\>|\\/");
        answer = "";
        for(String str : answers)
        {
            answer += str;
        }
        //3단계
        while(answer.indexOf("..") != -1)
        {
            answer = answer.replace("..", ".");
        }
        //4단계
        if(answer.length() > 0 && answer.charAt(0) == '.')
        {
            answer = answer.replaceFirst(".", "");
        }
        if(answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
        {
            answer = answer.substring(0, answer.length() - 1);
        }
        //5단계
        if(answer.compareTo("") == 0)
        {
            answer = "a";
        }
        //6단계
        if(answer.length() > 15)
        {
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length() - 1) == '.')
            {
                answer = answer.substring(0, answer.length() - 1);
            }
        }
        //7단계
        while(answer.length() <= 2)
        {
            answer += answer.charAt(answer.length() -1);
        }


        return answer;
    }
}