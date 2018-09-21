package impl.wallethub.review;

import helpers.Constants;
import helpers.TestDataManager;
import io.cify.framework.core.Device;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.StringJoiner;

/**
 * Created by FOB Solutions
 */
public class ReviewActions {

    private ReviewPage page;
    private Device device;
    private WebDriverWait wait;

    public ReviewActions(Device device) {
        page = new ReviewPage(device);
        this.device = device;
        wait = new WebDriverWait(device.getDriver(), 15);
    }

    /**
     * Verifies if review page is visible
     *
     * @return
     */
    public boolean isReviewPageDisplayed() {
        return page.getReviewContent().isDisplayed() &&
                page.getDropdown().isDisplayed() &&
                page.getOverallRaiting().isDisplayed();
    }

    /**
     * Selects review type
     *
     * @param type
     */
    public void selectType(String type) {
        page.getDropdown().click();
        wait.until(ExpectedConditions.elementToBeClickable(page.getDropdownElement(type)));
        page.getDropdownElement(type).click();
    }

    /**
     * Sets raiting to given value
     *
     * @param stars
     */
    public void setRating(int stars) {
        wait.until(ExpectedConditions.elementToBeClickable(page.getStar(stars)));
        page.getStar(stars).click();
    }

    /**
     * Enters generated string to review field
     */
    public void enterRandomReview() {
        StringJoiner reviewString = new StringJoiner(" ");
        Collections.nCopies(5, 1)
                .forEach(i -> reviewString.add(generateString()));
        page.getReviewContent().sendKeys(reviewString.toString());
        TestDataManager.addTestData(Constants.SAVED_REVIEW, reviewString.toString());
    }

    /**
     * Submits review
     */
    public void submitReview() {
        page.getSubmitButton().click();
    }

    private String generateString() {
        return new RandomString(40).nextString();
    }

}
