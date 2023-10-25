package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeUsername {
    @When("username entered {string}")
    public void username_entered(String string) {
    }

    @Then("set username")
    public void set_username() {
    }
}
