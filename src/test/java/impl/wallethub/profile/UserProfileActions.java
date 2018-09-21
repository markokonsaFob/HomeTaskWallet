package impl.wallethub.profile;

import helpers.Constants;
import helpers.TestDataManager;
import io.cify.framework.core.Device;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;

/**
 * Created by FOB Solutions
 */
public class UserProfileActions {

    private UserProfilePage page;
    private Device device;
    private WebDriverWait wait;

    public UserProfileActions(Device device) {
        page = new UserProfilePage(device);
        this.device = device;
        wait = new WebDriverWait(device.getDriver(), 15);
    }

    /**
     * Verifies last review
     *
     * @return
     */
    public boolean isLastReviewCorrect() {
        WebElement review = page.getReviews().get(0);
        String content = TestDataManager.getTestData(Constants.SAVED_REVIEW);

        return page.getCompContent(review).getText().equals(content);
    }

    /**
     * Removes all review elements from list
     */
    public void removeAllReviews() {

        wait.until(ExpectedConditions.visibilityOf(page.getUsernameElement()));

        int timeOutInSeconds = 30;
        boolean deleted = false;
        LocalDateTime startTime = LocalDateTime.now();
        while (!deleted && LocalDateTime.now().isBefore(startTime.plusSeconds(timeOutInSeconds))) {
            page = new UserProfilePage(device);
            if (page.getReviews().size() > 0) {
                for (WebElement review : page.getReviews()) {
                    page.removeElement(review).click();
                    device.getDriver().switchTo().alert().accept();
                    wait.until(ExpectedConditions.invisibilityOf(review));
                }
            } else {
                deleted = true;
            }
        }
    }

}
