package pages;
import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFormPage extends BasePage {

    private static final By FIRST_NAME_FIELD = By.id("Textbox-1");
    private static final By LAST_NAME_FIELD = By.id("Textbox-3");
    private static final By EMAIL_FIELD = By.id("Email-1");
    private static final By COMPANY_FIELD = By.id("Textbox-2");
    private static final By PHONE_FIELD = By.id("Textbox-4");
    private static final By PRODUCT_INTEREST_DROP_DOWN = By.id("Dropdown-1");
    private static final By COUNTRY_DROP_DOWN = By.id("Country-1");
    private static final By MESSAGE_FIELD = By.id("Textarea-1");
    private static final By CONTACT_US_BUTTON = By.cssSelector("#C023_Col00 .Btn");
    private static final By ACCEPT_COOKIES_BUTTON = By.cssSelector("#onetrust-banner-sdk #onetrust-accept-btn-handler");
    private static final By STATE_PROVINCE_DROP_DOWN = By.id("State-1");
    private static final By CONFIRMATION_MESSAGE = By.cssSelector("#form--1 span[data-sf-role*='success-message']");
    private static final By FIRST_NAME_FIELD_ERROR_MESSAGE = By.cssSelector("#Textbox-1 + p");
    private static final By LAST_NAME_FIELD_ERROR_MESSAGE = By.cssSelector("#Textbox-3 + p");
    private static final By EMAIL_FIELD_ERROR_MESSAGE = By.cssSelector("#Email-1 + p");
    private static final By PHONE_FIELD_ERROR_MESSAGE = By.cssSelector("#Textbox-4 + p");
    private static final By COMPANY_FIELD_ERROR_MESSAGE = By.cssSelector(".sf-fieldWrp .dnb-input + p");
    private static final By PRODUCT_INTEREST_ERROR_MESSAGE = By.cssSelector("#Dropdown-1 + p");
    private static final By COUNTRY_ERROR_MESSAGE = By.cssSelector("#Country-1 + p");
    private static final By MESSAGE_FIELD_ERROR_MESSAGE = By.cssSelector("#Textarea-1 + p");


    public static void goToFormPage() {
        Browser.driver.get("https://www.ipswitch.com/test-form-page");
    }

    public static void fillFormWithValidData(String firstName, String lastName, String email, String phone, String company, String message) {
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        Browser.driver.findElement(EMAIL_FIELD).sendKeys(email);
        Browser.driver.findElement(PHONE_FIELD).sendKeys(phone);
        Browser.driver.findElement(COMPANY_FIELD).sendKeys(company);

        WebElement productInterest = Browser.driver.findElement(PRODUCT_INTEREST_DROP_DOWN);
        Select productInterestDropDown = new Select(productInterest);
        productInterestDropDown.selectByVisibleText("iMacros");

        WebElement country = Browser.driver.findElement(COUNTRY_DROP_DOWN);
        Select countryDropDown = new Select(country);
        countryDropDown.selectByVisibleText("Bulgaria");

        Browser.driver.findElement(MESSAGE_FIELD).sendKeys(message);
        Browser.driver.findElement(ACCEPT_COOKIES_BUTTON).click();
        Browser.driver.findElement(CONTACT_US_BUTTON).click();

    }

    public static void verifyConfirmationMessage(String expectedValidationMessage, String messageOnFailure) {

        WebElement confirmationMessage = Browser.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form--1 span[data-sf-role*='success-message']")));
        String actualMessage = confirmationMessage.getText();
        Assert.assertTrue(messageOnFailure, actualMessage.contains(expectedValidationMessage));
    }

    public static void fillFormWithInvalidEmail(String firstName, String lastName, String email, String phone, String company, String message){
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        Browser.driver.findElement(EMAIL_FIELD).sendKeys(email);
        Browser.driver.findElement(PHONE_FIELD).sendKeys(phone);
        Browser.driver.findElement(COMPANY_FIELD).sendKeys(company);

        WebElement productInterest = Browser.driver.findElement(PRODUCT_INTEREST_DROP_DOWN);
        Select productInterestDropDown = new Select(productInterest);
        productInterestDropDown.selectByVisibleText("iMacros");

        WebElement country = Browser.driver.findElement(COUNTRY_DROP_DOWN);
        Select countryDropDown = new Select(country);
        countryDropDown.selectByVisibleText("Bulgaria");

        Browser.driver.findElement(MESSAGE_FIELD).sendKeys(message);
        Browser.driver.findElement(ACCEPT_COOKIES_BUTTON).click();
        Browser.driver.findElement(CONTACT_US_BUTTON).click();
    }

    public static void verifyEmailValidationMessage(String expectedValidationMessage, String messageOnFailure){

        WebElement emailErrorMessage = Browser.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Email-1 + p")));
        String actualMessage = emailErrorMessage.getText();
        Assert.assertTrue(messageOnFailure, actualMessage.contains(expectedValidationMessage));
    }

    public static void fillFormWithCountryUSA(String firstName, String lastName, String email, String phone, String company, String message) {
        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        Browser.driver.findElement(LAST_NAME_FIELD).sendKeys(lastName);
        Browser.driver.findElement(EMAIL_FIELD).sendKeys(email);
        Browser.driver.findElement(PHONE_FIELD).sendKeys(phone);
        Browser.driver.findElement(COMPANY_FIELD).sendKeys(company);

        WebElement productInterest = Browser.driver.findElement(PRODUCT_INTEREST_DROP_DOWN);
        Select productInterestDropDown = new Select(productInterest);
        productInterestDropDown.selectByVisibleText("iMacros");

        WebElement country = Browser.driver.findElement(COUNTRY_DROP_DOWN);
        Select countryDropDown = new Select(country);
        countryDropDown.selectByVisibleText("USA");

        WebElement stateProvince = Browser.driver.findElement(STATE_PROVINCE_DROP_DOWN);
        Select stateProvinceDropDown = new Select(stateProvince);
        stateProvinceDropDown.selectByVisibleText("Alabama");

        Browser.driver.findElement(MESSAGE_FIELD).sendKeys(message);
        Browser.driver.findElement(ACCEPT_COOKIES_BUTTON).click();
        Browser.driver.findElement(CONTACT_US_BUTTON).click();

    }
    
    public static void checkAllProductInterestOptions(){
        WebElement productInterest = Browser.driver.findElement(PRODUCT_INTEREST_DROP_DOWN);
        Select productInterestDropDown = new Select(productInterest);

        List<String> expOptions = Arrays.asList(new String[]{"WhatsUp Gold","iMacros", "Log Management", "WS_FTP Professional", "WS_FTP Server", "MOVEit", "MessageWay"});
        List<String> actOptions = new ArrayList<>();

        List<WebElement> allOptions = productInterestDropDown.getOptions();

        for (WebElement option: allOptions) {
            if (!(option.getText().equals("Select...")))
            actOptions.add(option.getText());
        }

        Assert.assertEquals(actOptions, expOptions);
    }

    public static void verifyValidationMessages(String firstNameValidationMessage, String lastNameValidationMessage, String emailValidationMessage, String phoneValidationMessage, String companyValidationMessage, String productInterestValidationMessage, String countryValidationMessage, String messageFieldValidationMessage, String messageOnFailure) throws InterruptedException {

        Browser.wait.until(ExpectedConditions.elementToBeClickable(CONTACT_US_BUTTON)).click();
        Thread.sleep(2000);
        Browser.wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BUTTON)).click();

        String firstNameMessage = getText(FIRST_NAME_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, firstNameMessage.contains(firstNameValidationMessage));

        String lastNameMessage = getText(LAST_NAME_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, lastNameMessage.contains(lastNameValidationMessage));

        String emailNameMessage = getText(EMAIL_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, emailNameMessage.contains(emailValidationMessage));

        String phoneMessage = getText(PHONE_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, phoneMessage.contains(phoneValidationMessage));

        String companyMessage = getText(COMPANY_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, companyMessage.contains(companyValidationMessage));

        String productInterestMessage = getText(PRODUCT_INTEREST_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, productInterestMessage.contains(productInterestValidationMessage));

        String countryMessage = getText(COUNTRY_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, countryMessage.contains(countryValidationMessage));

        String messageField = getText(MESSAGE_FIELD_ERROR_MESSAGE);
        Assert.assertTrue(messageOnFailure, messageField.contains(messageFieldValidationMessage));
    }
}
