package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Constants;
import helpers.TestDataManager;
import impl.ActionsImpl;
import io.cify.framework.core.Device;
import io.cify.framework.core.DeviceManager;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NotFoundException;

/**
 * Created by FOB Solutions
 */
public class WallethubSteps {

    @Given("^user opens wallethub company page$")
    public void userOpensWallethubCompanyPage() throws Throwable {
        Device device = DeviceManager.getInstance().getActiveDevice();
        device.openBrowser(TestDataManager.getTestData(Constants.WALLETHUB_REVIEW_COMP));
    }

    @And("^user logs in with (.+) credentials$")
    public void userLogsInWithVALIDCredentials(String account) throws Throwable {

        ActionsImpl.getNavigationBarActions().clickLogin();

        switch (account) {
            case "VALID":
                String username = TestDataManager.getTestData(Constants.WALLETHUB_USERNAME);
                String password = TestDataManager.getTestData(Constants.WALLETHUB_PASSWORD);
                ActionsImpl.getWalletHubLoginActions().login(username, password);
                break;
            default:
                throw new NotFoundException("Cannot found account for " + account);
        }
    }

    @Then("^user should be logged in$")
    public void userShouldBeLoggedIn() throws Throwable {
        if (!ActionsImpl.getNavigationBarActions().isLoggedIn()) {
            throw new InvalidElementStateException("User should be logged in!");
        }
    }

    @When("^user hovers over (\\d+) star raiting$")
    public void userHoversOverStarRaiting(int stars) throws Throwable {
        ActionsImpl.getWalletHubCompanyProfileActions().hoverToPlaceHolderStars();
        ActionsImpl.getWalletHubCompanyProfileActions().hoverOverRaiting(1);
        ActionsImpl.getWalletHubCompanyProfileActions().hoverOverRaiting(stars);
    }

    @Then("^(\\d+) stars should be filled$")
    public void starsShouldBeFilled(int stars) throws Throwable {
        if (ActionsImpl.getWalletHubCompanyProfileActions().getHoveredStars().size() != stars) {
            throw new InvalidElementStateException("There should be " + stars + " stars filled");
        }
    }

    @When("^user clicks on the (\\d+) star$")
    public void userClicksOnTheStar(int stars) throws Throwable {
        TestDataManager.addTestData(Constants.SAVED_RATING, String.valueOf(stars));
        ActionsImpl.getWalletHubCompanyProfileActions().clickOnRaiting(stars);
    }

    @Then("^user should be on write review page$")
    public void userShouldBeOnWriteReviewPage() throws Throwable {
        if (!ActionsImpl.getReviewActions().isReviewPageDisplayed()) {
            throw new Exception("Review page should be visible!");
        }
    }

    @When("^user selects policy type to be \"([^\"]*)\"$")
    public void userSelectsPolicyTypeToBe(String type) throws Throwable {
        ActionsImpl.getReviewActions().selectType(type);
    }

    @And("^user sets rating to be (\\d+) stars$")
    public void userSetsRatingToBeStars(int stars) throws Throwable {
        TestDataManager.addTestData(Constants.SAVED_RATING, String.valueOf(stars));
        ActionsImpl.getReviewActions().setRating(stars);
    }

    @And("^user enters generated review$")
    public void userEntersGeneratedReview() throws Throwable {
        ActionsImpl.getReviewActions().enterRandomReview();
    }

    @And("^user presses submit button$")
    public void userPressesSubmitButton() throws Throwable {
        ActionsImpl.getReviewActions().submitReview();
    }

    @Then("^review confirmation page should be visible$")
    public void reviewConfirmationPageShouldBeVisible() throws Throwable {
        if (!ActionsImpl.getWalletHubConfirmationActions().isConfirmationVisible()){
            throw new Exception("Confirmation page is not visible!");
        }

        if (!ActionsImpl.getWalletHubConfirmationActions().isConfirmationWithCorrectData()) {
            throw new Exception("Confirmation page information is not correct!");
        }
    }

    @When("^user navigates to user profile reviews section$")
    public void userNavigatesToUserProfileReviewsSection() throws Throwable {
        ActionsImpl.getNavigationBarActions().navigateToProfileReviews();
    }

    @Then("^added review should be visible$")
    public void addedReviewShouldBeVisible() throws Throwable {
        if (!ActionsImpl.getWalletHubUserProfileActions().isLastReviewCorrect()) {
            throw new Exception("Added review should be visible!");
        }
    }

    @After("@removeReview")
    public void deleteReview() {
        try {
            if (ActionsImpl.getNavigationBarActions().isLoggedIn()) {
                ActionsImpl.getNavigationBarActions().navigateToProfileReviews();
                ActionsImpl.getWalletHubUserProfileActions().removeAllReviews();
            }
        } catch (Exception ignore) {

        }
    }
}
