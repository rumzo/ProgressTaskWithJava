package core;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Browser;

public class BasePage {

    protected static String getText(By locator){

        return Browser.driver.findElement(locator).getText();
    }

}
