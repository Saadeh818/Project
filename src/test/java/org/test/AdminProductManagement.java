package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Admin;
import org.main.ProductC;
import org.junit.Assert;

public class AdminProductManagement {

    @When("admin in product management entered {string}")
    public void adminInProductManagementEntered(String arg0) {
        ProductC.productManager ( arg0 );
    }
    @Then("add product")
    public void add_product() {
        Assert.assertTrue(ProductC.readyToAdd);
    }

    @Then("delete product")
    public void delete_product() {
        Assert.assertTrue(ProductC.readyToDelete);
    }

    @Then("update product")
    public void update_product() {
        Assert.assertTrue(ProductC.readyToUpdate);
    }

    @Then("go to dashboard")
    public void go_to_dashboard() {
        Assert.assertTrue ( Admin.isAdminDashboardFlag() );
    }
    @Then("show wrong input message")
    public void showWrongInputMessage() {
        Assert.assertTrue(ProductC.wrongInputFlag);
    }

    @Then("reload product manager")
    public void reload_product_manager() {
    }


}
