package org.example.AcceptanceTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteAccount {


        private AccountDeletion accountDeletion;
        private String resultMessage;

        @Given("the user is an admin")
        public void givenUserIsAdmin() {
            // Assume user is an admin for the test
            accountDeletion = new AccountDeletion(true);
        }

        @When("user enters the right password {string}")
        public void whenUserEntersRightPassword(String password) {
            if (accountDeletion == null) {
                // Initialize the accountDeletion object if it's null
                accountDeletion = new AccountDeletion(false);
            }
            resultMessage = accountDeletion.deleteAccount(password);
        }

        @When("user enters the wrong password {string}")
        public void whenUserEntersWrongPassword(String password) {
            if (accountDeletion == null) {
                // Initialize the accountDeletion object if it's null
                accountDeletion = new AccountDeletion(false);
            }
            resultMessage = accountDeletion.deleteAccount(password);
        }
    @When("admin deletes the user account")
    public void adminDeletesTheUserAccount() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
        @When("admin enters the admin password {string}")
        public void whenAdminEntersPassword(String password) {
            if (accountDeletion == null) {
                // Initialize the accountDeletion object if it's null
                accountDeletion = new AccountDeletion(true);
            }
            resultMessage = accountDeletion.deleteAccount(password);
        }

        @Then("the account is deleted successfully")
        public void thenAccountDeletedSuccessfully() {
            Assert.assertEquals("Account deleted successfully", resultMessage);
        }

        @Then("a wrong password message appears")
        public void thenWrongPasswordMessageAppears() {
            Assert.assertEquals("Wrong password. Account deletion failed.", resultMessage);
        }
    }

