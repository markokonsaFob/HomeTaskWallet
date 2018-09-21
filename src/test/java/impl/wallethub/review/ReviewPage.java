package impl.wallethub.review;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by FOB Solutions
 */
class ReviewPage extends PageObjects {

    @FindBy(className = "dropdown-list-new")
    private WebElement dropdown;

    @FindBy(id = "review-content")
    private WebElement reviewContent;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(id = "overallRating")
    private WebElement overallRaiting;


    private Device device;

    ReviewPage(Device device) {
        super(device);
        this.device = device;
    }

    WebElement getDropdown() {
        return dropdown;
    }

    WebElement getReviewContent() {
        return reviewContent;
    }

    WebElement getSubmitButton() {
        return submitButton;
    }

    WebElement getOverallRaiting() {
        return overallRaiting;
    }

    /**
     * Gets element with given name
     * @param name
     * @return
     */
    WebElement getDropdownElement(String name) {
       return device.getDriver().findElement(By.cssSelector("a[data-target='" + name + "']"));
    }

    /**
     * Returns star with given number value
     * @param number
     * @return
     */
    WebElement getStar(int number) {
        return overallRaiting.findElements(By.tagName("a")).get(number - 1);
    }
}
