package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangePassword {


    @When("user enters the right password format {string}")
    public void userEntersTheRightPasswordFormat(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("password format is true")
    public void passwordFormatIsTrue() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the password is set successfully")
    public void thePasswordIsSetSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @When("user enters the wrong password format {string}")
    public void userEntersTheWrongPasswordFormat(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @Then("password format is false")
    public void passwordFormatIsFalse() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("admin changes the password to {string} for user {string}")
    public void adminChangesThePasswordToForUser(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the password is changed successfully")
    public void thePasswordIsChangedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


    }

