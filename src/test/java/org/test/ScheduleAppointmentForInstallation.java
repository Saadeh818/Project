package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Customer;
import org.main.Installer;
import org.main.Appointment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScheduleAppointmentForInstallation {
    @Given("request ID")
    public void request_id() {
        Installer.setInstallationRequestId ( "0" );
    }

    @When("date is given as {string}")
    public void date_is_given_as(String string) {
        Customer.addAppointment ( string, Installer.requestID, Installer.userRequested );
    }

    @Then("add new appointment")
    public void add_new_appointment() {
        assertTrue ( Appointment.addSuccess );
    }

    @Then("retry appointment")
    public void retry_appointment() {
        assertFalse(Appointment.addSuccess);
    }
}
