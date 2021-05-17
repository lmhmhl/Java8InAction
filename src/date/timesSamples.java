package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class timesSamples {
    static {
        LocalTime time = LocalTime.of(13,23,3);
        int hour  = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println(hour+" "+ minute+" "+second);
        LocalDate localDate = LocalDate.parse("2021-05-17");
        LocalTime localTime = LocalTime.parse("13:03:03");
        System.out.println(localDate+" "+localTime);

        LocalDateTime dt1 = LocalDateTime.of(2021, Month.AUGUST,18,13,45,24);
        LocalDateTime dt2 = LocalDateTime.of(localDate,time);
        LocalDateTime dt3 = localDate.atTime(13,23,42);
        LocalDateTime dt4 = time.atDate(localDate);

        LocalDate localDate1 = dt1.toLocalDate();
        LocalTime localTime1 = dt1.toLocalTime();

    }


    public static void main(String[] args) {

    }
}
