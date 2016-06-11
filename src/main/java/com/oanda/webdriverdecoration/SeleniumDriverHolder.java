package com.oanda.webdriverdecoration;

import org.openqa.selenium.WebDriver;

/**
 * Created by Evgeny  on 28.05.2016 8:18
 * .
 */

public class SeleniumDriverHolder {

    private static final ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverHolder.get();
    }

    public static void setWebDriver(WebDriver value) {
        driverHolder.set(value);
    }

}
