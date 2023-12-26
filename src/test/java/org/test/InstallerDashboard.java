package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Installer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstallerDashboard {
    @Given("user is installer")
    public void user_is_installer() {
        Installer.adminDashboardFlag =true;
    }

    @When("installer entered <{int}>")
    public void installer_entered(Integer int1) {
        Installer.dashboardManager(int1.toString ());
    }

    @Then("list installation requests")
    public void list_installation_requests() {
        assertTrue( Installer.listRequestsFlag);
    }

    @When("installer entered {string}")
    public void installer_entered(String string) {
        Installer.dashboardManager(string);
    }

    @Then("reload installer dashboard")
    public void reload_installer_dashboard() {
        assertTrue(Installer.loginFlag);
    }

    @Then ( "sign out installer")
    public
    void signOutInstaller ( ) {
        assertFalse(Installer.loginFlag);
    }
}
