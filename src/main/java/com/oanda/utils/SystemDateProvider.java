package com.oanda.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Evgeny Bazhanov  on 21.05.2016 8:28
 * .
 */
public class SystemDateProvider {

    /**
     * EEEE: среда
     */
    private static final DateFormat STRING_DAY_FORMAT = new SimpleDateFormat("EEEE");
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

    /**
     * MMM: ноябрь
     */
    private static final SimpleDateFormat INT_MONTH_FORMAT = new SimpleDateFormat("MMM");

    /**
     * EEE d: Ср 23
     */
    private static final SimpleDateFormat SHORT_STR_DAY_AND_NUMBER_OF_DATE_FORMAT = new SimpleDateFormat("EEE d");

    public static int getCurrentHour() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public static int getCurrentMinute() {
        Calendar calendar = GregorianCalendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    public static String getCurrentDay() {
        DateFormat dateFormat = NUMBER_DAY_FORMAT;
        Date date = new Date();
        return dateFormat.format(date);
    }

    private static String capitalize(String str) {
        String firstLetter = str.substring(0, 1).toUpperCase();
        return firstLetter + str.substring(1,3);
    }

    public static String getCurrentMonth() {
        Date date = new Date();
        String rawDate = STRING_MONTH_FORMAT.format(date);
        return capitalize(rawDate);
    }

    public static int getCurrentMonthInt() {
        Date date = new Date();
        return Integer.parseInt(INT_MONTH_FORMAT .format(date));
    }

    public static String getCurrentYear() {
        DateFormat dateFormat = NUMBER_YEAR_FORMAT;
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDayOfWeek() {
        Date date = new Date();
        String rawDate = STRING_DAY_FORMAT.format(date.getTime());
        return capitalize(rawDate);
    }

    public static String getDayOfWeek(int numberOfDay, int dayOfWeek) {
        Calendar dd = Calendar.getInstance();
        dd.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        dd.add(Calendar.DAY_OF_WEEK, numberOfDay);
        return SHORT_STR_DAY_AND_NUMBER_OF_DATE_FORMAT.format(dd.getTime());
    }

    public static String getDayOfWeekModified(int numberOfDay) {
        Calendar dd = Calendar.getInstance();
        dd.set(Calendar.DAY_OF_WEEK, Integer.parseInt(getCurrentDay()));
        dd.add(Calendar.DAY_OF_WEEK, numberOfDay);
        String rawDate = STRING_DAY_FORMAT.format(dd.getTime());
        return capitalize(rawDate);
    }

    public static String getCurrentDayModified(int numberOfDay) {
        Calendar dd = Calendar.getInstance();
        dd.set(Calendar.DAY_OF_WEEK, Integer.parseInt(getCurrentDay()));
        dd.add(Calendar.DAY_OF_WEEK, numberOfDay);
        String rawDate = NUMBER_DAY_FORMAT.format(dd.getTime());
        return capitalize(rawDate);
    }

    public static String getMonthModified(int numberOfMonth) {
        Calendar dd = Calendar.getInstance();
        dd.add(Calendar.MONTH, numberOfMonth);
        //dd.set(Calendar.MONTH, getCurrentMonthInt());
        String rawDate = STRING_MONTH_FORMAT.format(dd.getTime());
        return capitalize(rawDate);
    }

    public static String getCurrentMonthLocal() {
        Calendar calendar = new GregorianCalendar();
        Locale locale = new Locale("ru", "RU");
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
        return capitalize(month);
    }

    public static int getMonday() {
        return Calendar.MONDAY;
    }

    public static int getTuesday() {
        return Calendar.TUESDAY;
    }

    public static int getWednesday() {
        return Calendar.WEDNESDAY;
    }

    public static int getThursday() {
        return Calendar.THURSDAY;
    }

    public static int getFriday() {
        return Calendar.FRIDAY;
    }

    public static int getSaturday() {
        return Calendar.SATURDAY;
    }

    public static int getSunday() {
        return Calendar.SUNDAY;
    }
}
