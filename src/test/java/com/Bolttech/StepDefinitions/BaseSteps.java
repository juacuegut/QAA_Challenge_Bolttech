package com.Bolttech.StepDefinitions;

import pages.HomePage;
import pages.ProductSummaryPage;

public class BaseSteps {

    HomePage homePage = new HomePage();
    ProductSummaryPage productSummaryPage = new ProductSummaryPage();

    public BaseSteps() throws Exception {}
}
