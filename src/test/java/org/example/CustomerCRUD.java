package org.example;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerCRUD {

    private Map<String, Map<String, String>> customers = new HashMap<>();
    @Given("main screen is opened")
    public void mainScreenIsOpened() {
        System.out.println("Main screen is opened");
    }

    @And("customer tab is opened")
    public void customerTabIsOpened() {
        System.out.println("Customer tab is opened");
    }

    @Given("I enter customer information")
    public void enterCustomerInformation(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> customerInfo = dataTable.asMap(String.class, String.class);
        String name = customerInfo.get("Name");
        customers.put(name, customerInfo);
        System.out.println("Enter customer information: " + customerInfo);
    }

    @And("the name is not empty")
    public void nameIsNotEmpty() {
        // Assuming the name is not empty, no specific action needed
    }

    @When("I click add customer button")
    public void clickAddCustomerButton() {
        // Implement logic to click the add customer button
        System.out.println("Click add customer button");
    }

    @Then("a new customer is added to the list")
    public void verifyCustomerAddedToList() {
        // Assuming the customer is added successfully, no specific verification
        System.out.println("Verify a new customer is added to the list");
    }

    @Given("I select a customer from the list")
    public void selectCustomerFromList(io.cucumber.datatable.DataTable dataTable) {

            List<Map<String, String>> customerList = dataTable.asMaps(String.class, String.class);

            if (customerList.size() > 1) {
                throw new IllegalArgumentException("Expected a single customer in the DataTable, but found multiple.");
            }

            Map<String, String> customerInfo = customerList.get(0);
            String name = customerInfo.get("Customer Name");

            // Transform the single Map to a Map<String, List<String>>
            Map<String, String> customerData = new HashMap<>();
            for (Map.Entry<String, String> entry : customerInfo.entrySet()) {
                customerData.put(entry.getKey(), String.valueOf(List.of(entry.getValue())));
            }

            customers.put(name, customerData);
            System.out.println("Select a customer from the list: " + name);
        }


    @And("I enter a different customer information")
    public void enterDifferentCustomerInformation(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> updatedInfo = dataTable.asMap(String.class, String.class);
        String name = updatedInfo.get("Customer Name");
        Map<String, String> put = customers.put(name, updatedInfo);
        System.out.println("Enter different customer information: " + updatedInfo);
    }

    @When("I click update customer button")
    public void clickUpdateCustomerButton() {
        // Implement logic to click the update customer button
        System.out.println("Click update customer button");
    }

    @Then("the selected customer is updated")
    public void verifyCustomerUpdated() {
        // Assuming the customer is updated successfully, no specific verification
        System.out.println("Verify the selected customer is updated");
    }

    @When("I click delete customer button")
    public void clickDeleteCustomerButton() {
        // Implement logic to click the delete customer button
        System.out.println("Click delete customer button");
    }

    @Then("the selected customer is deleted")
    public void verifyCustomerDeleted() {
        // Assuming the customer is deleted successfully, no specific verification
        System.out.println("Verify the selected customer is deleted");
    }


}