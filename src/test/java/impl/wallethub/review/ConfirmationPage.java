package impl.wallethub.review;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by FOB Solutions
 */
public class ConfirmationPage extends PageObjects {

    @FindBy(id = "reviewform")
    private WebElement reviewForm;

    ConfirmationPage(Device device) {
        super(device);
    }

    /**
     * Gets content of the review
     * @return
     */
    WebElement getReviewContent() {
        return reviewForm.findElement(By.className("content")).findElement(By.tagName("p"));
    }

    /**
     * Returns only filled stars
     * @return
     */
    public List<WebElement> getRatedStars() {
        return reviewForm.findElement(By.className("raiting")).findElements(By.className("bf-icon-star"));
    }
}
