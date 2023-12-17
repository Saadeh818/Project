package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class ListInstallationRequests {
    @Given("installation requests appeared")
    public void installation_requests_appeared() {
        Installer.listRequestsFlag = true;
    }
    @When("user entered installation request id {string}")
    public void user_entered_installation_request_id(String string) {
        Installer.SetInstallationRequestId("1. ");
    }
    @Then("go to schedule appointment")
    public void go_to_schedule_appointment() {
        assertTrue(Installer.listRequestsFlag && Installer.requestFound);
    }


}
