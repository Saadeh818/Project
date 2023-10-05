package org.example.firstproject.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login  {
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
        @Then("login screen switches to main screen")
    public void loginScreenSwitchesToMainScreen() {
    }
    @Then("error message indicating failed login is prompted")
    public void errorMessageIndicatingFailedLoginIsPrompted() {
    }

}
