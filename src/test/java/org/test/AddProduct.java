package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.ProductC;
import org.junit.Assert;

public class AddProduct {
    @Given("list of Categories appeared")
    public void list_of_categories_appeared() {
        ProductC.displayProductsByCategory ( );
    }

    @When("Admin entered {string}{string}{string}{string}")
    public void admin_entered(String category, String name, String quantity, String price) {
        ProductC.addProduct ( category, name, quantity, price );
    }

    @Then("add Product to products list")
    public void add_to_products_list() {
        Assert.assertTrue ( ProductC.isProductAddSuccessfully () );
    }

    @Then("wrong input message appear and return to add product")
    public void wrong_input_message_appear_and_return_to_add_product() {
        Assert.assertFalse ( ProductC.isProductAddSuccessfully ( ) );
    }
}
