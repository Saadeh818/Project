package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePassword {
    @When("user enter {string}")
    public void user_enter(String string) {
    }

    @Then("password format true")
    public void password_format_true() {
    }

    @Then("set password")
    public void set_password() {
    }

    @Then("password format false")
    public void password_format_false() {
    }
}
