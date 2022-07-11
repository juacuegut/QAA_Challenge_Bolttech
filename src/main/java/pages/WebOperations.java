package pages;

import driver.DriverManager;
import io.github.sukgu.Shadow;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

import static constants.FrameworkConstants.getShadowPollingTime;
import static constants.FrameworkConstants.getShadowWaitingTime;

public class WebOperations extends MyFluentWait {

    WebDriver driver = DriverManager.getDriver();
    Shadow shadow = new Shadow(driver);

    public WebOperations() {}

    protected void sendKeys(By element, String value){
        waitFor(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(value);
    }

    protected void click(By element){
        waitFor(ExpectedConditions.visibilityOfElementLocated(element));
        waitFor(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    protected void click(WebElement element){
        waitFor(ExpectedConditions.visibilityOf(element));
        waitFor(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickDropdownAndSelect(String element, String value) throws Exception {
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        click(shadow.findElement(element));
        click(shadow.findElementByXPath("//li[text()='" + value + "']"));
    }

    public String clickDropdownAndSelect(String element, int option) throws Exception {
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        click(shadow.findElement(element));
        String valueToClick = shadow.findElementsByXPath("//ul[@class='form-list']//li").get(option-1).getText();
        click(shadow.findElementByXPath("//li[text()='" + valueToClick + "']"));
        return valueToClick;
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition) {
        return waitFor(condition, true);
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, boolean shouldFail) {
        return waitFor(condition, 50, ChronoUnit.SECONDS, shouldFail);
    }

    protected <K> Optional<K> waitFor(ExpectedCondition<K> condition, long time, TemporalUnit unit, boolean shouldFail) {
            return (new MyFluentWait()).waitFor(condition, time, unit, shouldFail);
    }

    public static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
