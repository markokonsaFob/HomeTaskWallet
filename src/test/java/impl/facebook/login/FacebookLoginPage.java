package impl.facebook.login;

import io.cify.framework.PageObjects;
import io.cify.framework.core.Device;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by FOB Solutions
 */
class FacebookLoginPage extends PageObjects {

    @FindBy(id = "login_form")
    private WebElement loginForm;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    FacebookLoginPage(Device device) {
        super(device);
    }

    WebElement getLoginForm() {
        return loginForm;
    }

    WebElement getEmailField() {
        return emailField;
    }

    WebElement getPasswordField() {
        return passwordField;
    }

    WebElement getLoginButton() {
        return loginButton;
    }
}
