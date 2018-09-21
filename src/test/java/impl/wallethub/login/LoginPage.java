package impl.wallethub.login;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by FOB Solutions
 */
class LoginPage extends PageObjects {

    @FindBy(css = "form[ng-submit='doLogin($event)']")
    private WebElement loginForm;

    private By emailLocator = By.name("em");
    private By passwordLocator = By.name("pw");

    LoginPage(Device device) {
        super(device);
    }

    WebElement getEmailField() {
        return loginForm.findElement(emailLocator);
    }

    WebElement getPasswordField() {
        return loginForm.findElement(passwordLocator);
    }

    WebElement getLoginForm() {
        return loginForm;
    }
}
