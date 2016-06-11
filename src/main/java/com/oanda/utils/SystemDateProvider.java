package com.oanda.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Evgeny Bazhanov  on 21.05.2016 8:28
 * .
 */
public class SystemDateProvider {
    /**
     * d: 2
     */
    private static final DateFormat NUMBER_DAY_FORMAT = new SimpleDateFormat("d");
    /**
     * y: 2016
     */
    private static final SimpleDateFormat NUMBER_YEAR_FORMAT = new SimpleDateFormat("y");
    /**
     * MMMM: ноябрь
     */
    private static final SimpleDateFormat STRING_MONTH_FORMAT = new SimpleDateFormat("MMMM");

    public static String getCurrentDay() {
        DateFormat dateFormat = NUMBER_DAY_FORMAT;
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String capitalize(String str) {
        String firstLetter = str.substring(0, 1).toUpperCase();
        return firstLetter + str.substring(1, 3);
    }

    public static String getCurrentMonth() {
        Date date = new Date();
        String rawDate = STRING_MONTH_FORMAT.format(date);
        return capitalize(rawDate);
    }

    public static String getCurrentYear() {
        DateFormat dateFormat = NUMBER_YEAR_FORMAT;
        Date date = new Date();
        return dateFormat.format(date);
    }
}
