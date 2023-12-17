package org.example;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteProduct {
    ProductC product = new ProductC();

    @Given("category list appear")
    public void category_list_appear() {
        ProductC.listProductFlag=true;
    }

    @When("user choose category {string}")
    public void user_choose_to_delete_from(String string) {
        product.setCategory(string);
    }

    @When("choose product id {string}")
    public void choose_product_id(String string) {
        product.selectIdToDelete(string,product.category);
    }

    @Then("print wrong selection message")
    public void print_wrong_selection_message() {
        Assert.assertFalse ( ProductC.productDeletedSuccessfully );
    }

    @Then("redirect to delete product screen")
    public void redirect_to_delete_product_screen() {
        Assert.assertFalse ( ProductC.productDeletedSuccessfully );
    }

    @Then("delete products")
    public void deleteProducts() {
        Assert.assertTrue ( ProductC.productDeletedSuccessfully );
    }
}
