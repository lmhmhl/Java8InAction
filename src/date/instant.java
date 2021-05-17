package date;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class instant {
    static {
        Instant instant = Instant.ofEpochMilli(3);
        Instant instant1 = Instant.ofEpochSecond(2);
        System.out.println(instant + " " + instant1);

        //Create timestamp
        Instant now = Instant.now();
        System.out.println(now);
        // int dayOfMonth = Instant.now().get(ChronoField.DAY_OF_MONTH);
        //System.out.println(dayOfMonth);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant now1 = Instant.now();
        // Duration could be used for calculate the duration of the process of compution.
        Duration d1 = Duration.between(now, now1);
        System.out.println(d1);
        // Period between date.
        Period between = Period.between(LocalDate.of(2013, 3, 3), LocalDate.of(2015, 4, 4));
        System.out.println(between);

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration fourMinutes = Duration.ofMinutes(4);

        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);

        LocalDate date = LocalDate.of(2021,12,3);
        date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if(dow==DayOfWeek.FRIDAY) dayToAdd=3;
            else if (dow==DayOfWeek.SATURDAY)dayToAdd=2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
    }

    public static void main(String[] args) {

    }
}
