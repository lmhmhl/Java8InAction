package date;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.util.Locale;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class timeZone {
    static {
        ZoneId zoneId = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2020, 2, 2);
        ZonedDateTime dateTime = date.atStartOfDay(zoneId);
        System.out.println(dateTime);

        LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime1.atZone(zoneId);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(zoneId);

        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime3 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        dateTime3.toInstant(newYorkOffset);

        LocalDate date11 = LocalDate.of(2014, Month.MARCH, 18);
        JapaneseDate japaneseDate = JapaneseDate.from(date11);
        System.out.println(japaneseDate);

        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate now = japaneseChronology.dateNow();
        System.out.println(now);

    }

    public static void main(String args[]) {

    }
}

