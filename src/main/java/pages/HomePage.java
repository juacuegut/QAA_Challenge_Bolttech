package pages;

import constants.FrameworkConstants;
import enums.DropdownPriceRanges;
import io.github.sukgu.Shadow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.security.SecureRandom;
import java.util.Random;

import static constants.FrameworkConstants.getShadowPollingTime;
import static constants.FrameworkConstants.getShadowWaitingTime;

public final class HomePage extends BasePage {

    private final Random rand = SecureRandom.getInstanceStrong(); // SecureRandom is preferred to

    String purchasePriceDropdown = "span#selected";
    String dynamicPriceUnderCard = "span#dynamicPrice";
    String dynamicPriceInTable = "//div[@style='color:#222222;']";
    String selectButton = "//span[@class='content right-icon']";
    String productNameInCard = "//div[@class='vertical-card__content fixed-height ']//p[@class='card-title']";


    public HomePage() throws Exception {}

    public ProductSummaryPage goToProductSummary() throws Exception {
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        selectedProduct = shadow.findElementByXPath(productNameInCard).getText();
        click(shadow.findElementByXPath(selectButton));
        return new ProductSummaryPage();
    }

    public HomePage chooseDevicePurchasePrice(String priceRange) throws Exception {
        selectedPrice = priceRange;
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        clickDropdownAndSelect(purchasePriceDropdown, priceRange);
        Assert.assertEquals(shadow.findElement(purchasePriceDropdown).getText(), priceRange);
        return this;
    }

    public HomePage chooseDevicePurchasePrice() throws Exception {
        int min = 1;
        int max = 7;
        int value = this.rand.nextInt(max) + min;
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        String clickedValue = clickDropdownAndSelect(purchasePriceDropdown, value);
        selectedPrice = clickedValue;
        Assert.assertEquals(shadow.findElement(purchasePriceDropdown).getText(), clickedValue);
        return this;
    }

    public HomePage checkDynamicPrices() throws Exception {
        shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        DropdownPriceRanges priceRange = findByValue(selectedPrice);
        dynamicPrice = priceRange.getDynamicPrice();
        waitFor(ExpectedConditions.visibilityOf(shadow.findElementByXPath(selectButton)));
        Assert.assertEquals(shadow.findElement(dynamicPriceUnderCard).getText(), dynamicPrice);
        Assert.assertEquals(shadow.findElementByXPath(dynamicPriceInTable).getText(), dynamicPrice);
        return this;
    }

    public static DropdownPriceRanges findByValue(String value) {
        DropdownPriceRanges result = null;
        for (DropdownPriceRanges prices : DropdownPriceRanges.values()) {
            if (prices.getLabel().equalsIgnoreCase(value)) {
                result = prices;
                break;
            }
        }
        return result;
    }
}
