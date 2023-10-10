package com.appmetry.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    // wihtout using pagefactory
    // Locators
    private By openLoginPageLocator = By.className("ico-login");
    private By emailFieldLocator = By.id("Email");
    private By passwordFieldLocator = By.id("Password");
    private By loginButtonLocator = By.xpath("//button[@type='submit' and text()='Log in']");
    private By getLoginTitleLocator = By.className("topic-block-title");
    private By errorMsgLocator = By.xpath("//div[@class='message-error validation-summary-errors']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void redirectToLoginPage() {
        driver.findElement(openLoginPageLocator).click();
    }

    public void enterUsername(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public String verifyLogin() {
        return driver.findElement(getLoginTitleLocator).getText();
    }

    public String verifyErrorMsg() {
        return driver.findElement(errorMsgLocator).getText();
    }
}

    // using pageFactory
/*
    @FindBy(className = "ico-login")
    WebElement openLoginPage;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and text()='Log in']")
    WebElement loginButton;

    @FindBy(className = "topic-block-title")
    WebElement getLoginTitle;

    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void redirectToLoginPage() {
        openLoginPage.click();
    }

    public void enterUsername(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);

    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String verifyLogin() {
        return getLoginTitle.getText();
    }

    public String verifyErrorMsg(){
        return errorMsg.getText();
    }

*/




