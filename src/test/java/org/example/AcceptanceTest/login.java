package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {
        @Given("login screen is opened")
          public void loginScreenIsOpened() {
        }
        @When("I enter correct username and correct password")
        public void iEnterCorrectUsernameAndCorrectPassword() {
           }
        @When("I enter wrong username or wrong password")
        public void iEnterWrongUsernameOrWrongPassword() {
           }
        @When("I click on the login button")
        public void iClickOnTheLoginButton() {
             }
    @When("I enter wrong username or  wrong password")
    public void i_enter_wrong_username_or_wrong_password() {
    }

    @Then("login screen switches to main screen")
    public void loginScreenSwitchesToMainScreen() {
    }
    @Then("error message indicating failed login is prompted")
    public void errorMessageIndicatingFailedLoginIsPrompted() {
    }

}
