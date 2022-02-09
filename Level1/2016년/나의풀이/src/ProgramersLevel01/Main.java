package ProgramersLevel01;

import java.time.Month;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static String solution(int a, int b) {
        DayOfWeek dayOfWeek = LocalDate.of(2016, Month.of(a), b).getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }
    public static void main(String[] args) {
	    String dayOfWeek = solution(5, 24);
        System.out.println(dayOfWeek);
    }
}
