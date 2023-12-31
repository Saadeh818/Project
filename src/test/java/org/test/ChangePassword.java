package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Customer;
import org.main.Installer;
import org.main.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChangePassword {
    Installer installer = new Installer ();
    Customer customer = new Customer ();
    @When("user enters the right password format")
    public void userEntersTheRightPasswordFormat() {
    }
    @Then("the password is set successfully")
    public void thePasswordIsSetSuccessfully() {
        customer.changePassword ( 1, "147852369" );
        assertTrue ( Users.isPasswordUpdated () );
    }
    @When("user enters the wrong password format")
    public void userEntersTheWrongPasswordFormat() {
    }
    @Then("the password is not set")
    public void passwordFormatIsFalse() {
        installer.changePassword ( 1, "963258741" );
        assertFalse ( Users.isPasswordUpdated () );
    }
}
