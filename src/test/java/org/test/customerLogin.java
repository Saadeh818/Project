package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.main.Customer;
import org.junit.Assert;

public class customerLogin {
    @Given("that the customer is not logged in the app")
    public void thatTheCustomerIsNotLoggedInTheApp() {
        Customer.clearCredentials();
        new Customer ( );
    }
    @Given("the username customer is {string}")
    public void theUsernameCustomerIs(String string) {
        Customer.setUsername ( string );
    }
    @Given("the password customer is {string}")
    public void thePasswordCustomerIs(String string) {
        Customer.setPassword ( string );
    }
    @Then("the customer will not login")
    public void theCustomerWillNotLogin() {
        Customer.login(Customer.getUsername (),Customer.getPassword ());
        Assert.assertFalse(Customer.isLoginFlag ());
    }
    @Then("the message appear to tell the customer what's wrong")
    public void theMessageAppearToTellTheCustomerWhatSWrong() {

    }
    @Then("the customer is logged in the app successfully")
    public void theCustomerIsLoggedInTheAppSuccessfully() {
        Customer.login(Customer.getUsername (),Customer.getPassword ());
        Assert.assertTrue(Customer.isLoginFlag ());
    }


}
