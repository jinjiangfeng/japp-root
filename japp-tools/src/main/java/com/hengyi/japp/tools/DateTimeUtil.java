/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hengyi.japp.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import static org.apache.commons.lang3.StringUtils.isBlank;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author jzb
 */
public class DateTimeUtil {

    public static final DateFormat DF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat DF_TIME = new SimpleDateFormat("HH:mm");
    public static final DateFormat DF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String toDateString(Date date) {
        return date == null ? null : DF_DATE.format(date);
    }

    public static Date fromDateString(String s) {
        try {
            return isBlank(s) ? null : DF_DATE.parse(s);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toDateString(Date date, String pattern) {
        Validate.notBlank(pattern);
        return date == null ? null : new SimpleDateFormat(pattern).format(date);
    }

    public static Date fromDateString(String s, String pattern) {
        Validate.notBlank(pattern);
        try {
            return isBlank(s) ? null : new SimpleDateFormat(pattern).parse(s);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toTimeString(Date date) {
        return date == null ? null : DF_TIME.format(date);
    }

    public static Date fromTimeString(String s) {
        try {
            return isBlank(s) ? null : DF_TIME.parse(s);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toDateTimeString(Date date) {
        return date == null ? null : DF_DATETIME.format(date);
    }

    public static Date fromDateTimeString(String s) {
        try {
            return isBlank(s) ? null : DF_DATETIME.parse(s);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static Date toDate(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date toDate(LocalDate localDate) {
        return localDate == null ? null : toDate(localDate.atStartOfDay());
    }

    public static Date toDate(LocalTime localTime) {
        return localTime == null ? null : toDate(localTime.atDate(LocalDate.of(1977, Month.JANUARY, 1)));
    }

    public static Date toDate(LocalDate localDate, LocalTime localTime) {
        return (localDate == null || localTime == null) ? null : toDate(localTime.atDate(localDate));
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(Date date) {
        return date == null ? null : toLocalDateTime(date).toLocalDate();
    }

    public static LocalTime toLocalTime(Date date) {
        return date == null ? null : toLocalDateTime(date).toLocalTime();
    }
}
