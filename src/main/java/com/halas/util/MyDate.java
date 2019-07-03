package com.halas.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class MyDate {
    private static final Logger LOG = LogManager.getLogger(MyDate.class);
    private static final int FROM_MILLIS_TO_MINUTES = 1000 * 60;

    private MyDate() {
    }

    public static String getCurrentDateTime() {
        Date instant = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("_yyyy-MM-dd_HH.mm.ss.SSS");
        return sdf.format(instant);
    }

    public static String getCurrentTimeHoursMinutes() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date instant = new Date();
        return sdf.format(instant);
    }

    public static boolean isOnePlusOrOneLessMinutes(String timeFirst, String timeSecond) {
        long timeFirstMillis = convertToSecondsFromHHmm(timeFirst).getTime() / (FROM_MILLIS_TO_MINUTES);
        long timeSecondMillis = convertToSecondsFromHHmm(timeSecond).getTime() / (FROM_MILLIS_TO_MINUTES);
        long resultDiffBetweenDates = Math.abs(timeFirstMillis - timeSecondMillis);
        LOG.debug("Difference in minutes between dates: " + resultDiffBetweenDates);
        return resultDiffBetweenDates <= 1;
    }

    private static Date convertToSecondsFromHHmm(String time) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
