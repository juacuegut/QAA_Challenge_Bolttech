package com.Bolttech.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductSummaryPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Formatter;
import java.util.TimeZone;

public class CartValidationSteps extends BaseSteps {

    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";

    public CartValidationSteps() throws Exception {}

    @When("I click in Select card")
    public void iClickInSelectCard() throws Exception {
        productSummaryPage = homePage.goToProductSummary();
    }

    @Then("I am redirected to the product summary")
    public void iAmRedirectedToTheProductSummary() {
        productSummaryPage.isProductSummaryPageLoaded();
    }

    @And("I can see original price strike through")
    public void iCanSeeOriginalPriceStrikeThrough() {
        productSummaryPage.isOriginalPriceStrikeThrough();
    }

    @And("Current price at zero")
    public void currentPriceAtZero() {
        productSummaryPage.isCurrentPrice("฿0.00");
    }

    @And("Expected product name")
    public void expectedProductName() {
        productSummaryPage.isExpectedProduct();
    }

    @And("Bolttech as provider")
    public void bolttechAsProvider() {
        productSummaryPage.isExpectedProvider();
    }

    @And("Contract start date in Thailand Timezone")
    public void contractStartDateInThailandTimezone() {
        productSummaryPage.calculateContractStartDateInThailandTimezone();
    }

    @And("Contract renewal as Monthly")
    public void contractRenewalAsMonthly() {
        productSummaryPage.contractRenewal();
    }

    @And("Billing start date")
    public void billingStartDate() {
        productSummaryPage.billingStartDate();
    }
}
