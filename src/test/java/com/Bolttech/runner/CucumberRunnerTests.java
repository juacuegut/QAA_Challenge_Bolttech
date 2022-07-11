package com.Bolttech.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = "src/test/resources/features",
        glue = "com.Bolttech.StepDefinitions",
        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
