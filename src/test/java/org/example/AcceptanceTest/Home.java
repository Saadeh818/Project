package org.example.AcceptanceTest;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.SplittableRandom;

public class Home {
    MainScreen mainScreen= new MainScreen();
    @Given("user is on home page")
    public void userIsOnHomePage() {
       MainScreen.displayPage("home-page");
    }
    @When("the user enters {string}")
    public void the_user_enters(String string) {
          MainScreen.setUserInput(string);
          if (string.equals(" '")){ MainScreen.currentPage = "home-page";
          return;}
        switch (MainScreen.userInput){
            case "1":
                MainScreen.currentPage = "admin-login";
                break;
            case "2":
                MainScreen.currentPage = "customer-login";
                break;
            case "3":
                MainScreen.currentPage = "installer-login";
                break;
            case "4":
            case " '":
                MainScreen.currentPage = "signUp-page";
                break;
            default:
                MainScreen.currentPage = "home-page";
        }
    }

    @Then("go to the admin login page")
    public void go_to_the_admin_login_page() {
        if ("admin-login".equals(MainScreen.currentPage)) {
            Assert.assertEquals("admin-login", MainScreen.currentPage);
        }
    }

    @Then("go to the customer login page")
    public void go_to_the_customer_login_page() {
        if ("customer-login".equals(MainScreen.currentPage))
            Assert.assertEquals("customer-login", MainScreen.currentPage);
    }

    @Then("go to the installer login page")
    public void go_to_the_installer_login_page() {
        if ("installer-login".equals(MainScreen.currentPage))
            Assert.assertEquals("installer-login", MainScreen.currentPage);
    }

    @Then("go to the SignUp page")
    public void go_to_the_sign_up_page() {
        if ("signUp-page".equals(MainScreen.currentPage))
            Assert.assertEquals("signUp-page", MainScreen.currentPage);
    }

    @Then("display a wrong choice and go to the home page")
    public void display_a_wrong_choice_and_go_to_the_home_page() {
        if ("home-page".equals(MainScreen.currentPage))
            Assert.assertEquals("home-page", MainScreen.currentPage);
    }
}
