package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InstallerDashboard {
    @Given("user is installer")
    public void user_is_installer() {
    }

    @When("installer entered <{int}>")
    public void installer_entered(Integer int1) {
    }

    @Then("list installation requests")
    public void list_installation_requests() {
    }

    @When("installer entered {string}")
    public void installer_entered(String string) {
    }

    @Then("reload installer dashboard")
    public void reload_installer_dashboard() {
    }

    @Then("wrong input message appears")
    public void wrongInputMessageAppears() {
    }
}
