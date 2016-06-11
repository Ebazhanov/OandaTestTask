package com.oanda.listeners;

import com.oanda.utils.ScreenShotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Evgeny  on 28.05.2016 8:13
 * .
 */

public class TakeScreenshotOnFailureListeners implements ITestListener, ITestNGListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Step("Шаг на onTestFailur в testng listener")
    @Override
    public void onTestFailure(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        ScreenShotUtil.captureScreen(methodName);
    }

    @Step("Шаг на onTestSkipped в testng listener")
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        String methodName = iTestResult.getMethod().getMethodName();
        ScreenShotUtil.captureScreen(methodName);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
