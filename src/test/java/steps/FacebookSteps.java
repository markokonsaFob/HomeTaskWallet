package steps;

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
public class FacebookSteps {

    @Given("^user opens Facebook home page$")
    public void userOpensFacebookHomePage() throws Throwable {
        Device device = DeviceManager.getInstance().getActiveDevice();
        device.openBrowser("https://www.facebook.com/login");
    }

    @Then("^Facebook home page should be visible$")
    public void facebookHomePageShouldBeVisible() throws Throwable {
        if (!ActionsImpl.getFacebookLoginActions().isFacebookLoginDisplayed()) {
            throw new NotFoundException("Facebook login form is not displayed");
        }
    }

    @When("^user enters (.+) credentials into the login field$")
    public void userEntersVALIDCredentialsIntoTheLoginField(String accountType) throws Throwable {

        String username;
        String password;

        switch (accountType) {
            case "VALID":
                username = TestDataManager.getTestData(Constants.FACEBOOK_USERNAME);
                password = TestDataManager.getTestData(Constants.FACEBOOK_PASSWORD);
                break;
            default:
                throw new NotFoundException("Cannot found account for: " + accountType);
        }
        ActionsImpl.getFacebookLoginActions().enterCredentials(username, password);
    }

    @And("^user clicks submit button on Facebook login$")
    public void userClicksSubmitButtonOnFacebookLogin() throws Throwable {
        ActionsImpl.getFacebookLoginActions().submitLogin();
    }

    @Then("^user should be logged in to Facebook$")
    public void userShouldBeLoggedInToFacebook() throws Throwable {
        if (!ActionsImpl.getFacebookHomeActions().isLoggedIn()) {
            throw new InvalidElementStateException("User should be logged in!");
        }
    }

    @When("^user posts a status update with message \"([^\"]*)\" on Facebook$")
    public void userPostsAStatusUpdateWithMessageOnFacebook(String message) throws Throwable {
        ActionsImpl.getFacebookHomeActions().enterStatusUpdate(message);
        ActionsImpl.getFacebookHomeActions().submitStatusUpdate();
    }

    @When("^user navigates to profile view on Facebook$")
    public void userNavigatesToProfileViewOnFacebook() throws Throwable {
        ActionsImpl.getFacebookHomeActions().clickOnUsername();
    }

    @Then("^status update posted \"([^\"]*)\" with message \"([^\"]*)\" should be visible$")
    public void statusUpdatePostedWithMessageShouldBeVisible(String when, String message) throws Throwable {
        if (!ActionsImpl.getFacebookHomeActions().isLastPostContaining(when, message)) {
            throw new NotFoundException("Cannot find post with message: " + message);
        }
    }
}
