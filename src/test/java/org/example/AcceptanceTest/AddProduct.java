package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProduct {
    @Given("list of Categories appeared")
    public void list_of_categories_appeared() {
    }

    @When("Admin entered {string}{string}{string}{string}")
    public void admin_entered(String string, String string2, String string3, String string4) {
    }

    @Then("add {string} to products list")
    public void add_to_products_list(String string) {
    }

    @Then("wrong input message appear and return to add product")
    public void wrong_input_message_appear_and_return_to_add_product() {
    }
}
