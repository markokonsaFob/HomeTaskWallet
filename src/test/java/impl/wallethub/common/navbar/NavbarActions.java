package impl.wallethub.common.navbar;

import io.cify.framework.core.Device;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by FOB Solutions
 */
public class NavbarActions {

    private NavigationBarPage page;
    private Device device;

    public NavbarActions(Device device) {
        page = new NavigationBarPage(device);
        this.device = device;
    }

    /**
     * Click login button
     */
    public void clickLogin() {
        page.getLoginButton().click();
    }

    /**
     * Get logged in user profile
     *
     * @return
     */
    public void navigateToProfile() {
        String link = page.getNavigationBarProfileElement().getAttribute("href");
        device.getDriver().get(link);
    }

    /**
     * Get logged in user profile & reviews
     *
     * @return
     */
    public void navigateToProfileReviews() {
        String link = page.getNavigationBarProfileElement().getAttribute("href");
        device.getDriver().get(link + "/reviews");
    }

    /**
     * Verifies if user is logged in
     * @return
     */
    public boolean isLoggedIn() {
        WebDriverWait wait = new WebDriverWait(device.getDriver(), 15);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(page.getNavigationBarProfileElement(), "href"));
        return page.getNavigationBarProfileElement().getAttribute("href") != null;
    }

}
