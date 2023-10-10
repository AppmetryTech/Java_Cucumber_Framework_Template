package com.appmetry.trash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserManager1 {



    public class BrowserManager {

        public static WebDriver doBrowserSetup(String browserName) {

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
}
