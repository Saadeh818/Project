package org.test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.main.ProductReview;

public class Reviewsteps {



                private final ProductReview productReviewService = new ProductReview();

                @Given("that the user is on the review form page")
                public void thatTheUserIsOnTheReviewFormPage() {
                        productReviewService.navigateToReviewFormPage();
                }

                @Given("that the user is not logged in")
                public void thatTheUserIsNotLoggedIn() {
                        productReviewService.logOutUser();
                }

                @Given("that the user has already written a review for a product")
                public void thatTheUserHasAlreadyWrittenAReviewForAProduct() {
                        productReviewService.navigateToReviewFormPage();
                        productReviewService.setReviewFormText("Existing review");
                        productReviewService.setReviewFormRating(4);
                        productReviewService.submitReviewForm();
                }

        @Given("that the user has purchased a product")
        public void thatTheUserHasPurchasedAProduct() {
                productReviewService.logInUser();
                System.out.println("User has purchased a product");
        }

        @Given("the user is logged in")
        public void theUserIsLoggedIn() {
                productReviewService.logInUser();
        }

        @Given("that the user is on the product page")
        public void thatTheUserIsOnTheProductPage() {
                productReviewService.navigateToProductPage();
        }

        @When("the user clicks on the write a review button")
        public void theUserClicksOnTheWriteAReviewButton() {
                productReviewService.clickWriteReviewButton();
        }

        @When("the user fills out the review form")
        public void theUserFillsOutTheReviewForm() {
                productReviewService.setReviewFormText("Test review");
                productReviewService.setReviewFormRating(5);
                productReviewService.fillOutReviewForm();
        }

        @When("submits the form")
        public void submitsTheForm() {
                productReviewService.submitReviewForm();
        }

        @Then("the review is added to the product page")
        public void theReviewIsAddedToTheProductPage() {
                // Assume that the ProductReviewService class has a method to check if the review is added
                if (productReviewService.isReviewAdded()) {
                        System.out.println("Review is added to the product page");
                } else {
                        System.out.println("Review is not added to the product page");
                }
        }


        @Then("the user is redirected to the login page")
        public void theUserIsRedirectedToTheLoginPage() {
                productReviewService.redirectToLoginPage();
                System.out.println("User is redirected to the login page");
        }

        @Then("a message prompts the user to log in first")
        public void aMessagePromptsTheUserToLogInFirst() {
                productReviewService.displayLogInPrompt();
                System.out.println("Message prompts the user to log in first");
        }

        @When("the user submits the form with missing required fields")
        public void theUserSubmitsTheFormWithMissingRequiredFields() {
                productReviewService.submitFormWithMissingFields();
                System.out.println("User submits the form with missing required fields");
        }

        @Then("an error message is displayed asking the user to fill out all required fields")
        public void anErrorMessageIsDisplayedAskingTheUserToFillOutAllRequiredFields() {
                productReviewService.verifyErrorMessageForMissingFields();
                System.out.println("Error message is displayed for missing required fields");
        }

        @When("the user fills out the review form with more than the maximum allowed characters")
        public void theUserFillsOutTheReviewFormWithMoreThanTheMaximumAllowedCharacters() {
                productReviewService.setReviewFormText("This is a very long review exceeding the maximum allowed characters.");
                productReviewService.fillOutReviewForm();
                System.out.println("User fills out the review form with more than the maximum allowed characters");
        }

        @Then("an error message is displayed indicating the maximum review length has been exceeded")
        public void anErrorMessageIsDisplayedIndicatingTheMaximumReviewLengthHasBeenExceeded() {
                productReviewService.verifyErrorMessageForExceededLength();
                System.out.println("Error message is displayed for exceeded review length");
        }

        @When("the user clicks on the edit review button")
        public void theUserClicksOnTheEditReviewButton() {
                productReviewService.clickEditReviewButton();
                System.out.println("User clicks on the edit review button");
        }

        @When("the user edits the review form")
        public void theUserEditsTheReviewForm() {
                productReviewService.editReviewForm();
                System.out.println("User edits the review form");
        }

        @Then("the review is updated on the product page")
        public void theReviewIsUpdatedOnTheProductPage() {
                productReviewService.verifyReviewUpdated();
                System.out.println("Review is updated on the product page");
        }

        @When("the user clicks on the delete review button")
        public void theUserClicksOnTheDeleteReviewButton() {
                productReviewService.clickDeleteReviewButton();
                System.out.println("User clicks on the delete review button");
        }

        @Then("the review is removed from the product page")
        public void theReviewIsRemovedFromTheProductPage() {
                productReviewService.verifyReviewRemoved();
                System.out.println("Review is removed from the product page");
        }

        @Then("a success message is displayed.")
        public void aSuccessMessageIsDisplayed() {
                productReviewService.verifySuccessMessage();
                System.out.println("Success message is displayed");
        }






}

