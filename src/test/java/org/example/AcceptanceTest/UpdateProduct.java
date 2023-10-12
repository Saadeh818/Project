package org.example.AcceptanceTest;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProduct {
    @When("user enter category number'<categoryNum>'")
    public void user_enter_category_number_category_num() {
    }

    @Then("list items")
    public void list_items() {
    }

    @When("user enter category number'<WrongCategoryNum>'")
    public void user_enter_category_number_wrong_category_num() {
    }

    @Then("wrong input message appears")
    public void wrong_input_message_appears() {
    }

    @Then("reload categories")
    public void reload_categories() {
    }
}
