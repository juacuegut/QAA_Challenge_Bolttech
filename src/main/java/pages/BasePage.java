package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends WebOperations {

    protected static String selectedPrice;
    protected static String dynamicPrice;
    protected static String selectedProduct;

    By acceptCookiesButton = By.xpath("//button[@id='onetrust-accept-btn-handler']");
    
    public BasePage acceptCookies(){
        click(acceptCookiesButton);
        waitFor(ExpectedConditions.invisibilityOfElementLocated(acceptCookiesButton));
        return this;
    }

}
