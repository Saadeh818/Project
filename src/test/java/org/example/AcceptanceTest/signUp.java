package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signUp {
    @When("user entered username {string}")
    public void userEnteredUsername(String string) {
    }
    @When("password {string}")
    public void password(String string) {
    }
    @Then("Go to login page")
    public void goToLoginPage() {
    }
    @When("user entered username and username usability flag is {string}")
    public void userEnteredUsernameAndUsernameUsabilityFlagIs(String string) {
    }

    @Then("username is used try another one")
    public void usernameIsUsedTryAnotherOne() {

    }

    @When("user entered password and password acceptance flag is {string}")
    public void userEnteredPasswordAndPasswordAcceptanceFlagIs(String string) {
    }

    @Then("password formatted wrong try another one")
    public void passwordFormattedWrongTryAnotherOne() {

    }
}
