package com.memoire.benapay.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

import lombok.var;

public class AppDateTime {
    public static String getTimeString(){

    Date date = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Use Madrid's time zone to format the date in
    System.out.print(TimeZone.getDefault());
    df.setTimeZone(TimeZone.getTimeZone("Africa/Kinshasa"));
    var time = df.format(date);
    return time;

    }
    
    public static LocalDateTime now(){
        return LocalDateTime.now(ZoneId.of("Africa/Kinshasa"));
    }
}
