package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Customer;
import org.main.Installer;
import org.main.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ChangeUsername {
    @When ( "user enters the right username format")
    public
    void userEntersTheRightUsernameFormat ( ) {
    }

    @Then ( "the username is set successfully")
    public
    void theUsernameIsSetSuccessfully ( ) {
        Customer.changeUserName ( 1, "SaaSaa@gmail.com" );
        assertTrue ( Users.usernameChanged );
    }

    @When ( "user enters the wrong userName format")
    public
    void userEntersTheWrongUserNameFormat ( ) {
    }

    @Then ( "the userName is not set")
    public
    void theUserNameIsNotSet ( ) {
        Installer.changeUserName ( 1, "saada2gmail,com" );
        assertFalse ( Users.usernameChanged );
    }
}
