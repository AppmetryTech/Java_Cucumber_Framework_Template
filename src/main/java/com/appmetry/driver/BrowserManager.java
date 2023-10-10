package com.appmetry.driver;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserManager {
   public static WebDriver doBrowserSetup(String browserName, String executionType, String remoteUrl)
           throws MalformedURLException {

      WebDriver driver = null;

      if (browserName.equalsIgnoreCase("chrome")) {
         ChromeOptions chromeOptions = new ChromeOptions();
         if (executionType.equalsIgnoreCase("local")) {
            chromeOptions.setHeadless(true);
            driver = new ChromeDriver(chromeOptions);
         } else if (executionType.equalsIgnoreCase("remote")) {
            chromeOptions.setCapability("se:name", "My simple test");
            driver = new RemoteWebDriver(new URL(remoteUrl), chromeOptions);
         } else {
            throw new IllegalArgumentException("Invalid execution type: " + executionType);
         }
      } else if (browserName.equalsIgnoreCase("edge")) {
         EdgeOptions edgeOptions = new EdgeOptions();
         if (executionType.equalsIgnoreCase("local")) {
            driver = new EdgeDriver(edgeOptions);
         } else if (executionType.equalsIgnoreCase("remote")) {
            edgeOptions.setCapability("se:name", "EDGE TEST");
            driver = new RemoteWebDriver(new URL(remoteUrl), edgeOptions);
         } else {
            throw new IllegalArgumentException("Invalid execution type: " + executionType);
         }
      } else if (browserName.equalsIgnoreCase("firefox")) {
         FirefoxOptions firefoxOptions = new FirefoxOptions();
         if (executionType.equalsIgnoreCase("local")) {
            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);
         } else if (executionType.equalsIgnoreCase("remote")) {
            firefoxOptions.setCapability("se:name", "FIREFOX TEST");
            driver = new RemoteWebDriver(new URL(remoteUrl), firefoxOptions);
         } else {
            throw new IllegalArgumentException("Invalid execution type: " + executionType);
         }
      } else {
         throw new IllegalArgumentException("Invalid browser name: " + browserName);
      }

      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      return driver;
   }
}


  /* public static WebDriver doBrowserSetup(String browserName) {

      WebDriver driver = null;
      if (browserName.equalsIgnoreCase("chrome")) {

         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("-headed");

         driver = new ChromeDriver(chromeOptions);
         driver.manage().window().maximize();

         driver.manage()
                 .timeouts()
                 .implicitlyWait(Duration.ofSeconds(10));

      } else if (browserName.equalsIgnoreCase("edge")) {

         driver = new EdgeDriver();
         driver.manage().window().maximize();

         driver.manage()
                 .timeouts()
                 .implicitlyWait(Duration.ofSeconds(10));

      }
      return driver;
   }
}
*/







