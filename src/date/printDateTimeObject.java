package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @program: java8demo
 * @description:
 * @author: LMH
 * @create: 2021-05-17
 **/
public class printDateTimeObject {
    static {
        LocalDate date = LocalDate.of(2021, 3, 18);
        String format = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20210318
        String format1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2021-03-18
        LocalDate date1 = LocalDate.parse("20210318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2021-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format2 = date.format(formatter);
        LocalDate parse = LocalDate.parse(format2, formatter);


        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date3 = LocalDate.of(2014, 3, 18);
        String formattedDate = date.format(italianFormatter);
        LocalDate date4 = LocalDate.parse(formattedDate, italianFormatter);


    }

    public static void main(String[] args) {

    }
}
