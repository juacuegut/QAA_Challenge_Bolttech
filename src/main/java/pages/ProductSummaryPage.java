package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static constants.FrameworkConstants.getShadowPollingTime;
import static constants.FrameworkConstants.getShadowWaitingTime;

public final class ProductSummaryPage extends BasePage {

    private static final String LANGUAGETAG = "es-ES";
    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd", Locale.forLanguageTag(LANGUAGETAG));
    DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MMM", Locale.forLanguageTag(LANGUAGETAG));
    DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy", Locale.forLanguageTag(LANGUAGETAG));

    String productSummaryCard = "//div[@id='productSummary']";
    String titleProductSummary = "//div[@class='product-summary-title title-font']";
    String originalPriceStrikeThrough = "//p[@class='original-price']";
    String currentPrice = "//p[@class='final-price']";
    String productNameInCard = "//p[@class='title']";
    String providerName = "//span[@id='providerName']";
    String subscriptionStartDate = "//span[@id='subscriptionStartDate']";
    String subscriptionRenewal = "//span[@id='subscriptionRenewal']";
    String billingStartDate = "//span[@id='billingStartDate']";

    public boolean isProductSummaryPageLoaded() {
        try {
            shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitFor(ExpectedConditions.visibilityOf(shadow.findElementByXPath(titleProductSummary)));
        Assert.assertEquals(shadow.findElementByXPath(titleProductSummary).getText(),"Great choice, here are the details.");
        return true;
    }

    public void isOriginalPriceStrikeThrough() {
        try {
            shadow.setExplicitWait(getShadowWaitingTime(),getShadowPollingTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitFor(ExpectedConditions.visibilityOf(shadow.findElementByXPath(originalPriceStrikeThrough)));
        Assert.assertEquals(shadow.findElementByXPath(originalPriceStrikeThrough).getText(), dynamicPrice);
    }

    public void isCurrentPrice(String price) {
        Assert.assertEquals(shadow.findElementByXPath(currentPrice).getText(), price);
    }

    public void isExpectedProduct() {
        Assert.assertEquals(shadow.findElementByXPath(productNameInCard).getText(), selectedProduct);
    }

    public void isExpectedProvider() {
        Assert.assertEquals(shadow.findElementByXPath(providerName).getText(), "bolttech");
    }

    public void calculateContractStartDateInThailandTimezone() {
        String date = getZonedDateTime().format(formatterDay) + " " + capitalize(getZonedDateTime().format(formatterMonth)) + " " + getZonedDateTime().format(formatterYear);
        Assert.assertEquals(shadow.findElementByXPath(subscriptionStartDate).getText(), date);
    }

    public void billingStartDate() {
        ZonedDateTime calculatedDate = getZonedDateTime().plusMonths(2).minusDays(10);
        String month;
        if("Sep".equals(capitalize(calculatedDate.format(formatterMonth)))) {
            month = "Sept";
        } else {
            month = capitalize(calculatedDate.format(formatterMonth));
        }
        String date = calculatedDate.format(formatterDay) + " " + month + " " + calculatedDate.format(formatterYear);
        Assert.assertEquals(shadow.findElementByXPath(billingStartDate).getText(), date);
    }

    public void contractRenewal() {
        Assert.assertEquals(shadow.findElementByXPath(subscriptionRenewal).getText(), "Monthly");
    }

    public ZonedDateTime getZonedDateTime() {
        Instant now = Instant.now();
        return now.atZone(ZoneId.of("Asia/Bangkok"));
    }

}
