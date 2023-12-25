package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public
class AddInstallationRequest {
    ProductC productC = new ProductC (  );
    @When ("customer choos the product successfully")
    public void customer_choose_the_product_successfully() {
        Customer.addInstallationRequest(3 , 5 , "frommain@installer.com,ahmad010101" );
    }

    @Then ("Check product")
    public void check_product() {
        assertTrue(ProductC.checkIfProductExists ( 3 ));
    }

    @Then("add installation request")
    public void add_installation_request() {
        assertTrue ( Customer.installationRequestAdded );
    }

    @When("customer choos the product wrong")
    public void customer_choos_the_product_wrong() {
        Customer.addInstallationRequest(3 , 5 , "frommain@installer.com,ahmad010101" );
    }

    @Then("Check product Fail")
    public void check_product_fail() {
        assertFalse(ProductC.checkIfProductExists ( 3 ));
    }

    @Then("add installation request Fail")
    public void add_installation_request_fail() {
        assertFalse ( Customer.installationRequestAdded );
    }
}
