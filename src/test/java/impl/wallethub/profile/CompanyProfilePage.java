package impl.wallethub.profile;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by FOB Solutions
 */
class CompanyProfilePage extends PageObjects {

    @FindBy(className = "wh-rating-choices-holder")
    private WebElement raitingChoices;

    private By mainInfoLocator = By.className("maininfo");
    private By reviewInfoLocator = By.className("reviewinfo");
    private By raitingLocator = By.className("wh-rating");

    private By hoverLocator = By.className("hover");

    private Device device;

    CompanyProfilePage(Device device) {
        super(device);
        this.device = device;
    }

    /**
     * Returns the choice for specific number
     * @param number
     * @return
     */
    WebElement getRaitingChoice(int number) {
        List<WebElement> choices = raitingChoices.findElements(By.tagName("a"));

        for (WebElement choice : choices) {
            if (choice.getText().equals(String.valueOf(number))) {
                return choice;
            }
        }
        throw new NotFoundException("Cannot found choice for number: " + number);
    }

    List<WebElement> getHoveredStars() {
        return raitingChoices.findElements(hoverLocator);
    }

    /**
     * Returns WebElement which is the placeholder for stars
     * @return
     */
    WebElement getPlaceholderStars() {
        return device.getDriver().findElement(mainInfoLocator).findElement(reviewInfoLocator).findElement(raitingLocator);
    }
}
