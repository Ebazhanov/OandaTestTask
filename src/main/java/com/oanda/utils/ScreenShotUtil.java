package com.oanda.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

import static com.oanda.webdriverdecoration.SeleniumDriverHolder.getDriver;

/**
 * Created by Evgeny  on 28.05.2016 8:17
 * .
 */

public class ScreenShotUtil {

    @Attachment(value = "Скриншот ''{0}''", type = "image/png")
    public static byte[] captureScreen(String someCoolName) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
