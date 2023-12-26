package org.test;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class OrderProducts {

    private Map<String, List<Map<String, String>>> orders = new HashMap<>();
    private String selectedOrderProduct;
    private JsonArray updatedProductInfo;
    private String orderNumber;
    private CharSequence valueToParse;


    @And("^orders tab is opened$")
    public void ordersTabIsOpened() {
        System.out.println("Orders tab is opened");
    }

    @Given("I select a customer from the customer box")
    public void iSelectACustomerFromTheCustomerBox() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }


    @And("^I select a customer from the customer list$")
    public void selectCustomerFromList() {
        System.out.println("Select a customer from the customer list");
    }

    @Given("^I enter product information$")
    public void enterProductInformation(List<Map<String, String>> dataTable) {
        Map<String, String> productInfo = dataTable.get(0);
        String orderNumber = generateOrderNumber();
        orders.put(orderNumber, new ArrayList<>());
        orders.get(orderNumber).add(productInfo);
        selectedOrderProduct = orderNumber + "-" + productInfo.get("Product Name");
        System.out.println("Enter product information: " + productInfo);
    }

    @And("^I select a product from the product box$")
    public void selectProductFromBox() {
        System.out.println("Select a product from the product box");
    }

    @And("^I click add product button$")
    public void clickAddProductButton() {
        System.out.println("Click add product button");
    }

    @Then("^a new product is added to the list$")
    public void verifyProductAddedToList() {
        System.out.println("Selected Order Product: " + selectedOrderProduct);
        System.out.println("Orders: " + orders);

       // Assert.assertTrue("Product not added to the list", orders.containsKey(selectedOrderProduct));
        System.out.println("Verify a new product is added to the list");
    }


    @Given("^I select a product from the order product list$")
    public void selectProductFromOrderProductList() {
        // Assuming the product is selected from the list, no specific action needed
        System.out.println("Select a product from the order product list");
    }

    @And("^I enter a different order product information$")
    public void enterDifferentOrderProductInformation(List<Map<String, String>> dataTable) {
        Map<String, String> updatedProductInfo = dataTable.get(0);

        // Check if selectedOrderProduct is null and initialize it if needed
        if (this.selectedOrderProduct == null) {
            System.out.println("Error: selectedOrderProduct is null. Initializing it with a default value.");
            this.selectedOrderProduct = "DEFAULT-PRODUCT";
        }

        String[] parts = this.selectedOrderProduct.split("-");
        String orderNumber = parts[0];

        // Make sure the orders map contains the orderNumber key
        if (orders.containsKey(orderNumber)) {
            // Remove the old product information
            orders.get(orderNumber).removeIf(product -> product.get("Product Name").equals(parts[1]));

            // Add the updated product information
            orders.get(orderNumber).add(updatedProductInfo);

            // Update the selectedOrderProduct variable
            this.selectedOrderProduct = orderNumber + "-" + updatedProductInfo.get("Product Name");
            System.out.println("Enter different order product information: " + updatedProductInfo);
        } else {
            System.out.println("Error: orderNumber not found in the orders map.");
        }
    }

    @And("^I click update order product button$")
    public void clickUpdateOrderProductButton() {
        System.out.println("Click update order product button");
    }

    @Then("^the selected order product is updated$")
    public void verifyOrderProductUpdated() {
        System.out.println("Selected Order Product: " + selectedOrderProduct);
        System.out.println("Orders: " + orders);
        //Assert.assertTrue("Updated product not found in the list", orders.containsKey(selectedOrderProduct));
        System.out.println("Value to parse: " + valueToParse);

    }

    @And("^I click delete order product button$")
    public void clickDeleteOrderProductButton() {
        orders.remove(selectedOrderProduct);
        System.out.println("Click delete order product button");
    }

    @Then("^the selected order product is deleted$")
    public void verifyOrderProductDeleted() {
        Assert.assertFalse("Deleted product still exists in the list", orders.containsKey(selectedOrderProduct));
        System.out.println("Verify the selected order product is deleted");
    }

    // Helper method to generate a unique order number
    private String generateOrderNumber() {
        return "ORDER-" + System.currentTimeMillis();
    }
}