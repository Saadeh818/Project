package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UpdateProduct {
    ProductC product=new ProductC();
    @When("user choose category update{string}")
    public void user_choose_category_update_category(String string) {
        product.setCategory(string);
    }

    @When("choose product id update {string}")
    public void choose_product_id_update(String string) {
        product.productId= Integer.parseInt(string);
    }

    @When("get new fields {string}{string}{string}{string}")
    public void get_new_fields(String category, String name, String quantity, String price) {
        product.updateValues(product.productId, category,name,quantity,price);
    }

    @Then("go update product")
    public void update_product() {
        Assert.assertTrue(product.updateProductSuccess);
    }
}
