Feature: Login Page Functionality
              As a user,
              I want to be able to log in to my account,

        Background:
            Given the login page is open

        Scenario: Login with valid credentials
             When User enters username as "test@gmail.com" and password as "Test@1234"
              And User click the login button
             Then User should successfully login and see "Welcome to our store"

        Scenario Outline: Login with Invalid Logins
             When User enters username as "<username>" and password as "<password>"
              And User click the login button
             Then User should see "<expected_result>"

        Examples:
                  | username          | password      | expected_result                                                                                                       |
                  | user123@gmail.com | incorrectpass | I should see "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect" |
                
