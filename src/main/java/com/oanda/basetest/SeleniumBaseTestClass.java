package com.oanda.basetest;

import com.oanda.utils.PropertiesReader;
import com.oanda.webdriverdecoration.AbstractPage;
import com.oanda.utils.BrowserSelectionUtil;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by Evgeny  on 28.05.2016 8:11
 * .
 */

public class SeleniumBaseTestClass {

    @BeforeClass(alwaysRun = true)
    public void setup() throws Exception {
        PropertiesReader.readPropertiesFileWithAccountsTestData();
        BrowserSelectionUtil.selectBrowser();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        AbstractPage.closeBrowser();
    }
}
