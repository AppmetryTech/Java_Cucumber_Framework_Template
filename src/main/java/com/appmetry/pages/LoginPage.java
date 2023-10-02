package com.appmetry.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

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

    public void redirectToLoginpage() {
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

}
