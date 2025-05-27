package ru.homeWork.mySecondHW.frontTests.tools;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHelper {

    public final static String MONTH_YEAR_DATE_PATTERN = "MMMM yyyy";
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String transformLocalDateToString(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
    }

    public static LocalDate parseDateTimeString(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
        return dateTime.toLocalDate();
    }
}
