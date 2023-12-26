package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.main.Installer;
import org.junit.Assert;

public class installerLogin {
    private Installer installer = new Installer();
    @Given("that the installer is not logged in the app")
    public void thatTheInstallerIsNotLoggedInTheApp() {
        Installer.clearCredentials();
        installer = new Installer();
    }
    @Given("the username installer is {string}")
    public void theUsernameInstallerIs(String string) {
        Installer.username =string;
    }
    @Given("the password installer is {string}")
    public void thePasswordInstallerIs(String string) {
        Installer.password=string;
    }
    @Then("the installer will not login")
    public void theInstallerWillNotLogin() {
        Installer.login(Installer.username,Installer.password);
        Assert.assertFalse(Installer.loginFlag);
    }
    @Then("the message appear to tell the installer what's wrong")
    public void theMessageAppearToTellTheInstallerWhatSWrong() {

    }
    @Then("the installer is logged in the app successfully")
    public void theInstallerIsLoggedInTheAppSuccessfully() {
        Installer.login(Installer.username,Installer.password);
        Assert.assertTrue(Installer.loginFlag);
    }


}
