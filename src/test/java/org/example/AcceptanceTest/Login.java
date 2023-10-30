package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    @Given("the login screen is opened")
    public void the_login_screen_is_opened() {
    }

    @When("I enter a correct username and correct password for an admin")
    public void i_enter_a_correct_username_and_correct_password_for_an_admin() {
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
    }

    @Then("the login screen switches to the admin dashboard")
    public void the_login_screen_switches_to_the_admin_dashboard() {
    }

    @When("I enter a correct username and correct password for a customer")
    public void i_enter_a_correct_username_and_correct_password_for_a_customer() {
    }

    @Then("the login screen switches to the customer dashboard")
    public void the_login_screen_switches_to_the_customer_dashboard() {
    }

    @When("I enter a correct username and correct password for an installer")
    public void i_enter_a_correct_username_and_correct_password_for_an_installer() {
    }

    @Then("the login screen switches to the installer dashboard")
    public void the_login_screen_switches_to_the_installer_dashboard() {
    }

    @When("I enter a wrong username or wrong password")
    public void i_enter_a_wrong_username_or_wrong_password() {
    }

    @Then("an error message indicating a failed login is prompted")
    public void an_error_message_indicating_a_failed_login_is_prompted() {
    }
}
