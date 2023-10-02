package com.appmetry.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/resources/features", glue = { "com.appmetry.stepdefinations",
                "com.appmetry.PracticeTest", "com.appmetry.runner" }, plugin = {
                                "pretty",
                                "html:target/cucumber-reports" }, monochrome = true, dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {

}
