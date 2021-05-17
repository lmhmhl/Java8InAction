package date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class datesamples {
    static {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayAmountOfMonth = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
        LocalDate today = LocalDate.now();
        System.out.println(date + " " + year + " " + month + " " + " " + day + " " + dayOfWeek + " " + dayAmountOfMonth + " " + leap + " " + today);
        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println(year1 + " " + month1+" "+day1);
    }

    public static void main(String[] args) {

    }
}
