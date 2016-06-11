package com.oanda.tests;

import com.oanda.basetest.SeleniumBaseTestClass;
import org.testng.annotations.Test;
import pages.ConverterMainPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static com.oanda.testngutils.Group.smokeTest;
import static com.oanda.utils.SystemDateProvider.*;

/**
 * Created by Evgeny  on 28.05.2016 7:53
 * .
 */
public class OA_001_ConvertUsdToEurForCurrentDay extends SeleniumBaseTestClass {

    private static final double AMOUNT_D = 2400;
    private static final String AMOUNT_S = "2400";

    @Description("Test case for checking result of converter between USD and EUR")
    @Title("Converterd from USD to EUR")
    @Test(groups = {smokeTest})
    public void _ConvertUsdToEur() {
        new ConverterMainPage()
                .navigateToUrl("OANDA_URL")
                .checkTitleOfThePage("CONVERTER_TITLE")
                .checkSelectedCurrencyCodeIntoExistingField("USD")
                .checkSelectedCurrencyCodeIntoRequiredField("EUR")
                .compareCurrentDateWithDisplayedOne(getCurrentDay(), getCurrentMonth(), getCurrentYear())
                .checkSelectedRateIntoInternalBankDropdown("ZERO_PERCENT")
                .checkDisplayedRateIntoDetailedInformation("ZERO_PERCENT")
                .compareDefaultAmountBetweenDisplayedAndBaseCalculatedField()
                .enterAmountToQuoteField(AMOUNT_S)
                .checkAmountOfCalculation(AMOUNT_D);
    }
}
