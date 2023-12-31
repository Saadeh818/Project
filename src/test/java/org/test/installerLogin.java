package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.main.Installer;
import org.junit.Assert;

public class installerLogin {
    Installer installer = new Installer ();
    @Given("that the installer is not logged in the app")
    public void thatTheInstallerIsNotLoggedInTheApp() {
        installer.clearCredentials();
    }
    @Given("the username installer is {string}")
    public void theUsernameInstallerIs(String string) {
        installer.setUsername ( string );
    }
    @Given("the password installer is {string}")
    public void thePasswordInstallerIs(String string) {
        installer.setPassword ( string );
    }
    @Then("the installer will not login")
    public void theInstallerWillNotLogin() {
        installer.login(installer.getUsername (),installer.getPassword ());
        Assert.assertFalse(Installer.isLoginFlag ());
    }
    @Then("the message appear to tell the installer what's wrong")
    public void theMessageAppearToTellTheInstallerWhatSWrong() {

    }
    @Then("the installer is logged in the app successfully")
    public void theInstallerIsLoggedInTheAppSuccessfully() {
        installer.login(installer.getUsername (),installer.getPassword ());
        Assert.assertTrue(Installer.isLoginFlag ());
    }


}
