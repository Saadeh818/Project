package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddUserByAdmin {
    @When("admin choose type {string} choose username {string} choose password {string}")
    public void admin_choose_type_choose_username_choose_password(String string, String string2, String string3) {
        Users.adduser ( string, string2, string3 );
    }

    @Then("add installer")
    public void add_installer() {
        assertFalse(Users.failToAdd);
    }

    @Then("add customer")
    public void add_customer() {
        assertFalse(Users.failToAdd);
    }

    @Then("fail to add")
    public void failToAdd() {
        assertTrue(Users.failToAdd);
    }
}
