package com.oanda.utils;

import com.oanda.webdriverdecoration.AbstractPage;
import com.oanda.webdriverdecoration.SeleniumDriverHolder;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Evgeny  on 28.05.2016 8:25
 * .
 */

public class BrowserSelectionUtil {

    public static void selectBrowser() throws Exception {

        DesiredCapabilities desiredCapabilities = null;
        switch (EnvProperties.BROWSER_TYPE) {
            case "Firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;
            case "Chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                break;
            case "IE":
                desiredCapabilities = DesiredCapabilities.internetExplorer();
                break;
            case "Safari":
                desiredCapabilities = DesiredCapabilities.safari();
                break;
            default:
                throw new IllegalStateException("Browser " + EnvProperties.BROWSER_TYPE + " not supported in tests");
        }
        SeleniumDriverHolder.setWebDriver(new FirefoxDriver(desiredCapabilities));
        AbstractPage.maximizeBrowserWindow();
    }
}
