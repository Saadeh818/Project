package org.example.AcceptanceTest;

import org.junit.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {


    @Given("you are in signup page")
    public void you_are_in_signup_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("you should show please fill all informations")
    public void you_should_show_please_fill_all_informations() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @When("you write the {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
    public void youWriteTheAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("you write the {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} and {string}")
    public void youWriteTheAndAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        // Write code here that turns the phrase above into concrete actions

    }


    @Then("You should Show please enter another id")
    public void youShouldShowPleaseEnterAnotherId() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("You should Show please enter more than five character")
    public void youShouldShowPleaseEnterMoreThanFiveCharacter() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @Then("The Customer Added Successfully")
    public void theCustomerAddedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }


}
