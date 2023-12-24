package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangePassword {
    @When("user enters the right password format")
    public void userEntersTheRightPasswordFormat() {
        Users.changePassword ( );
    }
    @Then("the password is set successfully")
    public void thePasswordIsSetSuccessfully() {
        Customer.changePassword ( 1, "147852369" );
        assertTrue ( Users.passwordUpdated );
    }
    @When("user enters the wrong password format")
    public void userEntersTheWrongPasswordFormat() {

    }
    @Then("the password is not set")
    public void passwordFormatIsFalse() {
        Installer.changePassword ( 1,"963258741" );
        assertFalse ( Users.passwordUpdated );
    }
}
