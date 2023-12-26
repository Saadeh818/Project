package org.test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Admin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminLogin {
    @Given("the admin is not logged in the app")
    public void the_admin_is_not_logged_in_the_app() {
        Admin.clearCredentials();
    }

    @When("the admin provides valid credentials")
    public void the_admin_provides_valid_credentials(DataTable dataTable) {
        Admin.setUsername ( dataTable.cell ( 1, 0 ) );
        Admin.setPassword ( dataTable.cell ( 1, 1 ) );
    }

    @When("the admin attempts to log in")
    public void the_admin_attempts_to_log_in() {
        // Write code here that turns the phrase above into concrete actions
        Admin.login ( );
    }

    @Then("the admin is successfully logged into the app")
    public void the_admin_is_successfully_logged_into_the_app() {
        // Write code here that turns the phrase above into concrete actions

        assertTrue(Admin.isLoginFlag ());
    }

    @When("the admin provides invalid credentials")
    public void the_admin_provides_invalid_credentials(DataTable dataTable) {
        Admin.setUsername ( dataTable.cell ( 1, 0 ) );
        Admin.setPassword ( dataTable.cell ( 1, 1 ) );
    }

    @Then("the admin is unable to log in")
    public void the_admin_is_unable_to_log_in() {
        assertFalse(Admin.isLoginFlag ());
    }

    @Then("an error message is displayed to inform the admin of the issue")
    public void an_error_message_is_displayed_to_inform_the_admin_of_the_issue() {
        assertFalse(Admin.isErrorMessageFlag());
    }

    @When("the admin provides empty credentials")
    public void the_admin_provides_empty_credentials(DataTable dataTable) {
        Admin.setUsername ( dataTable.cell ( 1, 0 ) );
        Admin.setPassword ( dataTable.cell ( 1, 1 ) );
    }
}