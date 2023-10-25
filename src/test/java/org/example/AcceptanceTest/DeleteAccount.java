package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteAccount {
    @When("user enter right password {string}")
    public void user_enter_right_password(String string) {
    }

    @Then("delete account")
    public void delete_account() {
    }

    @When("user enter wrong password {string}")
    public void user_enter_wrong_password(String string) {
    }

    @Then("wrong password message appeared")
    public void wrong_password_message_appeared() {
    }
}
