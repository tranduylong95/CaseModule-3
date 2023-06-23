package com.example.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    public static String timeStamptoString(Timestamp timeStamp){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yy");
        String timeStampFormat=sdf.format(timeStamp);
        return timeStampFormat;
    }
    public static String ProcessTimeAfter(long currencyTime){
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = Instant.ofEpochMilli(currencyTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        long hours = currentDateTime.until(localDateTime, ChronoUnit.HOURS);
        long minutes = currentDateTime.until(localDateTime, ChronoUnit.MINUTES) % 60;
        long seconds = currentDateTime.until(localDateTime, ChronoUnit.SECONDS) % 60;
        if (!localDateTime.isBefore(currentDateTime)) {
            return hours+":"+minutes+":"+seconds;
        }
        return "00:00:00";
    }
    public static long ProcessTimeAfterHour(long currencyTime){
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = Instant.ofEpochMilli(currencyTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        long hours = currentDateTime.until(localDateTime, ChronoUnit.HOURS);
        if (!localDateTime.isBefore(currentDateTime)) {
            return hours;
        }
        return 0;
    }
    public static long ProcessTimeAfterMinus(long currencyTime){
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = Instant.ofEpochMilli(currencyTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        long minutes = currentDateTime.until(localDateTime, ChronoUnit.MINUTES) % 60;
        if (!localDateTime.isBefore(currentDateTime)) {
            return minutes;
        }
        return 0;
    }
    public static long ProcessTimeAfterSecond(long currencyTime){
        LocalDateTime currentDateTime = LocalDateTime.now();
        Instant instant = Instant.ofEpochMilli(currencyTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        long seconds = currentDateTime.until(localDateTime, ChronoUnit.SECONDS) % 60;
        if (!localDateTime.isBefore(currentDateTime)) {
            return seconds;
        }
        return 0;
    }
}
