package ProgramersLevel02;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static String[] solution(String[] records) {
        List<String> recordsList = new ArrayList<>();
        for(int i = 0; i < records.length; i++)
        {
            recordsList.add(records[i]);
        }
        StringTokenizer tokens;
        String frontA;
        String middleA;
        String frontB;
        String middleB;
        List<String> result = new ArrayList<>();
        int index = 0;
        while(index < recordsList.size())
        {
            tokens = new StringTokenizer(recordsList.get(index), " ");
            frontA = tokens.nextToken();
            if(frontA.equals("check"))
            {
                result.add(recordsList.get(index - 1));
                recordsList.remove(index - 1);
                recordsList.remove(index - 1);
                index--;
            }
            else
            {
                middleA = tokens.nextToken();
                if(index >= 1)
                {
                    tokens = new StringTokenizer(recordsList.get(index - 1), " ");
                    frontB = tokens.nextToken();
                    middleB = tokens.nextToken();
                    if(tokens.countTokens() == 0)
                    {
                        if(middleA.equals(middleB))
                        {
                            recordsList.set(index - 1, frontB + " " + frontA + " " + middleA);
                            recordsList.remove(index);
                        }
                        else
                        {
                            index++;
                        }
                    }
                    else
                    {
                        if(middleA.equals(tokens.nextToken()))
                        {
                            try
                            {
                                Integer.valueOf(middleB);
                                recordsList.set(index - 1, frontB + " " + (Integer.valueOf(middleB) + 1) + " " + middleA);
                            }
                            catch(Exception e)
                            {
                                recordsList.set(index - 1, frontB + " " + 2 + " " + middleA);
                            }
                            recordsList.remove(index);
                        }
                        else
                        {
                            index++;
                        }
                    }

                }
                else
                {
                    index++;
                }
            }
        }
        String[] answer = new String[result.size()];
        StringBuilder stb;
        String str;
        String command;
        for(int i = 0; i < answer.length; i++)
        {
            stb = new StringBuilder();
            tokens = new StringTokenizer(result.get(i), " ");
            stb.append(tokens.nextToken());
            stb.append(" ");
            if(tokens.countTokens() > 1)
            {
                stb.append("and");
                stb.append(" ");
                str = tokens.nextToken();
                try
                {
                    Integer.valueOf(str);
                    stb.append(str);
                    stb.append(" others");
                }
                catch (Exception e)
                {
                    stb.append(str);
                }
                stb.append(" ");
            }
            command = tokens.nextToken();
            if(command.equals("share"))
            {
                stb.append("shared your post");
            }
            else
            {
                stb.append("commented on your post");
            }
            answer[i] = stb.toString();
        }
        return answer;
    }
    public static void main(String[] args) {
	    //String[] answer = solution(new String[]{"john share", "mary comment", "jay share", "check notification", "check notification", "sally comment", "james share", "check notification", "lee share", "laura share", "will share", "check notification", "alice comment", "check notification"});
        //System.out.println(Arrays.toString(answer));
        String[] answer = solution(new String[]{"john share", "mary share", "jay share", "james comment", "lee share", "check notification", "sally comment", "laura comment", "check notification", "will share", "ruby share", "check notification"});
        System.out.println(Arrays.toString(answer));
    }
}
