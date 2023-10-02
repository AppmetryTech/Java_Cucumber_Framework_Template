package com.appmetry.stepdefinations;

import com.appmetry.PracticeTest.BaseTest;
import com.appmetry.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {

    private LoginPage loginPage;

    @Given("the login page is open")
    public void the_login_page_is_open() {
        loginPage = new LoginPage(BaseTest.getDriver());
        loginPage.redirectToLoginpage();
    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) throws InterruptedException {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);

       // Thread.sleep(5000);
    }

    @When("User click the login button")
    public void user_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should successfully login and see {string}")
    public void user_should_successfully_login_and_see(String expeString) {
        String actualString = loginPage.verifyLogin();

        Assert.assertEquals(actualString, expeString);
    }

    @Then("User should see {string}")
    public void user_should_see(String expeString) {
        Assert.assertEquals(loginPage.verifyErrorMsg(), expeString);
    }

}
