package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home {
    @When("user entered one {string}")
    public void userEnteredOne(String string) {

    }
    @Then("go to login page")
    public void goToLoginPage() {
    }
    @When("user entered tow {string}")
    public void userEnteredTow(String string) {
    }
    @Then("go to SignUp page")
    public void goToSignUpPage() {
    }
    @When("user entered {string}")
    public void userEntered(String string) {
    }
    @Then("display wrong choose and go home page")
    public void displayWrongChooseAndGoHomePage() {
    }
}
