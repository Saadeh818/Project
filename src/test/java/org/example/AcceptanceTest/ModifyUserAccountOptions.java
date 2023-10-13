package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifyUserAccountOptions {
    @When("modify account option input is {string}")
    public void modify_account_option_input_is(String string) {
    }

    @Then("go to change password <{string}>")
    public void go_to_change_password(String string) {
    }

    @Then("go to change username <{string}>")
    public void go_to_change_username(String string) {
    }

    @When("modify account option is {string}")
    public void modify_account_option_is(String string) {
    }

    @Then("go to delete account <{string}>")
    public void go_to_delete_account(String string) {
    }

    @When("modify account option'<chars>'")
    public void modify_account_option_chars() {
    }

    @Then("reload modify account option <{string}>")
    public void reload_modify_account_option(String string) {
    }
}
