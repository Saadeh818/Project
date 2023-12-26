package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagement {
    @Given("type selection dashboard opened")
    public void user_type_selection_dashboard_opened() {
        Users.userManagementScreen ( );
        Users.selectUserToMenageFlag =true;
    }

    @When("admin in user management entered {string}")
    public void admin_in_user_management_entered(String string) {
        Users.selectUserToMenage(string);
    }

    @Then("list installers")
    public void list_installers() {
        assertTrue(Users.isInstallerSelected ());
    }

    @Then("list customers")
    public void list_customers() {
        assertTrue(Users.isCustomerSelected ());
    }

    @Then("reload user management")
    public void reload_user_management() {
        assertFalse(Users.isInstallerSelected ()&&Users.isCustomerSelected ()&&Users.isAddUserSelected ());
    }

    @Then("add new user")
    public void addNewUser() {
        assertTrue(Users.isAddUserSelected ());
    }
}
