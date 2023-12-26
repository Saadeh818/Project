package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class SignUp {


        @Given("^you are in signup page$")
        public void navigateToSignUpPage() {
            // Implementation to navigate to the signup page
            System.out.println("Navigate to signup page");
        }

        @When("you write the {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and {string}")
        public void fillSignUpForm(String id, String name, String phoneNumber, String address, String city, String street, String email, String password, String userType) {
            // Implementation to fill out the signup form with provided details
            System.out.println("Fill out the signup form with:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Phone Number: " + phoneNumber);
            System.out.println("Address: " + address);
            System.out.println("City: " + city);
            System.out.println("Street: " + street);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("User Type: " + userType);
        }

        @Then("^you should show please fill all informations")
        public void showPleaseFillAllInformations() {
            // Implementation to verify that the correct message is displayed
            System.out.println("Verify 'Please fill all information' message is displayed");
        }



        @Then("^You should Show please enter more than five character$")
        public void showPleaseEnterMoreThanFiveCharacter() {
            // Implementation to verify that the correct message is displayed
            System.out.println("Verify 'Please enter more than five characters' message is displayed");
        }
    @Then("You should Show please enter another id")
    public void youShouldShowPleaseEnterAnotherId() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Verify 'Please enter another ID' message is displayed");
    }
        @Then("^The Customer Added Successfully")
        public void showCustomerAddedSuccessfully() {
            // Implementation to verify that the correct message is displayed
            System.out.println("Verify 'The Customer Added Successfully' message is displayed");
        }
    @When("you write the {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string} and {string}")
    public void youWriteTheAndAnd(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9) {
        // Write code here that turns the phrase above into concrete actions

    }
}

