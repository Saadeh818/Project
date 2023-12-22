package org.example;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChoosingUserToModify {

    @And("admin entered user id {string}")
    public void admin_entered_user_id(String string) {
        Users.userToModifyID(string);
    }

    @Then("return to choose user to modify")
    public void return_to_choose_user_to_modify() {
        Assert.assertFalse ( Users.userIsFound );
    }

    @Then("modify options appeared")
    public void modifyOptionsAppearedUserID() {
        Assert.assertTrue ( Users.userIsFound);
    }

    @Given ( "list of users appears")
    public
    void listOfUsersAppears ( ) {
    }

    @When ( "user want to modify {string}")
    public
    void userWantToModifyInstallerOrCustomer (String string ) {
        Users.setTypeToModify(string);
    }
}
