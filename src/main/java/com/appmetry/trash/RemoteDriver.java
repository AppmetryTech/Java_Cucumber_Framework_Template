package com.appmetry.trash;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class RemoteDriver {
    private WebDriver dr;

    public RemoteDriver() throws MalformedURLException {
       ChromeOptions chromeOptions = new ChromeOptions();
       // FirefoxOptions chromeOptions = new FirefoxOptions();
      /*  chromeOptions.setCapability("browserVersion", "100");
        chromeOptions.setCapability("platformName", "Windows");*/
// Showing a test name instead of the session id in the Grid UI
        chromeOptions.setCapability("se:name", "My simple test");
        dr = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
    }

    public void get(String url) {
        dr.get(url);
    }
    public void enterSearch(String name){
        dr.findElement(By.name("q")).sendKeys(name);
    }
    public void quit() {
        dr.quit();
    }

    public static void main(String[] args) throws MalformedURLException {
        RemoteDriver driver = new RemoteDriver();
        driver.get("http://google.com");
        driver.enterSearch("TEST AUTOMATION");
        System.out.println("passed");
        driver.quit();
    }


}
