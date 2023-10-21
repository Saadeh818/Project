package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    @Given("login screen is opened")
    public void login_screen_is_opened() {
    }

    @When("I enter correct username and correct password")
    public void i_enter_correct_username_and_correct_password() {
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
    }

    @Then("login screen switches to main screen")
    public void login_screen_switches_to_main_screen() {
    }

    @When("I enter wrong username or wrong password")
    public void i_enter_wrong_username_or_wrong_password() {
    }

    @Then("error message indicating failed login is prompted")
    public void error_message_indicating_failed_login_is_prompted() {
    }
}
