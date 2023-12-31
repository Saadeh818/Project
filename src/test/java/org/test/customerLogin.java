package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.main.Customer;
import org.junit.Assert;

public class customerLogin {
    Customer customer = new Customer ();
    @Given("that the customer is not logged in the app")
    public void thatTheCustomerIsNotLoggedInTheApp() {
        customer.clearCredentials();
        new Customer ( );
    }
    @Given("the username customer is {string}")
    public void theUsernameCustomerIs(String string) {
        customer.setUsername ( string );
    }
    @Given("the password customer is {string}")
    public void thePasswordCustomerIs(String string) {
        customer.setPassword ( string );
    }
    @Then("the customer will not login")
    public void theCustomerWillNotLogin() {
        customer.login(customer.getUsername (),customer.getPassword ());
        Assert.assertFalse(Customer.isLoginFlag ());
    }
    @Then("the message appear to tell the customer what's wrong")
    public void theMessageAppearToTellTheCustomerWhatSWrong() {

    }
    @Then("the customer is logged in the app successfully")
    public void theCustomerIsLoggedInTheAppSuccessfully() {
        customer.login(customer.getUsername (),customer.getPassword ());
        Assert.assertTrue(Customer.isLoginFlag ());
    }


}
