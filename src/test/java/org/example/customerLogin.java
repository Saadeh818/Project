package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class customerLogin {
    private Customer customer = new Customer();
    @Given("that the customer is not logged in the app")
    public void thatTheCustomerIsNotLoggedInTheApp() {
        Customer.clearCredentials();
        customer = new Customer();
    }
    @Given("the username customer is {string}")
    public void theUsernameCustomerIs(String string) {
        Customer.username =string;
    }
    @Given("the password customer is {string}")
    public void thePasswordCustomerIs(String string) {
        Customer.password=string;
    }
    @Then("the customer will not login")
    public void theCustomerWillNotLogin() {
        Customer.login(Customer.username,Customer.password);
        Assert.assertFalse(Customer.loginFlag);
    }
    @Then("the message appear to tell the customer what's wrong")
    public void theMessageAppearToTellTheCustomerWhatSWrong() {

    }
    @Then("the customer is logged in the app successfully")
    public void theCustomerIsLoggedInTheAppSuccessfully() {
        Customer.login(Customer.username,Customer.password);
        Assert.assertTrue(Customer.loginFlag);
    }


}
