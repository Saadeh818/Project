package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public
class DeleteAccount {
    @When ("user choose {string}")
    public void user_choose(String string) {
        // Write code here that turns the phrase above into concrete actions
        Installer.deleteInstallerAccount ( Integer.parseInt ( string ) );
        Customer.deleteCustomerAccount ( Integer.parseInt ( string ) );
    }

    @Then ("delete account")
    public void delete_account() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue( Users.userDeleted);
    }

    @Then("fail to delete")
    public void fail_to_delete() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse ( Users.userDeleted );
    }

}
