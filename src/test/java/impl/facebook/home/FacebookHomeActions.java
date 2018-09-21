package impl.facebook.home;

import io.cify.framework.core.Device;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

/**
 * Created by FOB Solutions
 */
public class FacebookHomeActions {

    private FacebookHomePage page;
    private Device device;

    public FacebookHomeActions(Device device) {
        this.page = new FacebookHomePage(device);
        this.device = device;
    }

    /**
     * Gets username from sidemenu
     *
     * @return
     */
    public String getUsername() {
        return page.getUserNavigation().getText();
    }

    public boolean isLoggedIn() {
        return page.getUserNavigation().isDisplayed();
    }

    /**
     * Click on username
     * Navigates to the user profile view
     */
    public void clickOnUsername() {
        device.getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
        page.getUserNavigation().click();
    }

    /**
     * Gets active element and enters message to it
     *
     * @param message
     */
    public void enterStatusUpdate(String message) {
        page.getShareUpdateBox().click();
        device.getDriver().switchTo().activeElement().sendKeys(message);
    }

    /**
     * Submits status update
     */
    public void submitStatusUpdate() {
        page.getSubmitStatusUpdateButton().click();
    }

    /**
     * Verifies if last post contains correct message
     *
     * @param message
     * @param timestamp
     * @return
     */
    public boolean isLastPostContaining(String timestamp, String message) {
        int timeOutInSeconds = 15;
        int lastPost = 0;
        boolean isFound = false;

        WebElement lastPostElement;
        WebElement timestampElement;
        LocalDateTime startTime = LocalDateTime.now();
        while (!isFound && LocalDateTime.now().isBefore(startTime.plusSeconds(timeOutInSeconds))) {
            lastPostElement = page.getPosts().get(lastPost);
            timestampElement = lastPostElement.findElement(page.getTimestampContentLocator());
            isFound = timestampElement.getText().toLowerCase().equals(timestamp.toLowerCase());
        }

        String content = page.getPosts().get(lastPost).getText();
        return content.contains(message);
    }

}
