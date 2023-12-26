package org.test;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class CustomerInvoice {

        public CustomerInvoice() {
            // Constructor to initialize objects or perform setup
        }

        // Existing step definitions...

    @Given("customer invoice tab is selected")
    public void customerInvoiceTabIsSelected() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I select an invoice from the invoice list")
    public void iSelectAnInvoiceFromTheInvoiceList() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("I make changes to the invoice details")
    public void iMakeChangesToTheInvoiceDetails() {
        // Write code here that turns the phrase above into concrete actions
    }
    @Then("the invoice details are updated in the invoice list")
    public void theInvoiceDetailsAreUpdatedInTheInvoiceList() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I click on the {string} button")
        public void iClickOnTheButton(String button) {

        }

        @And("I enter the necessary details for the new invoice")
        public void iEnterTheNecessaryDetailsForTheNewInvoice() {
        }

        @Then("a new invoice is created and added to the invoice list")
        public void aNewInvoiceIsCreatedAndAddedToTheInvoiceList() {
            // Implement code to verify that the new invoice is created and added to the list
        }

        @Then("the selected invoice is deleted from the invoice list")
        public void theSelectedInvoiceIsDeletedFromTheInvoiceList() {
            // Implement code to verify that the selected invoice is deleted from the list
        }

        @Given("I enter the customer email address")
        public void iEnterTheCustomerEmailAddress() {

        }

        @Then("the invoice is sent to the customer's email address.")
        public void theInvoiceIsSentToTheCustomerSEmailAddress() {
        }

    @Then("the details of the selected invoice are displayed on the screen")
    public void theDetailsOfTheSelectedInvoiceAreDisplayedOnTheScreen() {
//         Write code here that turns the phrase above into concrete actions
        }

}

