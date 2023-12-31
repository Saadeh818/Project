package org.test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.main.Customer;
import org.main.Installer;
import org.main.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public
class DeleteAccount {
    @When ("user choose {string}")
    public void user_choose(String string) {
        Customer customer = new Customer ();
        Installer installer = new Installer ();
        // Write code here that turns the phrase above into concrete actions
        installer.deleteInstallerAccount ( Integer.parseInt ( string ) );
        customer.deleteCustomerAccount ( Integer.parseInt ( string ) );
    }

    @Then ("delete account")
    public void delete_account() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue ( Users.isUserDeleted () );
    }

    @Then("fail to delete")
    public void fail_to_delete() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse ( Users.isUserDeleted () );
    }

}
