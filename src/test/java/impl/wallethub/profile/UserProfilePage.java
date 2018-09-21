package impl.wallethub.profile;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by FOB Solutions
 */
class UserProfilePage extends PageObjects {

    @FindBy(className = "reviews")
    private WebElement contentReview;

    @FindBy(className = "topsection")
    private WebElement profileTopSection;

    private By reviewedCompContent = By.tagName("p");

    private By usernameLocator = By.className("username");

    private By remove = By.className("remove");

    UserProfilePage(Device device) {
        super(device);
    }

    /**
     * Returns reviews that are given by the user
     * @return
     */
    List<WebElement> getReviews() {
        return contentReview.findElements(By.tagName("div"));
    }

    /**
     * Retrun company content element for given review item
     * @param element
     * @return
     */
    WebElement getCompContent(WebElement element) {
        return element.findElement(reviewedCompContent);
    }

    /**
     * Returns user name element
     * @return
     */
    public WebElement getUsernameElement() {
        return profileTopSection.findElement(usernameLocator);
    }

    /**
     * Remove link from review
     * @param element
     * @return
     */
    public WebElement removeElement(WebElement element) {
        return element.findElement(remove);
    }
}
