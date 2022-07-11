package com.Bolttech.StepDefinitions;

import driver.DriverManager;
import enums.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.ReadPropertyFile;

public class FirstTestSteps extends BaseSteps {

    public FirstTestSteps() throws Exception {}

    @Given("I am in the Bolttech webpage")
    public void i_am_in_the_bolttech_webpage() {
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(), ReadPropertyFile.getValue(ConfigProperties.URL));
    }
    @Given("I accept cookies")
    public void iAcceptCookies() {
        homePage.acceptCookies();
    }

    @When("I click {string} in the device price dropdown list")
    public void iClickInTheDevicePriceDropdownList(String price) throws Exception {
        homePage.chooseDevicePurchasePrice(price);
    }

    @When("I click in a value of the device price dropdown list")
    public void iClickInAValueOfTheDevicePriceDropdownList() throws Exception {
        homePage.chooseDevicePurchasePrice();
    }

    @Then("I can see dynamic prices updated properly")
    public void iCanSeeDynamicPricesUpdatedProperly() throws Exception {
        homePage.checkDynamicPrices();
    }
}
