package impl.facebook.login;

import io.cify.framework.core.Device;

/**
 * Created by FOB Solutions
 */
public class FacebookLoginActions {

    private FacebookLoginPage page;

    public FacebookLoginActions(Device device) {
        this.page = new FacebookLoginPage(device);
    }

    /**
     * Checks if Facebook login form is displayed
     * @return
     */
    public boolean isFacebookLoginDisplayed() {
        return page.getLoginForm().isDisplayed();
    }

    /**
     * Enters credentials to login form
     * @param email
     * @param password
     */
    public void enterCredentials(String email, String password) {
        page.getEmailField().sendKeys(email);
        page.getPasswordField().sendKeys(password);
    }

    /**
     * Submits login form
     */
    public void submitLogin() {
        page.getLoginButton().click();
    }
}
