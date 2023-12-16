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
    @When("user enters the unacceptable new username {string}")
    public void userEntersTheUnacceptableNewUsername(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("a wrong input message appears")
    public void aWrongInputMessageAppears() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
   @When("admin changes the username to {string} for user {string}")
    public void adminChangesTheUsernameToForUser(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @Then("the username is changed successfully")
    public void theUsernameIsChangedSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }



    @Then("the username is set successfully")
    public void theUsernameIsSetSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    
    @When("user enters the acceptable new username {string}")
    public void userEntersTheAcceptableNewUsername(String string) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    }
