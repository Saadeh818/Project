package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Appointment;
import org.main.Customer;
import org.main.ProductC;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public
class AddInstallationRequest {
    @When ("customer choos the product successfully")
    public void customer_choose_the_product_successfully() {
        Customer.addInstallationRequest ( 3 , 5 , "ahmad@installer.com,00000000" );
    }

    @Then ("Check product")
    public void check_product() {
        assertTrue ( ProductC.checkIfProductExists ( 3 ) );
    }

    @Then("add installation request")
    public void add_installation_request() {
        assertTrue ( Customer.isInstallationRequestAdded () );
    }

    @When("customer choos the product wrong")
    public void customer_choos_the_product_wrong() {
        Customer.addInstallationRequest(888 , 5 , "frommain@installer.com,ahmad010101" );
    }

    @Then("Check product Fail")
    public void check_product_fail() {
        assertFalse(ProductC.checkIfProductExists ( 888));
    }

    @Then("add installation request Fail")
    public void add_installation_request_fail() {
        assertFalse ( Customer.isInstallationRequestAdded () );
    }

    @When("view Appointment methode been called")
    public void view_appointment_methode_been_called() {
        Appointment.viewAppointments ( "deema@customer.com" );
    }
    @Then("show all appintments related to the customer")
    public void show_all_appintments_related_to_the_customer() {
        assertTrue ( Appointment.isUserHasAppointments () );
    }

    @When ( "view Appointment methode been called by Installer")
    public
    void viewAppointmentMethodeBeenCalledByInstaller ( ) {
        Appointment.viewAllAppointments ();
    }

    @Then ( "Show all appointments")
    public
    void showAllAppointments ( ) {
        assertTrue ( Appointment.isAppointmentsDisplayed () );
    }
}
