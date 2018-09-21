package impl.wallethub.common.navbar;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by FOB Solutions
 */
class NavigationBarPage extends PageObjects {

    @FindBy(css = "a[class='login']")
    private WebElement loginButton;

    @FindBy(id = "m-user")
    private WebElement userNavigationElement;

    NavigationBarPage(Device device) {
        super(device);
    }

    WebElement getLoginButton() {
        return loginButton;
    }

    WebElement getNavigationBarProfileElement() {
        int profile = 0;
        return userNavigationElement.findElements(By.tagName("li")).get(profile).findElement(By.tagName("a"));
    }
}
