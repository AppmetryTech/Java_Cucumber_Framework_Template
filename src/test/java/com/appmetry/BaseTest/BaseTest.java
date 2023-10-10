package com.appmetry.BaseTest;
import com.appmetry.driver.DriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import com.appmetry.driver.BrowserManager;
import com.appmetry.utils.ConfigReader;
import io.cucumber.java.After;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private ConfigReader configReader;

   @Before
    public  void Setup() throws MalformedURLException {
        configReader = new ConfigReader();
        configReader.init_prop();

        // Get properties from config.properties
        String baseUrl = configReader.prop.getProperty("url");
        String browserName = configReader.prop.getProperty("browser");
        String execution = configReader.prop.getProperty("executionType");
        String remoteUrl = configReader.prop.getProperty("remoteUrl");
       // System.out.println(browser);

      //  WebDriver driver = BrowserManager.doBrowserSetup(browserType);
        WebDriver driver = BrowserManager.doBrowserSetup(browserName,execution,remoteUrl);
        DriverManager.setDriver(driver);
      //  threadLocalDriver.set(driver);

        System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());

         DriverManager.getDriver().get(baseUrl);
       // getDriver().get(baseUrl);
    }

  /*  public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }*/


    @After
    public void tearDown() {
      //  getDriver().quit();
        DriverManager.getDriver().quit();
        System.out.println("After Test Thread ID: " + Thread.currentThread().getId());
      //  threadLocalDriver.remove();
        DriverManager.unloadDriver();
    }



}