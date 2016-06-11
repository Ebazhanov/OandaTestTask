package pages;

import com.oanda.webdriverdecoration.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.oanda.utils.PropertiesReader.getProperty;

/**
 * Created by Evgeny Bazhanov on 11.06.2016 10:04
 * .
 */
public class ConverterMainPage extends AbstractPage {

    private static final String VALUE = "value";
    private static final By CURRENT_DAY_FIELD_LOCATOR = By.id("end_date_input");
    private static final By RESULT_OF_CALCULATION_LOCATOR = By.id("base_amount_input");
    private static final By DISPLAYED_SELL_AMOUNT_LOCATOR = By.id("sellMyCurrencyGet");
    private static final By INTER_BANK_RATE_LOCATOR = By.id("interbank_rates_input");
    private static final By QUOTE_CURRENCY_CODE = By.id("quote_currency_code");
    private static final By BASE_CURRENCY_CODE = By.id("base_currency_code");
    private static final By QUOTE_AMOUNT_INPUT_FIELD = By.id("quote_amount_input");
    private static final By AT_DATE_AND_RATE_LOCATOR = By.id("atDateAndRate");
    public static final By CALENDAR_POPUP_LOCATOR = By.cssSelector(".calendarContainer");
    public static final By END_DATE_BUTTON_LOCATOR = By.id("end_date_button");
    public static final By WEEKEND_LOCATOR = By.xpath("//td[@class='calendarWeekend'][1]");

    @Step("Navigate to URL")
    public ConverterMainPage navigateToUrl(String url) {
        navigate().to(getProperty(url));
        return this;
    }

    @Step("Check title of the Page")
    public ConverterMainPage checkTitleOfThePage(String titleName) {
        Assert.assertEquals(getCurrentWindowTitle(), getProperty(titleName));
        return this;
    }

    @Step("Compare current date (system) with displayed on the page")
    public ConverterMainPage compareCurrentDateWithDisplayedOne(String day, String month, String year) {
        Assert.assertEquals(waitForVisibilityOfElementLocatedBy(CURRENT_DAY_FIELD_LOCATOR).getAttribute(VALUE), day + " " + month + " " + year);
        return this;
    }

    public String getResultFromCalculatedAmountField() {
        return findElement(RESULT_OF_CALCULATION_LOCATOR).getAttribute(VALUE);
    }

    public double getResultFromCalculatedAmountFieldInt() {
        return Double.parseDouble(replaceSign(waitForVisibilityOfElementLocatedBy(RESULT_OF_CALCULATION_LOCATOR).getAttribute(VALUE)));
    }

    public String replaceSign(String number) {
        return number.replace(',', '.');
    }


    @Step("Check amount of calculation")
    public ConverterMainPage checkAmountOfCalculation(Double defaultAmount) {
        String left = new String(getResultFromCalculatedAmountField());
        left = left.replace(" ", "");
        left = left.replace(',', '.');
        double right = QUOTE_AMOUNT * defaultAmount;
        right = Math.round(right * 100.0) / 100.0;
        Assert.assertEquals(Double.parseDouble(left), right);
        return this;
    }

    private double QUOTE_AMOUNT = 0;

    public double getDefaultQuoteAmount() {
        QUOTE_AMOUNT = getResultFromCalculatedAmountFieldInt();
        return QUOTE_AMOUNT;
    }

    @Step("Compate default amount between displayed and base calculated field")
    public ConverterMainPage compareDefaultAmountBetweenDisplayedAndBaseCalculatedField() {
        Assert.assertEquals(waitForVisibilityOfElementLocatedBy(DISPLAYED_SELL_AMOUNT_LOCATOR).getText(), "вы получаете " + getResultFromCalculatedAmountField() + " EUR");
        getDefaultQuoteAmount();
        return this;
    }

    @Step("Check selected rate into internal bank dropdown")
    public ConverterMainPage checkSelectedRateIntoInternalBankDropdown(String percent) {
        Assert.assertEquals(waitForVisibilityOfElementLocatedBy(INTER_BANK_RATE_LOCATOR).getAttribute(VALUE), getProperty(percent));
        return this;
    }

    @Step("Check selected currency code into existing right field")
    public ConverterMainPage checkSelectedCurrencyCodeIntoExistingField(String currency) {
        Assert.assertEquals(waitForVisibilityOfElementLocatedBy(QUOTE_CURRENCY_CODE).getText(), getProperty(currency));
        return this;
    }

    @Step("Check selected currency code into required right field")
    public ConverterMainPage checkSelectedCurrencyCodeIntoRequiredField(String currency) {
        Assert.assertEquals(waitForVisibilityOfElementLocatedBy(BASE_CURRENCY_CODE).getText(), getProperty(currency));
        return this;
    }

    @Step("Enter amount to quote right field {0}")
    public ConverterMainPage enterAmountToQuoteField(String amount) {
        WebElement quoteFieldElement = waitForVisibilityOfElementLocatedBy(QUOTE_AMOUNT_INPUT_FIELD);
        quoteFieldElement.clear();
        quoteFieldElement.sendKeys(amount);
        waitForTextToBePresentInElementValueByAttribute(findElement(QUOTE_AMOUNT_INPUT_FIELD), amount);
        quoteFieldElement.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Check displayed reate into detailed information sentences")
    public ConverterMainPage checkDisplayedRateIntoDetailedInformation(String percent) {
        Assert.assertTrue(waitForVisibilityOfElementLocatedBy(AT_DATE_AND_RATE_LOCATOR).getText().contains(getProperty(percent)));
        return this;
    }

    @Step("Click on calendar icon")
    public ConverterMainPage clickOnCalendarIcon() {
        waitForVisibilityOfElementLocatedBy(END_DATE_BUTTON_LOCATOR).click();
        waitForVisibilityOfElementLocatedBy(CALENDAR_POPUP_LOCATOR);
        return this;
    }
    @Step("Select weekend")
    public ConverterMainPage selectWeekend() {
        waitForVisibilityOfElementLocatedBy(WEEKEND_LOCATOR).click();
        waitForInvisibilityOfElementLocatedBy(CALENDAR_POPUP_LOCATOR);
        return this;
    }
}
