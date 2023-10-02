package com.appmetry.PracticeTest;

import org.openqa.selenium.WebDriver;
import com.appmetry.driver.BrowserManager;
import com.appmetry.utils.ConfigReader;

import io.cucumber.java.After;

import io.cucumber.java.Before;

public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private ConfigReader configReader;

    @Before
    public void Setup() {
        configReader = new ConfigReader();
        configReader.init_prop();

        // Get properties from config.properties
        String baseUrl = configReader.prop.getProperty("url");
        String browserType = configReader.prop.getProperty("browser");

        WebDriver driver = BrowserManager.doBrowserSetup(browserType);

        threadLocalDriver.set(driver);

        System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());
        getDriver().get(baseUrl);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    @After
    public void tearDown() {
        getDriver().quit();

        System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
        threadLocalDriver.remove();
    }

}