package impl.wallethub.profile;

import io.cify.framework.core.Device;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by FOB Solutions
 */
public class CompanyProfileActions {

    private CompanyProfilePage page;
    private Device device;

    public CompanyProfileActions(Device device) {
        page = new CompanyProfilePage(device);
        this.device = device;
    }

    /**
     * Clicks over placeholder stars element
     * <p>
     * This will open start for hovering
     */
    public void hoverToPlaceHolderStars() {
        Actions action = new Actions(device.getDriver());
        action.moveToElement(page.getPlaceholderStars()).build().perform();
    }

    /**
     * Hover over raiting
     *
     * @param stars
     */
    public void hoverOverRaiting(int stars) {
        WebElement starElem = page.getRaitingChoice(stars);

        Actions action = new Actions(device.getDriver());
        action.moveToElement(starElem).build().perform();
    }

    /**
     * Gets stars that are hovered
     * @return
     */
    public List<WebElement> getHoveredStars() {
        return page.getHoveredStars();
    }

    /**
     * Clicks on star
     * @param stars
     */
    public void clickOnRaiting(int stars) {
        page.getRaitingChoice(stars).click();
    }

}
