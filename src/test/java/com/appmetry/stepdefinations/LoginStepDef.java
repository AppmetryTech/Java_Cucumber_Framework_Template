package com.appmetry.stepdefinations;

import com.appmetry.pages.LoginPage;
import com.appmetry.driver.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;



public class LoginStepDef {

    private LoginPage loginPage;

    @Given("the login page is open")
    public void the_login_page_is_open() {
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.redirectToLoginPage();

    }

    @When("^User enters username as \\\"(.*)\\\" and password as \\\"(.*)\\\"$")
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


  /* @Then("User should see (.*)$")
   public void user_should_see(String expeString) {
       Assert.assertEquals(loginPage.verifyErrorMsg(), expeString);
   }*/

    @Then("User should see {string}")
    public void user_should_see(String string) {
        Assert.assertEquals(loginPage.verifyErrorMsg(), string);
    }




}
