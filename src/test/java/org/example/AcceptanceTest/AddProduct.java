package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddProduct {
    ProductC product=new ProductC();
    @Given("list of Categories appeared")
    public void list_of_categories_appeared() {
        product.productList();
    }

    @When("Admin entered {string}{string}{string}{string}")
    public void admin_entered(String category, String name, String quantity, String price) {
        product.addProduct(category,name,quantity,price);
    }

    @Then("add Product to products list")
    public void add_to_products_list() {
        Assert.assertTrue(product.productAddSuccessfully);
    }

    @Then("wrong input message appear and return to add product")
    public void wrong_input_message_appear_and_return_to_add_product() {
        Assert.assertFalse(product.productAddSuccessfully);
    }
}
