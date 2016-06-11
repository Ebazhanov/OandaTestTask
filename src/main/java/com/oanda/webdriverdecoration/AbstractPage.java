package com.oanda.webdriverdecoration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Evgeny  on 28.05.2016 8:19
 * .
 */
public abstract class AbstractPage {

    private static final int SECONDS_OF_WAITING_AN_ELEMENT = 5;
    private final WebDriverWait fluentWait;

    public AbstractPage() {
        fluentWait = new WebDriverWait(SeleniumDriverHolder.getDriver(), SECONDS_OF_WAITING_AN_ELEMENT);
    }

    public WebDriver.Navigation navigate() {
        return SeleniumDriverHolder.getDriver().navigate();
    }

    public String getCurrentWindowTitle() {
        return SeleniumDriverHolder.getDriver().getTitle();
    }


    public static void closeBrowser() {
        SeleniumDriverHolder.getDriver().manage().deleteAllCookies();
        SeleniumDriverHolder.getDriver().quit();
    }

    public WebElement findElement(final By locator) {
        return SeleniumDriverHolder.getDriver().findElement(locator);
    }

    public static void maximizeBrowserWindow() {
        SeleniumDriverHolder.getDriver().manage().window().maximize();
    }

    public WebElement waitForVisibilityOfElementLocatedBy(By locator) {
        return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitForInvisibilityOfElementLocatedBy(By locator) {
        return fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForPresenceOfElementLocatedBy(By locator) {
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean waitForTextToBePresentInElementValueByAttribute(WebElement locator, String text) {
        return fluentWait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
    }
}
