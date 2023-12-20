package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class CustomerInvoice {

        InvoiceManager invoiceManager = new InvoiceManager();
        Invoice currentInvoice;

    @Given("I select an invoice from the invoice list")
    public void iSelectAnInvoiceFromTheInvoiceList() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Given("I make changes to the invoice details")
    public void iMakeChangesToTheInvoiceDetails() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("the details of the selected invoice are displayed on the screen")
    public void theDetailsOfTheSelectedInvoiceAreDisplayedOnTheScreen() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


    @Then("the invoice details are updated in the invoice list")
    public void theInvoiceDetailsAreUpdatedInTheInvoiceList() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @And("customer invoice tab is selected")
        public void customerInvoiceTabIsSelected() {
            // Implement code for selecting the customer invoice tab
        }


        @When("I click on the {string} button")
        public void iClickOnTheButton(String button) {
            currentInvoice = new Invoice();
            // Implement code for clicking on the specified button
            if (button.equals("Create New Invoice")) {
                invoiceManager.createInvoice(currentInvoice);
            } else if (button.equals("Delete Invoice")) {
                invoiceManager.deleteInvoice(currentInvoice);
            } else if (button.equals("Edit Invoice")) {
                // Implement code for editing the invoice details
            } else if (button.equals("View Invoice")) {
                // Implement code for viewing the invoice details
            } else if (button.equals("Send Invoice")) {
                // Implement code for sending the invoice
            }
        }

        @And("I enter the necessary details for the new invoice")
        public void iEnterTheNecessaryDetailsForTheNewInvoice() {
            // Implement code for entering necessary details for the new invoice
            currentInvoice.setInvoiceNumber("001");
            currentInvoice.setCustomerName("dena");
            currentInvoice.setTotalAmount("$500");
            currentInvoice.setDueDate("2023-02-15");
        }

        @Then("a new invoice is created and added to the invoice list")
        public void aNewInvoiceIsCreatedAndAddedToTheInvoiceList() {
            // Implement code to verify that the new invoice is created and added to the list
            Assert.assertTrue(invoiceManager.invoiceExists(currentInvoice));
        }

        @Then("the selected invoice is deleted from the invoice list")
        public void theSelectedInvoiceIsDeletedFromTheInvoiceList() {
            // Implement code to verify that the selected invoice is deleted from the list
            Assert.assertFalse(invoiceManager.invoiceExists(currentInvoice));
        }

    @Given("I enter the customer email address")
    public void iEnterTheCustomerEmailAddress() {
        currentInvoice.setCustomerEmail("dena123@email.com");

}
    @Then("the invoice is sent to the customer's email address.")
    public void theInvoiceIsSentToTheCustomerSEmailAddress() {
        invoiceManager.sendInvoice(currentInvoice);
    }
    }
