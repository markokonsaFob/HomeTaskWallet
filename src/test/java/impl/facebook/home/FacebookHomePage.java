package impl.facebook.home;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by FOB Solutions
 */
class FacebookHomePage extends PageObjects {

    @FindBy(id = "userNav")
    private WebElement userNavigation;

    @FindBy(css = "div[data-testid='react-composer-root']")
    private WebElement shareUpdateBox;

    @FindBy(css = "button[data-testid='react-composer-post-button']")
    private WebElement submitStatusUpdateButton;

    @FindBy(className = "userContentWrapper")
    private List<WebElement> posts;

    private By timestampContent = By.className("timestampContent");

    FacebookHomePage(Device device) {
        super(device);
    }

    WebElement getUserNavigation() {
        return userNavigation;
    }

    WebElement getShareUpdateBox() {
        return shareUpdateBox.findElement(By.className("clearfix"));
    }

    WebElement getSubmitStatusUpdateButton() {
        return submitStatusUpdateButton;
    }

    List<WebElement> getPosts() {
        return posts;
    }

    By getTimestampContentLocator() {
        return timestampContent;
    }
}
