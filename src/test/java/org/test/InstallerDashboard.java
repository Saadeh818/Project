package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Installer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InstallerDashboard {
    Installer installer = new Installer ();
    @Given("user is installer")
    public void user_is_installer() {
        Installer.setAdminDashboardFlag ( true );
    }

    @When("installer entered <{int}>")
    public void installer_entered(Integer int1) {
        installer.dashboardManager(int1.toString ());
    }

    @Then("list installation requests")
    public void list_installation_requests() {
        assertTrue( Installer.isListRequestsFlag ());
    }

    @When("installer entered {string}")
    public void installer_entered(String string) {
        installer.dashboardManager(string);
    }

    @Then("reload installer dashboard")
    public void reload_installer_dashboard() {
        assertTrue(Installer.isLoginFlag ());
    }

    @Then ( "sign out installer")
    public
    void signOutInstaller ( ) {
        assertFalse(Installer.isLoginFlag ());
    }
}
