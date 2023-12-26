package org.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Admin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminDashboard {
    @Given("user is admin and admin dashboard opened")
    public void user_is_admin_and_admin_dashboard_opened() {
        Admin.setAdminDashboardFlag ( true );
    }
    @When("admin in admin dashboard entered {string}")
    public void adminInAdminDashboardEntered(String arg0) {
        Admin.dashboardManager(arg0);
    }

    @Then("go to product management")
    public void go_to_product_management() {
        assertTrue(Admin.isAdminDashboardFlag ());
    }

    @Then("go to user management")
    public void go_to_user_management() {
        assertTrue(Admin.isManageUsersFlag());
    }

    @Then("sign out")
    public void sign_out() {
        assertFalse(Admin.isLoginFlag ());
    }

    @Then("reload dashboard")
    public void reload_dashboard() {
        assertTrue(Admin.isLoginFlag ());
    }

}
