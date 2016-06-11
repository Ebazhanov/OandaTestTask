package com.oanda.utils;

/**
 * Created by Evgeny  on 28.05.2016 7:58
 * .
 */

public class EnvProperties {

    public static final String BROWSER_TYPE = getJenkinsVariablesFor("BROWSER_TYPE", "Firefox");

    protected static String getJenkinsVariablesFor(String jenkinsVariables, String defaultValue) {
        if (System.getenv(jenkinsVariables) == null) {
            return defaultValue;
        } else {
            return System.getenv(jenkinsVariables);
        }
    }
}


