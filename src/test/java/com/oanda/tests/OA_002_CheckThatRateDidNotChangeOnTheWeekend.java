package com.oanda.tests;

import com.oanda.basetest.SeleniumBaseTestClass;
import org.testng.annotations.Test;
import pages.ConverterMainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.oanda.testngutils.Group.smokeTest;

/**
 * Created by Evgeny  on 28.05.2016 7:53
 * .
 */
public class OA_002_CheckThatRateDidNotChangeOnTheWeekend extends SeleniumBaseTestClass {

    @Description("Test case to check that rate did not change on the weekend")
    @Title("Change end date and check rate")
    @Test(groups = {smokeTest})
    public void _ConvertUsdToEur() {
        new ConverterMainPage()
                .navigateToUrl("OANDA_URL")
                .checkTitleOfThePage("CONVERTER_TITLE")
                .clickOnCalendarIcon()
                .selectWeekend()
                .checkSelectedRateIntoInternalBankDropdown("ZERO_PERCENT")
                .checkDisplayedRateIntoDetailedInformation("ZERO_PERCENT");
    }
}
